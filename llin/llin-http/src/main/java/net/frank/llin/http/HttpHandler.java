package net.frank.llin.http;

import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.Promise;

public interface HttpHandler {
	public void getPacketChannel(SocketChannel ch,
			Promise<HttpConnectResult> connectFuture);
}
