package net.frank.llin.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.util.concurrent.Future;

import net.frankllin.commons.IClient;

public interface MqttClient extends IClient {

	/**
	 * 连接指定的mqtt服务器，指定的端口是1883
	 * 
	 * @param host
	 * @return
	 */
	Future<MqttConnectResult> connect(String host);

	/**
	 * 连接指定的mqtt服务器
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	Future<MqttConnectResult> connect(String host, int port);

	/**
	 * 获取 netty {@link EventLoopGroup}
	 * 
	 * @return
	 */
	EventLoopGroup getEventLoop();

	/**
	 * 设置 netty {@link EventLoopGroup}
	 *
	 * @param eventLoop
	 */
	void setEventLoop(EventLoopGroup eventLoop);

	/**
	 * 订阅一个主题 可以是 1）完整的主题名 2）带多层通配符“#”过滤 3）带单层通配符“+”过滤 4）带通配符“$”过滤
	 * 
	 * 当收到消息时，会触发handler定义的方法
	 *
	 * @param topic
	 *            The topic filter to subscribe to
	 * @param handler
	 *            The handler to invoke when we receive a message
	 * @return
	 */
	Future<Void> on(String topic, MqttHandler handler);

	/**
	 * 订阅一个主题，带qos定义
	 * 
	 * 当收到消息时，会触发handler定义的方法
	 * 
	 * @param topic
	 * @param handler
	 * @param qos
	 *            The qos to request to the server
	 * @return
	 */
	Future<Void> on(String topic, MqttHandler handler, MqttQoS qos);

	/**
	 * 订阅一个主题，只会执行一次
	 *
	 * @param topic
	 * @param handler
	 * @return
	 */
	Future<Void> once(String topic, MqttHandler handler);

	/**
	 * 订阅一个主题，只会执行一次，带qos定义
	 *
	 * @param topic
	 * @param handler
	 * @return
	 */
	Future<Void> once(String topic, MqttHandler handler, MqttQoS qos);

	/**
	 * 移除一个指定的定阅
	 *
	 * @param topic
	 * @param handler
	 * @return
	 */
	Future<Void> off(String topic, MqttHandler handler);

	/**
	 * 移除所有的定阅
	 *
	 * @param topic
	 * @return
	 */
	Future<Void> off(String topic);

	/***
	 * 在指定的主题发布一条消息
	 * 
	 * @param topic
	 * @param payload
	 * @return
	 */

	Future<Void> publish(String topic, ByteBuf payload);

	/***
	 * 在指定的主题发布一条消息,并指定qos
	 * 
	 * @param topic
	 * @param payload
	 * @param qos
	 * @return
	 */
	Future<Void> publish(String topic, ByteBuf payload, MqttQoS qos);

	/***
	 * 在指定的主题发布一条消息,并指定是否保留
	 * 
	 * @param topic
	 * @param payload
	 * @param retain
	 * @return
	 */
	Future<Void> publish(String topic, ByteBuf payload, boolean retain);

	/***
	 * 在指定的主题发布一条消息,并指定是否保留
	 * 
	 * @param topic
	 * @param payload
	 * @param qos
	 * @param retain
	 * @return
	 */

	Future<Void> publish(String topic, ByteBuf payload, MqttQoS qos, boolean retain);

	/**
	 * 获取客户端配制
	 * 
	 * @return The {@link MqttClientConfig} instance we use
	 */
	MqttClientConfig getClientConfig();

	/**
	 * 构造一个客户端使用默认配制
	 */
	static MqttClient create() {
		return new MqttClientImpl();
	}

	/**
	 * 构造一个客户端使用指定配制
	 */
	static MqttClient create(MqttClientConfig config) {
		return new MqttClientImpl(config);
	}
}