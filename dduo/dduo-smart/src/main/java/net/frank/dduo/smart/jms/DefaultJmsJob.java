package net.frank.dduo.smart.jms;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import net.frank.dduo.smart.core.engine.AbstractJob;

public class DefaultJmsJob extends AbstractJob {
	
	private DefaultMQProducer producer;
	
	private Message msg;
	
	public DefaultJmsJob(DefaultMQProducer producer,Message msg){
		this.producer = producer;
		this.msg = msg;
	}
	
	
	@Override
	public void run() {
		try {
			producer.send(msg);
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemotingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MQBrokerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
