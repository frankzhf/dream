package net.frank.llin.http;

import java.net.URI;
import java.util.Map;

import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.concurrent.Future;

public interface HttpClient {

	/***
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	Future<HttpConnectResult> connect(String host, int port, HttpHandler tcpHandler);

	/**
	 * 获取 netty {@link EventLoopGroup}
	 * 
	 * @return
	 */
	EventLoopGroup getEventLoop();

	/**
	 * 设置 netty {@link EventLoopGroup}
	 *
	 * @param eventLoop
	 */
	void setEventLoop(EventLoopGroup eventLoop);

	public ChannelFuture sendAndFlushPacket(URI url, HttpMethod method, Map<String, String> param);

}
