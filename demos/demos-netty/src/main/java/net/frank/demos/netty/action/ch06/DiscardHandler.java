package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardHandler 
		extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		
		//需要释放消息资
		ReferenceCountUtil.release(msg);
	}
	

}
