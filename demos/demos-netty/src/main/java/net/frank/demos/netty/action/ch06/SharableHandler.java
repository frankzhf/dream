package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Sharable
public class SharableHandler extends ChannelInboundHandlerAdapter {
	
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		System.out.println("channel read message " + msg);
		ctx.fireChannelRead(msg);
	}
	
}
