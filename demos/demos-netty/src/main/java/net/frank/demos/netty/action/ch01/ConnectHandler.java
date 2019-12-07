package net.frank.demos.netty.action.ch01;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ConnectHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println("Client " +ctx.channel().remoteAddress() + " connected");
    }

}
