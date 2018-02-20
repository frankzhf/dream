package net.frank.demos.zookeeper.ch05;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperGetChildrenApiASyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperGetChildrenApiASyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;

	public static void main(String[] args) throws Exception {
		String path = "/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperGetChildrenApiASyncUsage());
		log.debug("Variable [zookeeper.state] -> " + zk.getState());
		connectedSemaphore.await();
		zk.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zk.create(path + "/c1", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		zk.getChildren(path, true, new IChildren2Callback(), null);
		zk.create(path + "/c2", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		Thread.sleep(10000);
	}

	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			if (EventType.None == event.getType() && null == event.getPath()) {
				connectedSemaphore.countDown();
			} else if (event.getType() == EventType.NodeChildrenChanged) {
				try {
					log.debug("ReGetChild:" + zk.getChildren(event.getPath(), true));
				} catch (InterruptedException | KeeperException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
	}
}

class IChildren2Callback implements AsyncCallback.Children2Callback {
	private static Logger log = LoggerFactory.getLogger(IChildren2Callback.class);

	@Override
	public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
		log.debug("Get Children znode result : [response code  :" + rc + ", param path : " + path + ", ctx : " + ctx
				+ ", children list :" + children + ",state :" + stat);
	}

}