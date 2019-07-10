package net.frank.llin.mqtt;

import io.netty.buffer.ByteBuf;

public interface MqttHandler {
	void onMessage(String topic, ByteBuf payload);
}