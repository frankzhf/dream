package net.frank.corejava0.netty.ch12.handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.frank.corejava0.netty.ch12.Constants;
import net.frank.corejava0.netty.ch12.Header;
import net.frank.corejava0.netty.ch12.NettyMessage;

public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception{
		ctx.writeAndFlush(buildLoginReq());
	}

	private Object buildLoginReq() {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType((byte)3);
		message.setHeader(header);
		return message;
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
		NettyMessage message =(NettyMessage) msg;
		if(message.getHeader()!=null && 
				Constants.MessageType.LOGIN_RESP == message.getHeader().getType()) {
			byte loginResult = (byte) message.getBody();
			if(Constants.BooleanResult.TRUE != loginResult) {
				ctx.close();
			}else {
				log.info("Login is ok : " + message);
				ctx.fireChannelRead(msg);
			}
		}else {
			ctx.fireChannelRead(msg);
		}
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception{
		ctx.fireExceptionCaught(cause);
	}
	
	
}
