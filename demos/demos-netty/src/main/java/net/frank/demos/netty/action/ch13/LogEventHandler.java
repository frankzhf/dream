package net.frank.demos.netty.action.ch13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogEventHandler extends SimpleChannelInboundHandler<LogMsg> {

    @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx,Throwable cause) throws Exception{
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, LogMsg event) throws Exception{
        StringBuilder builder = new StringBuilder();
        builder.append(event.getTime());
        builder.append(" [");
        builder.append(event.getSource().toString());
        builder.append("]:[");
        builder.append(event.getMsgId());
        builder.append("]: ");
        builder.append(event.getMsg());
        System.out.println(builder.toString());
    }

}
