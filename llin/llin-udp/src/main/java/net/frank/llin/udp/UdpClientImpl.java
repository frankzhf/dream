package net.frank.llin.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

public class UdpClientImpl implements UdpClient {

private EventLoopGroup eventLoop;
	
	private Channel channel;
	
	@Override
	public Future<UdpConnectResult> connect(String host, int port, UdpHandler udpHandler) {
		if (this.eventLoop == null) {
			this.eventLoop = new NioEventLoopGroup();
		}
		Promise<UdpConnectResult> connectFuture = new DefaultPromise<UdpConnectResult>(this.eventLoop.next());
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(eventLoop);
		bootstrap.channel(NioDatagramChannel.class);
		bootstrap.remoteAddress(host, port);
		bootstrap.handler(new UdpChannelInitializer(connectFuture,udpHandler));
		ChannelFuture future = bootstrap.connect();
		future.addListener((ChannelFutureListener) f -> UdpClientImpl.this.channel = f.channel());
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
	
	
	private class UdpChannelInitializer extends ChannelInitializer<NioDatagramChannel> {

		private final Promise<UdpConnectResult> connectFuture;
		
		private UdpHandler udpHandler;

		UdpChannelInitializer(Promise<UdpConnectResult> connectFuture,UdpHandler udpHandler) {
			this.connectFuture = connectFuture;
			this.udpHandler = udpHandler;
		}

		@Override
		protected void initChannel(NioDatagramChannel ch) throws Exception {
			ch.pipeline().addLast("logging",new LoggingHandler(LogLevel.INFO));
			ch.pipeline().addLast(new IdleStateHandler(30, 30, 0));
			udpHandler.getPacketChannel(ch, connectFuture);
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
