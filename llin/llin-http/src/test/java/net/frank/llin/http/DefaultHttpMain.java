package net.frank.llin.http;

import java.net.URI;
import java.net.URISyntaxException;


import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.util.concurrent.Promise;

public class DefaultHttpMain {
	public static void main(String[] args) {
		HttpClient httpClient = new HttpClientImpl();
		httpClient.connect("127.0.0.1", 8080, new HttpHandler() {
			@Override
			public void getPacketChannel(SocketChannel ch,
					Promise<HttpConnectResult> connectFuture) {
				ch.pipeline().addLast( new DefaultHttpInboundHandlerAdapter());
			}
		});
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URI uri = null;
		try {
			uri = new URI("http://127.0.0.1:8080/icloud/demo/ping");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        // 构建http请求
        //request.headers().set(HttpHeaderNames.HOST, "127.0.0.1");
        //request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        //request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
		httpClient.sendAndFlushPacket(uri, HttpMethod.POST, null);
	}
}