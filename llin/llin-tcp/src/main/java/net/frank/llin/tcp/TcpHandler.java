package net.frank.llin.tcp;

import io.netty.channel.socket.SocketChannel;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public interface TcpHandler {
	public void getPacketChannel(SocketChannel ch,
			Promise<SocketConnectResult> connectFuture);
}
