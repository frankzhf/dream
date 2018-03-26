package net.frank.corejava0.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class TheMomentServer {
	public static void main(String[] args) throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
				.channel(NioDatagramChannel.class)
				.localAddress(9876)
				.handler(new TheMomentServerHandler());
			b.bind(9876).sync().channel().closeFuture().await();
		} finally {
			group.shutdownGracefully();
		}
	}
}
