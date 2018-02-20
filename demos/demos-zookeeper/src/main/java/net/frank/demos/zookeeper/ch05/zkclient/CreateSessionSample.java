package net.frank.demos.zookeeper.ch05.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateSessionSample {
	
	private static Logger log = LoggerFactory.getLogger(CreateSessionSample.class);
	
	public static void main(String[] args) {
		ZkClient client = new ZkClient("localhost:2181", 5000);
		log.debug("Varable [client] -> "+client);
	}

}
