package net.frank.llin.http;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class VedioStreamHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
	
	static Map<String,ChannelHandlerContext> clientMap = new HashMap<>();
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		
		String clientId = ctx.channel().id().asLongText();
		log.debug("Variable [clientId] -> " + clientId);
		log.debug("Input Param [msg] -> " + msg.toString());
		for(Iterator<String> it = clientMap.keySet().iterator();it.hasNext();) {
			String sessionClientId = it.next();
			if(!clientId.equals(sessionClientId)) {
				log.debug("Send Message to " + sessionClientId);
				clientMap.get(sessionClientId).writeAndFlush(msg);
			}
		}
	}
	
	@Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        String clientId = ctx.channel().id().asLongText();
		System.out.println("handlerAddred " + clientId);
        clientMap.put(clientId, ctx);
    }
 
    /**
     * 连接关闭时
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    	String clientId = ctx.channel().id().asLongText();
        System.out.println("handlerRemoved " + clientId);
        if(clientMap.get(clientId)!=null) {
        	clientMap.remove(clientId);
        }
    }
}