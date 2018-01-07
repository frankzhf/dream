package net.frank.corejava0.netty.ch08;

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
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import net.frank.corejava0.netty.ch08.protobuf.SubscribeProto.SubscribeReq;
import net.frank.corejava0.netty.ch08.protobuf.SubscribeProto.SubscribeResp;

public class SubReqServer {
	
	public void bind(int port) throws Exception{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 100)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
						ch.pipeline().addLast(new ProtobufDecoder(SubscribeReq.getDefaultInstance()));
						ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
						ch.pipeline().addLast(new ProtobufEncoder());
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
							public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
								SubscribeReq req = (SubscribeReq) msg;
								if("Lilinfeng".equalsIgnoreCase(req.getUserName())) {
									System.out.println("Service accept client subscribe req : [" 
											+ req.toString() + "]");
									ctx.writeAndFlush(resp(req.getSubReqId()));
								}
								
						    }
							private SubscribeResp resp(int subReqId) {
								return SubscribeResp.newBuilder().setSubReqId(subReqId)
									.setRespCode(0)
									.setDesc("Netty book order success, 3 days later, sent to the designated address")
									.build();
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
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		}finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
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
		new SubReqServer().bind(port);
	}

}
