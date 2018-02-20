package net.frank.demos.zookeeper.ch05.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CreateSessionFluentSample {
	public static void main(String[] args) throws Exception {
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.builder()
									.connectString("localhost:2181")
									.sessionTimeoutMs(5000)
									.connectionTimeoutMs(3000)
									.retryPolicy(retryPolicy).build();
		client.start();
		Thread.sleep(10000);
	}
}
