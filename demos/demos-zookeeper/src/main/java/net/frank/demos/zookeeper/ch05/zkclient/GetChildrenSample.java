package net.frank.demos.zookeeper.ch05.zkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetChildrenSample {
	
	private static Logger log = LoggerFactory.getLogger(GetChildrenSample.class);
	
	public static void main(String[] args) throws Exception{
		String path = "/zk-book";
		ZkClient client = new ZkClient("localhost:2181", 5000);
		client.subscribeChildChanges(path, new IZkChildListener() {
			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				log.debug(parentPath+" 's child changed, currentChilds:" + currentChilds);
			}
		});
		
		client.createPersistent(path);
		Thread.sleep(1000);
		log.debug("Varriabe [client.children] -> " + client.getChildren(path));
		Thread.sleep(1000);
		client.createPersistent(path +"/c1");
		Thread.sleep(1000);
		client.delete(path +"/c1");
		Thread.sleep(1000);
		client.delete(path);
		Thread.sleep(10000);
	}
}
