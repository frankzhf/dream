package net.frank.corejava0.netty.ch09;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println(msg);
		SubResponse sub = new SubResponse();
        sub.setDesc("desc");
        sub.setSubScriptID(999);
        sub.setRespCode("0");
        ctx.writeAndFlush(sub);	
    }

	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
		cause.printStackTrace();
		ctx.close();
    }
}
