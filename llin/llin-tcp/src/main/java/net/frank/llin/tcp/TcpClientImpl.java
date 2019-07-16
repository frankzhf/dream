package net.frank.llin.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public class TcpClientImpl implements TcpClient {

private EventLoopGroup eventLoop;
	
	private Channel channel;
	
	@Override
	public Future<SocketConnectResult> connect(String host, int port, TcpHandler tcpHandler) {
		if (this.eventLoop == null) {
			this.eventLoop = new NioEventLoopGroup();
		}
		Promise<SocketConnectResult> connectFuture = new DefaultPromise<SocketConnectResult>(this.eventLoop.next());
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(this.eventLoop);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.remoteAddress(host, port);
		bootstrap.handler(new TcpChannelInitializer(connectFuture,tcpHandler));
		ChannelFuture future = bootstrap.connect();
		future.addListener((ChannelFutureListener) f -> TcpClientImpl.this.channel = f.channel());
		
		return connectFuture;
	}

	@Override
	public EventLoopGroup getEventLoop() {
		return eventLoop;
	}

	@Override
	public void setEventLoop(EventLoopGroup eventLoop) {
		this.eventLoop = eventLoop;
	}
	
	
	private class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {

		private final Promise<SocketConnectResult> connectFuture;
		
		private TcpHandler tcpHandler;

		TcpChannelInitializer(Promise<SocketConnectResult> connectFuture,TcpHandler tcpHandler) {
			this.connectFuture = connectFuture;
			this.tcpHandler = tcpHandler;
		}

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline().addLast("logging",new LoggingHandler(LogLevel.INFO));
			ch.pipeline().addLast(new IdleStateHandler(30, 30, 0));
			tcpHandler.getPacketChannel(ch, connectFuture);
		}
	}
	
	
	@Override
	public ChannelFuture sendAndFlushPacket(Object message) {
		if (this.channel == null) {
			return null;
		}
		if (this.channel.isActive()) {
			return this.channel.writeAndFlush(message);
		}
		return this.channel.newFailedFuture(new RuntimeException("Channel is closed"));
	}

	@Override
	public int statusCode() {
		if (this.channel == null) {
			return STATUS_CODE.INIT;
		}
		if (this.channel.isActive()) {
			return STATUS_CODE.ON_LINE;
		}else {
			return STATUS_CODE.OFF_LINE;
		}
	}

}
