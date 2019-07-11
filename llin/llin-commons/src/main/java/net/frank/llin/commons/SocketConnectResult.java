package net.frank.llin.commons;

import io.netty.channel.ChannelFuture;

public class SocketConnectResult {
	private final boolean success;

	private final ChannelFuture closeFuture;

	public SocketConnectResult(boolean success, ChannelFuture closeFuture) {
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
