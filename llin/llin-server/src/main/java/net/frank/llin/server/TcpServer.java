package net.frank.llin.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.llin.commons.SocketConnectResult;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;

public class TcpServer {

	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	public Promise<SocketConnectResult> bind(int port, ChannelRegister cr) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		Promise<SocketConnectResult> connectFuture = new DefaultPromise<SocketConnectResult>(bossGroup.next());
		
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
			.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
					cr.register(ch.pipeline(),connectFuture);
				}
			});
		log.debug("Port ->" +port);
		b.bind(port);
		return connectFuture;
	}
}