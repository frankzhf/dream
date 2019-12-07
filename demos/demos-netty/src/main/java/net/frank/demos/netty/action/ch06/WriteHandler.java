package net.frank.demos.netty.action.ch06;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


/**
 * 缓存一个通道上下文
 */

public class WriteHandler extends ChannelHandlerAdapter {
	
	private ChannelHandlerContext ctx;
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}
	
	public void send(String msg) {
		ctx.writeAndFlush(msg);
	}
	
	
}
