package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

public class DiscardOutboundHandler 
	extends ChannelOutboundHandlerAdapter {
	
	@Override
	public void write(ChannelHandlerContext ctx,
			Object msg, ChannelPromise promise) {
		
		
		
		//如果这个出站消息不需要被后面的handlers处理
		ReferenceCountUtil.release(msg);
		promise.setSuccess(); //通知ChannelPromise数据已经被处理
	}

}
