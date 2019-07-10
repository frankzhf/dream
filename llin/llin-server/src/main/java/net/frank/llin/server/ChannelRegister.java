package net.frank.llin.server;

import io.netty.channel.ChannelPipeline;

public interface ChannelRegister {

	void register(ChannelPipeline cp);
}
