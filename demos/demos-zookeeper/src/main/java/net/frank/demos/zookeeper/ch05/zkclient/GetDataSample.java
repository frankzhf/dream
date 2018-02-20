package net.frank.demos.zookeeper.ch05.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDataSample {
	
	private static Logger log = LoggerFactory.getLogger(GetDataSample.class);
		
	public static void main(String[] args)throws Exception {
		String path = "/zk-book";
		ZkClient zkClient = new ZkClient("localhost:2181", 5000);
		boolean exists = zkClient.exists(path);
		log.debug("Node ["+path+"] exists? -> " +exists);
		zkClient.createEphemeral(path,"123");
		zkClient.subscribeDataChanges(path, new IZkDataListener() {
			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				log.debug("Node " + dataPath +" changed, new data :" + data);
			}

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				log.debug("Node " + dataPath +" deleted.");
			}
		});
		
		log.debug("Node ["+path+"]'s data -> " +zkClient.readData(path));
		exists = zkClient.exists(path);
		log.debug("Node ["+path+"] exists? -> " +exists);
		zkClient.writeData(path, "456");
		Thread.sleep(1000);
		zkClient.delete(path);
		Thread.sleep(10000);
	}

}
