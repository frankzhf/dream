package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/***
 * 入站异常处理
 */

public class InboundExceptionHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,
			Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
