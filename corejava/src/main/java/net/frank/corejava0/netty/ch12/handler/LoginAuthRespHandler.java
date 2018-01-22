package net.frank.corejava0.netty.ch12.handler;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.frank.corejava0.netty.ch12.Constants;
import net.frank.corejava0.netty.ch12.Header;
import net.frank.corejava0.netty.ch12.NettyMessage;

public class LoginAuthRespHandler extends ChannelInboundHandlerAdapter{
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	private Map<String,Boolean> nodeCheck = new ConcurrentHashMap<String,Boolean>();
	
	private String[] whiteList = {"127.0.0.1","192.168.1.104"};
	
	@Override
	public void channelRead(ChannelHandlerContext ctx,Object msg)throws Exception{
		NettyMessage message = (NettyMessage)msg;
		if(message.getHeader()!=null 
				&& Constants.MessageType.LOGIN_REQ == message.getHeader().getType()) {
			String nodeIndex = ctx.channel().remoteAddress().toString();
			NettyMessage loginResp = null;
			if(nodeCheck.containsKey(nodeIndex)) {//判断已经登录
				buildResponse((byte)-1);
			}else{
				InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
				String ip = address.getAddress().getHostAddress();
				boolean isOK = false;
				for(String wip : whiteList) {
					if(wip.equals(ip)) {
						isOK = true;
						break;
					}
				}
				loginResp = isOK ? buildResponse((byte)0) 
						: buildResponse((byte) -1);
				if(isOK) {
					nodeCheck.put(nodeIndex, true);
				}
			}
			log.info("The login response is : " + loginResp);
			ctx.writeAndFlush(loginResp);
		}else {
			ctx.fireChannelRead(msg);
		}
	}
	
	private NettyMessage buildResponse(byte result) {
		NettyMessage message = new NettyMessage();
		Header header = new Header();
		header.setType(Constants.MessageType.LOGIN_RESP);
		message.setHeader(header);
		message.setBody(result);
		return message;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) {
		nodeCheck.remove(ctx.channel().remoteAddress().toString());
		ctx.close();
		ctx.fireExceptionCaught(cause);
	}
	
}
