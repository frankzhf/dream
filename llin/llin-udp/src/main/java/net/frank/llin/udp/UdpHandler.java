package net.frank.llin.udp;

import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.concurrent.Promise;

public interface UdpHandler {
	public void getPacketChannel(NioDatagramChannel ch,
			Promise<UdpConnectResult> connectFuture);
}
