package net.frank.llin.udp;

import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public interface UdpHandler {
	public void getPacketChannel(NioDatagramChannel ch,
			Promise<SocketConnectResult> connectFuture);
}
