package net.frank.corejava0.netty.ch12.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.ScheduledFuture;
import net.frank.corejava0.netty.ch12.Constants;
import net.frank.corejava0.netty.ch12.Header;
import net.frank.corejava0.netty.ch12.NettyMessage;

public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	private volatile ScheduledFuture<?> heartBeat;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		NettyMessage message = (NettyMessage) msg;
		if(message.getHeader()!=null 
				&& Constants.MessageType.LOGIN_RESP == message.getHeader().getType()) {
			heartBeat = ctx.executor().scheduleAtFixedRate(
					new HeartBeatTask(ctx), 0,5000, TimeUnit.MILLISECONDS);
		}else if(message.getHeader()!=null
				&& Constants.MessageType.HEART_RESP == message.getHeader().getType()) {
			log.info("Client receive server heart beat message : ---> " +message);
		}else {
			ctx.fireChannelRead(msg);
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception{
		if(heartBeat != null) {
			heartBeat.cancel(true);
			heartBeat = null;
		}
		ctx.fireExceptionCaught(cause);
	}
	
	
	
	
	private class HeartBeatTask implements Runnable{
		
		private final ChannelHandlerContext ctx;
		
		public HeartBeatTask(ChannelHandlerContext ctx) {
			this.ctx = ctx;
		}
		
		@Override
		public void run() {
			NettyMessage heartBeat = buildHeartBeat();
			log.info("Client send heart beat message to server : --->" + heartBeat );
			ctx.writeAndFlush(heartBeat);
		}
		
		private NettyMessage buildHeartBeat(){
			NettyMessage message = new NettyMessage();
			Header header = new Header();
			header.setType(Constants.MessageType.HEART_REQ);
			message.setHeader(header);
			return message;
		}	
	}
}
