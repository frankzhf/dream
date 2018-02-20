package net.frank.demos.zookeeper.ch05.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CreateNodeSample {
	
	static String path = "/zk-book/c1";
	
	static CuratorFramework client = CuratorFrameworkFactory.builder()
			.connectString("localhost:2181")
			.sessionTimeoutMs(5000)
			.connectionTimeoutMs(3000)
			.retryPolicy(new ExponentialBackoffRetry(1000,3))
			.build();
	
	
	public static void main(String[] args)throws Exception{
		client.start();
		client.create().creatingParentsIfNeeded()
			.withMode(CreateMode.EPHEMERAL)
			.forPath(path,"init".getBytes());
		Thread.sleep(10000);
	}
	
	
}
