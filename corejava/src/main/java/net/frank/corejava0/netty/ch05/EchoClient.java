package net.frank.corejava0.netty.ch05;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {
	
	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>(){
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
						ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
						ch.pipeline().addLast(new StringDecoder());
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
							private int counter;
							static final String ECHO_REQ = "Hi, Frank. Welcome to Netty.$_";
							@Override
						    public void channelActive(ChannelHandlerContext ctx) throws Exception {
						        //super.channelActive(ctx);
						        for(int i=0;i<10;i++){
						        	ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
						        }
						    }
							
							@Override
							public void channelRead(ChannelHandlerContext ctx,Object msg){
								System.out.println("This is " + ++counter + " times receive server : [" +msg+"]");
							}
							
							@Override
							public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
								cause.printStackTrace();
								ctx.close();
							}
						});
					}			
				});
			ChannelFuture f = b.connect(host,port).sync();
			f.channel().closeFuture().sync();
		}finally{
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args)throws Exception{
		int port = 8080;
		if(args!=null && args.length>0){
			try{
				port = Integer.valueOf(args[0]);
			}catch(NumberFormatException e){
				
			}
		}
		new EchoClient().connect(port,"localhost");
	}
	
}
