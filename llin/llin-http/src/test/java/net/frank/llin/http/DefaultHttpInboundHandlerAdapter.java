package net.frank.llin.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponse;

public class DefaultHttpInboundHandlerAdapter extends ChannelInboundHandlerAdapter{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpResponse) {
			HttpResponse response = (HttpResponse) msg;
			log.debug("CONTENT_TYPE:" + response.headers().get(HttpHeaderNames.CONTENT_TYPE));
		}
		if (msg instanceof HttpContent) {
			HttpContent content = (HttpContent) msg;
			ByteBuf buf = content.content();
			log.debug(buf.toString(io.netty.util.CharsetUtil.UTF_8));
			buf.release();
		}
	}
}