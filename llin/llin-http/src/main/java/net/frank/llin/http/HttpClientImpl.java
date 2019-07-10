package net.frank.llin.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;

import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

public class HttpClientImpl implements HttpClient {

	private Logger log = LoggerFactory.getLogger(getClass());

	private EventLoopGroup eventLoop;

	private Channel channel;

	public Future<HttpConnectResult> connect(String host, int port, HttpHandler httpHandler) {
		if (this.eventLoop == null) {
			this.eventLoop = new NioEventLoopGroup();
		}
		Promise<HttpConnectResult> connectFuture = new DefaultPromise<HttpConnectResult>(this.eventLoop.next());
		Bootstrap bootstrap = new Bootstrap();
		bootstrap.group(this.eventLoop);
		bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		bootstrap.channel(NioSocketChannel.class);
		bootstrap.remoteAddress(host, port);
		bootstrap.handler(new HttpChannelInitializer(connectFuture, httpHandler));
		ChannelFuture future = bootstrap.connect();
		future.addListener((ChannelFutureListener) f -> HttpClientImpl.this.channel = f.channel());
		return connectFuture;
	}

	public EventLoopGroup getEventLoop() {
		return eventLoop;
	}

	public void setEventLoop(EventLoopGroup eventLoop) {
		this.eventLoop = eventLoop;
	}

	private class HttpChannelInitializer extends ChannelInitializer<SocketChannel> {

		private final Promise<HttpConnectResult> connectFuture;

		private HttpHandler httpHandler;

		HttpChannelInitializer(Promise<HttpConnectResult> connectFuture, HttpHandler httpHandler) {
			this.connectFuture = connectFuture;
			this.httpHandler = httpHandler;
		}

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ch.pipeline().addLast("logging", new LoggingHandler(LogLevel.INFO));
			ch.pipeline().addLast(new HttpResponseDecoder());
			ch.pipeline().addLast(new HttpRequestEncoder());
			httpHandler.getPacketChannel(ch, connectFuture);
		}
	}

	@Override
	public ChannelFuture sendAndFlushPacket(URI uri, HttpMethod method, Map<String, String> params) {
		if (this.channel == null) {
			return null;
		}
		if (this.channel.isActive()) {
			DefaultFullHttpRequest request = null;
			try {
				request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, method, uri.toASCIIString(),
						Unpooled.wrappedBuffer("id=1000".getBytes("UTF-8")));
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage(), e);
			}

			if (request != null) {
				request.headers().set(HttpHeaderNames.HOST, uri.getHost());
				request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
				request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
				return this.channel.writeAndFlush(request);
			}
			return null;
		}
		return this.channel.newFailedFuture(new RuntimeException("Channel is closed"));
	}

}