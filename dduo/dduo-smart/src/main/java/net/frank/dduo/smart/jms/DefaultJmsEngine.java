package net.frank.dduo.smart.jms;

import java.util.List;
import java.util.Properties;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import net.frank.dduo.smart.core.engine.AbstractEngine;
import net.frank.dduo.smart.core.engine.AbstractJob;
import net.frank.dduo.smart.core.entity.Device;
import net.frank.dduo.smart.core.entity.PoolConfig;
import net.frank.dduo.smart.core.entity.QueueConfig;
import net.frank.dduo.smart.core.util.JsonUtil;

public class DefaultJmsEngine extends AbstractEngine {

	protected QueueConfig from;

	protected QueueConfig to;
	
	private DefaultMQPushConsumer consumer;
	
	private DefaultMQProducer producer;
	
	public DefaultJmsEngine(Device device, PoolConfig poolConfig, Properties properties) {
		super(device, poolConfig, properties);
	}

	@Override
	public void start(Device device, Properties properties) {
		
		String queueFromJson = properties.getProperty(device.getGatewayId() + ".queue.from");
		from = JsonUtil.fromJson(queueFromJson, QueueConfig.class);
		String queueToJson = properties.getProperty(device.getGatewayId() + ".queue.to");
		to = JsonUtil.fromJson(queueToJson, QueueConfig.class);
		consumer = new DefaultMQPushConsumer(
				from.getGroupId() + "-" + from.getQueueName());
		consumer.setMessageModel(MessageModel.CLUSTERING);
		consumer.setNamesrvAddr(from.getIp() + ":" + from.getPort());
		
		producer = new DefaultMQProducer(
				to.getGroupId() + "-" +to.getQueueName());
		producer.setNamesrvAddr(to.getIp()+":"+to.getPort());
		try {
			producer.start();
			consumer.subscribe(from.getQueueName(), "");
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
			consumer.registerMessageListener(new MessageListenerConcurrently() {
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
						ConsumeConcurrentlyContext Context) {
					Message msg = list.get(0);
					AbstractJob job = prepareJob(producer,msg);
					executeJob(job);
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});
			consumer.start();
		} catch (MQClientException e) {
			log.error(e.getMessage(),e);
		}
	}

	@Override
	public void end(Device device, Properties properties) {
		if(producer!=null){
			producer.shutdown();
		}
		if(consumer!=null){
			consumer.shutdown();
		}
	}
	
	protected AbstractJob prepareJob(DefaultMQProducer producer,Message msg) {
		return new DefaultJmsJob(producer,msg);
	}
	
}