package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/***
 * 
 * 同步创建节点
 */

public class ZookeeperCreateApiSyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperCreateApiSyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperCreateApiSyncUsage());
		log.debug("Variable [zookeeper.state] -> " + zookeeper.getState());
		connectedSemaphore.await();
		String path1 = zookeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL);
		log.debug("Success create znode: " + path1);
		
		String path2 = zookeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		log.debug("Success create znode: " + path2);
		Thread.sleep(30000);
		
	}

	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			connectedSemaphore.countDown();
		}
	}

}
