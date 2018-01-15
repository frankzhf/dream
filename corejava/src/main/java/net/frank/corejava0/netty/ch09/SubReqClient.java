package net.frank.corejava0.netty.ch09;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class SubReqClient {
	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();	
		try {
			Bootstrap boot = new Bootstrap();
			boot.group(group)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
						ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
						ch.pipeline().addLast(new SubReqClientHandler());
					}
				});
			ChannelFuture f = boot.connect(host,port).sync();
			f.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully();
		
		}
		
	}
	
	
	public static void main(String[] args)throws Exception {
		int port = 8080;
		if(args!=null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e) {
				port = 8080;
			}
		}
		new SubReqClient().connect(port,"127.0.0.1");
	}
}
