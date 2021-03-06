package net.frank.corejava0.netty.ch04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
	
	private int counter;
	
	private byte[] req;
	
	public TimeClientHandler(){
		req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx){
		ByteBuf msg = null;
		for(int i=0;i<100;i++){
			msg = Unpooled.buffer(req.length);
			msg.writeBytes(req);
			ctx.writeAndFlush(msg);
		}
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)
		throws Exception{
		String body = (String)msg;
		System.out.println("Now is: " + body + " ; the counter is : " + ++counter );
	}
}
