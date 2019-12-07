package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardInboundHandler extends ChannelInboundHandlerAdapter{
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		
		//做完逻辑后要释放资源
		ReferenceCountUtil.release(msg);
	}
	
}
