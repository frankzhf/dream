package net.frank.llin.server;

import io.netty.channel.ChannelPipeline;
import io.netty.util.concurrent.Promise;
import net.frank.llin.commons.SocketConnectResult;

public interface ChannelRegister {

	void register(ChannelPipeline cp,
			Promise<SocketConnectResult> connectFuture);
}
