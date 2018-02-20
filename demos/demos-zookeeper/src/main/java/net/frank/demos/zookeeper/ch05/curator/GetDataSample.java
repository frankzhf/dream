package net.frank.demos.zookeeper.ch05.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDataSample {
	
	private static Logger log = LoggerFactory.getLogger(GetDataSample.class);
	
	static String path = "/zk-book";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		client.create()
			.creatingParentsIfNeeded()
			.withMode(CreateMode.EPHEMERAL)
			.forPath(path,"init".getBytes());
		Stat stat = new Stat();
		
		log.debug("Data ["+path+"] ->" +client.getData().storingStatIn(stat).forPath(path));
		
	}
}
