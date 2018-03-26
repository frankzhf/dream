package net.frank.corejava0.netty.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class TheMomentClientHandler extends SimpleChannelInboundHandler<DatagramPacket>  {

	@Override
	public void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
		String response = packet.content().toString(CharsetUtil.UTF_8);
        if (response.startsWith("QOTM: ")) {
            System.out.println("Quote of the Moment: " + response.substring(6));
            ctx.close();
        }
        System.out.println("client receive message from the server");
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
