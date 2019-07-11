package net.frank.llin.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public class UdpServer {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());

	public Promise<SocketConnectResult> bind(int port, ChannelRegister cr) {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Promise<SocketConnectResult> connectFuture = new DefaultPromise<SocketConnectResult>(workerGroup.next());
		Bootstrap b = new Bootstrap();
		b.group(workerGroup).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST,true)
				.handler(new ChannelInitializer<NioDatagramChannel>() {
					@Override
					protected void initChannel(NioDatagramChannel ch) throws Exception {
						ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
						//ch.pipeline().addLast(new IdleStateHandler(30, 0, 0));
						//ch.pipeline().addLast(new StringEncoder());
						//ch.pipeline().addLast(new StringDecoder());
						cr.register(ch.pipeline(),connectFuture);
					}
				});
		log.debug("Port ->" +port);
		b.bind(port);
		//ChannelFuture future = b.bind(port);
		//future.addListener((ChannelFutureListener) f -> UdpServer.this.channel = f.channel());
		return connectFuture;
	}

}
