package net.frank.demos.zookeeper.ch05.curator.test;

import java.io.File;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestingServerSample {
	private static Logger log = LoggerFactory.getLogger(TestingServerSample.class);
	static String path = "/zookeeper";
	
	public static void main(String[] args) throws Exception {
		TestingServer server = new TestingServer(2181,new File("/Users/zhaofeng/projects/frank/source/dream/demos/demos-zookeeper/src/main/store"));
		CuratorFramework client = CuratorFrameworkFactory.builder().connectString(server.getConnectString())
				.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
		client.start();
		log.debug("Variable [client.children] -> "+client.getChildren().forPath(path));
		server.close();
	}

}
