package net.frank.corejava0.netty.ch07;

import java.util.List;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MpEchoServer {
	public void bind(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 100)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast("frameDecorder",new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
						ch.pipeline().addLast("msgpack decoder",new MsgpackDecoder());
						ch.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
						ch.pipeline().addLast("msgpack encoder",new MsgpackEncoder());
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
							@Override  
						    public void channelRead(ChannelHandlerContext ctx, Object msg)  
						            throws Exception {
								@SuppressWarnings("unchecked")
								UserInfo userInfo = (UserInfo)msg;
								System.out.println("Recived client msg : " + userInfo);
								//for(int i=0;i<infos.size();i++) {
									//System.out.println("Send " + i+ " UserInfo : " + infos.get(i) );
									ctx.writeAndFlush(userInfo);
								//}
								//ctx.writeAndFlush(infos);
						    }  
							@Override
							public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
								cause.printStackTrace();
								ctx.close();
							}
						});
					}
				});
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8080;
		if(args!=null && args.length>0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		new MpEchoServer().bind(port);
	}
}