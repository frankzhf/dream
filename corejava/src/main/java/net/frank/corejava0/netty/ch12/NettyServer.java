package net.frank.corejava0.netty.ch12;

import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;
import net.frank.corejava0.netty.ch12.handler.HeartBeatRespHandler;
import net.frank.corejava0.netty.ch12.handler.LoginAuthRespHandler;

public class NettyServer {
	public void bind(int port)throws Exception{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 100)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						final MarshallerFactory marshallerFactory = Marshalling
								.getProvidedMarshallerFactory("serial");
						final MarshallingConfiguration configuration = new MarshallingConfiguration();
						configuration.setVersion(5);
						MarshallerProvider marshallerProvider = new DefaultMarshallerProvider(marshallerFactory,
								configuration);
						UnmarshallerProvider UnmarshallerProvider = new DefaultUnmarshallerProvider(
								marshallerFactory, configuration);
						ch.pipeline().addLast(new MarshallingDecoder(UnmarshallerProvider));
						ch.pipeline().addLast("MessageEncoder", new MarshallingEncoder(marshallerProvider));
						ch.pipeline().addLast("readTimeoutHandler",new ReadTimeoutHandler(50));
						ch.pipeline().addLast(new LoginAuthRespHandler());
						ch.pipeline().addLast("HeartBeatHandler",new HeartBeatRespHandler());
					}
				});
			ChannelFuture f = boot.bind(port).sync();
			f.channel().closeFuture().sync();
		}finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		int port = 8080;
		if(args!=null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e) {
				port = 8080;
			}
		}
		new NettyServer().bind(port);
	}
}