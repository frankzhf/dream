package net.frank.corejava0.netty.ch04;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {
	
	private int counter;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)
		throws Exception{
		String body = (String)msg;
		System.out.println("The time server receive order : " + body + " ; the counter is : " + ++counter);
		String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? 
				new Date().toString()  : "BAD ORDER";
		currentTime = currentTime + System.getProperty("line.separator");
		ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
		ctx.writeAndFlush(resp);
	}
}
