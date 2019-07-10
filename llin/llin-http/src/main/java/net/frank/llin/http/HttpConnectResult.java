package net.frank.llin.http;

import io.netty.channel.ChannelFuture;

public final class HttpConnectResult {

	private final boolean success;

	private final ChannelFuture closeFuture;

	public HttpConnectResult(boolean success, ChannelFuture closeFuture) {
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