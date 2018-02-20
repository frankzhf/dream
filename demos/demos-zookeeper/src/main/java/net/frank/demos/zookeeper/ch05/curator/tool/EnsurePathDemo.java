package net.frank.demos.zookeeper.ch05.curator.tool;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.EnsurePath;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class EnsurePathDemo {

	//private static Logger log = LoggerFactory.getLogger(EnsurePathDemo.class);
	
	static String path = "/zk-book/c1";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		client.usingNamespace("zk-book");
		EnsurePath ensurePath = new EnsurePath(path);
		
		ensurePath.ensure(client.getZookeeperClient());
		
		EnsurePath ensurePath2 = client.newNamespaceAwareEnsurePath("/c1");
		
		ensurePath2.ensure(client.getZookeeperClient());
		
	}

}
