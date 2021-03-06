package net.frank.demos.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketServer {
	public void run(int port) throws Exception{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap boot = new ServerBootstrap();
			boot.group(bossGroup,workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast("http-codec",new HttpServerCodec());
						ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
						ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
						ch.pipeline().addLast("handler",new WebSocketServerHandler());
					}
				});
			Channel channel = boot.bind(port).sync().channel();
			channel.closeFuture().sync();
		}finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int port = 8080;
		if(args.length>0) {
			try {
				port = Integer.parseInt(args[0]);
			}catch(NumberFormatException e) {
				port = 8080;
			}
		}
		new WebSocketServer().run(port);
	}
}
