package net.frank.llin.tcp;

import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.Promise;

public interface TcpHandler {
	public void getPacketChannel(SocketChannel ch,
			Promise<TcpConnectResult> connectFuture);
}
