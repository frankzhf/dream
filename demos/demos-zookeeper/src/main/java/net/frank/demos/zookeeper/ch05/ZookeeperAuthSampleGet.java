package net.frank.demos.zookeeper.ch05;

import java.util.Arrays;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperAuthSampleGet  {
	private static Logger log = LoggerFactory.getLogger(ZookeeperAuthSampleGet.class);
	
	final static String PATH = "/zk-book-auth_test";
	
	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper1 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper1.addAuthInfo("digest","foo:true".getBytes());
		zookeeper1.create(PATH, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
		
		ZooKeeper zookeeper2 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper2.addAuthInfo("digest","foo:true".getBytes());
		log.debug("Get Data [" +PATH+ "] ->" + Arrays.toString(zookeeper2.getData(PATH, false, null))  );
		
		
		ZooKeeper zookeeper3 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper3.addAuthInfo("digest","foo:false".getBytes());
		log.debug("Get Data [" +PATH+ "] ->" + Arrays.toString(zookeeper3.getData(PATH, false, null))  );
		
		Thread.sleep(30000);
		
	}
}

