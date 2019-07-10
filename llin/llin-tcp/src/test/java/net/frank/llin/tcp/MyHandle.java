package net.frank.llin.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MyHandle extends ChannelInboundHandlerAdapter {
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("云平台客户端建立连接");
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("outServer输出" + msg.toString());
	}
}