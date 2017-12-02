package net.frank.corejava0.netty.ch07;

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
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class MpEchoClient {
	private final String host;
	private final int port;
	private final int sendNumber;
	
	public MpEchoClient(String host, int port, int sendNumber) {
		this.host = host;
		this.port = port;
		this.sendNumber = sendNumber;
	}
	
	public void run() throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast("frameDecorder",new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
						ch.pipeline().addLast("msgpack decoder",new MsgpackDecoder());
						ch.pipeline().addLast("frameEncoder",new LengthFieldPrepender(2));
						ch.pipeline().addLast("msgpack encoder",new MsgpackEncoder());
						ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
							@Override
						    public void channelActive(ChannelHandlerContext ctx) throws Exception {
						        UserInfo[] infos = userInfo();
						        for(UserInfo info : infos) {
						        		ctx.write(info);
						        }
						        ctx.flush();
						    }
							
							private UserInfo [] userInfo() {
								UserInfo[] userInfoArray = new UserInfo[sendNumber];
								UserInfo userInfo = null;
								for(int i=0;i<sendNumber;i++) {
									userInfo =new UserInfo();
									userInfo.setAge(i);
									userInfo.setName("ABCDEFG --->" +i);
									userInfoArray[i] = userInfo;
								}
								return userInfoArray;
							}
							
							@Override
							public void channelRead(ChannelHandlerContext ctx,Object msg){
								//UserInfo info = (UserInfo)msg;
								System.out.println("Client receive the msgpack message : " + msg);
								//ctx.write(msg);
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
		}finally {
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
		new MpEchoClient("localhost",port,1000).run();
	}
	
}
