package net.frank.llin.mqtt;

import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class TestMqttClientImpl {
	public static void main(String[] args) {
		//HttpCleint client0 = new HttpClientImpl("19.19.19.19","9999"); // 灯
		//HttpCleint client1 = new HttpClientImpl("19.19.19.20","1099"); // 灯
		
		MqttClientConfig config = new MqttClientConfig();
		config.setUsername("admin");
		config.setPassword("password");
		MqttClient client = MqttClient.create(config);
		
		//client.connect("118.89.179.174");
		client.connect("115.28.183.118", 61613);
		
		
		client.publish("home/appwarehouseuser-003205001", Unpooled.copiedBuffer("{id:100000,text:'告警推给你'}",CharsetUtil.UTF_8));
		/***
		client.on("device/es/001", new MqttHandler() {
			@Override
			public void onMessage(String topic, ByteBuf payload) {
				log.debug("Input Param [topic] " + topic);
				log.debug("Input Param [payload] " + payload);
				String msg = new String(ByteBufUtil.getBytes(payload),Charset.forName("UTF-8"));
				log.debug("Variable [msg] " + msg);
				//		
			}
		});
		***/
	}
}