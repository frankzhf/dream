package net.frank.corejava0.netty.ch12.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.frank.corejava0.netty.ch12.Constants;
import net.frank.corejava0.netty.ch12.Header;
import net.frank.corejava0.netty.ch12.NettyMessage;

public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		NettyMessage message = (NettyMessage) msg;
		if(message.getHeader()!=null 
				&& Constants.MessageType.HEART_REQ == message.getHeader().getType() ) {
			log.info("Receive client heart beat message : ---> " + message);
			NettyMessage heartBeat = buildHeartBeat();
			ctx.writeAndFlush(heartBeat);
		}else {
			ctx.fireChannelRead(msg);
		}
	}
	
	private NettyMessage buildHeartBeat() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(Constants.MessageType.HEART_RESP);
		message.setHeader(header);
		return message;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{	
		ctx.fireExceptionCaught(cause);
	}
	
}
