package net.frank.llin.tcp;

import io.netty.channel.ChannelFuture;

public final class TcpConnectResult {
	private final boolean success;

	private final ChannelFuture closeFuture;

	public TcpConnectResult(boolean success, ChannelFuture closeFuture) {
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
