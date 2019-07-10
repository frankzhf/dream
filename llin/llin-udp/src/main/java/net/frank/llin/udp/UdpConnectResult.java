package net.frank.llin.udp;

import io.netty.channel.ChannelFuture;

public final class UdpConnectResult {
	private final boolean success;

	private final ChannelFuture closeFuture;

	public UdpConnectResult(boolean success, ChannelFuture closeFuture) {
		this.success = success;
		this.closeFuture = closeFuture;
	}

	public boolean isSuccess() {
		return success;
	}

	public ChannelFuture getCloseFuture() {
		return closeFuture;
	}
}
