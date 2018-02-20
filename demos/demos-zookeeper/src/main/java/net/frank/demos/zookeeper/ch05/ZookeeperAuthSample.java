package net.frank.demos.zookeeper.ch05;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperAuthSample  {
	private static Logger log = LoggerFactory.getLogger(ZookeeperAuthSample.class);
	
	final static String PATH = "/zk-book-auth_test";
	
	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper.addAuthInfo("digest","foo:true".getBytes());
		zookeeper.create(PATH, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);
		
		new Thread(new Runnable() {

			@Override
			public void run()  {
				try {
					ZooKeeper client2 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
					client2.getData(PATH, false, null);
				}catch(Exception e) {
					log.error(e.getMessage(),e);
				}
			}
			
		}).start();
		
		
		Thread.sleep(30000);
		
	}
}