package net.frank.corejava0.netty.ch08;

import java.util.ArrayList;
import java.util.List;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import net.frank.corejava0.netty.ch08.protobuf.SubscribeProto.SubscribeReq;
import net.frank.corejava0.netty.ch08.protobuf.SubscribeProto.SubscribeResp;

public class SubReqClient {
	
	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();	
		try {
			Bootstrap b = new Bootstrap();
			b.group(group)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						ch.pipeline().addLast(new ProtobufDecoder(SubscribeResp.getDefaultInstance()));
						ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						ch.pipeline().addLast(new ProtobufEncoder());
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
							
							
							@Override
							public void channelActive(ChannelHandlerContext ctx) {
								List<String> address = new ArrayList<String>();
								address.add("NanJing YuHuaTai");
								address.add("BeiJing LiuliChang");
								address.add("ShenZhen HongShuLin");
								for(int i=0;i<10;i++) {
									SubscribeReq req = SubscribeReq.newBuilder().setSubReqId(i)
											.setUserName("Lilinfeng")
											.setProductName("Netty Book for Protobuf")
											.addAllAddress(address)
											.build();
									ctx.write(req);
								}
								ctx.flush();
							}
							
							@Override
							public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
								System.out.println("Receive server response : [" +msg+ "]");
							}
							
							@Override
							public void channelReadComplete(ChannelHandlerContext ctx)throws Exception{
								ctx.flush();
							}
							

							@Override
						    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
						            throws Exception {
								cause.printStackTrace();
								ctx.close();
						    }
							
						});
					}
				});
			ChannelFuture f = b.connect(host,port).sync();
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
