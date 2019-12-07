package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 使用@Sharable的典型错误场景
 *
 */

@Sharable
public class UnsharableHandler extends ChannelInboundHandlerAdapter {
	
	private int count;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		count ++;
		System.out.println("inboundBufferUpdated(...) called the " 
				+ count + " time");
		ctx.fireChannelRead(msg);
	}
	
	
}
