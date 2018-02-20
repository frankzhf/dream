package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperExistApiSyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperExistApiSyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;
	
	public static void main(String[] args) throws Exception {
		String path ="/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperExistApiSyncUsage());
		log.debug("Variable [zookeeper.state] -> " +zk.getState());
		connectedSemaphore.await();
		
		zk.exists(path, true);
		
		zk.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		zk.setData(path, "123".getBytes(), -1);
		
		zk.create(path +"/c1","".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		zk.delete(path + "/c1", -1);
		
		zk.delete(path, -1);
		
		
		Thread.sleep(10000);
	}
	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			try {
				if(EventType.None == event.getType() && null == event.getPath()) {
					connectedSemaphore.countDown();
				}else if(EventType.NodeCreated == event.getType()) {
					log.debug("Node(" +event.getPath()+ ")Created");
					zk.exists(event.getPath(), true);
				}else if(EventType.NodeDeleted == event.getType()) {
					log.debug("Node(" +event.getPath()+ ")Deleted");
					zk.exists(event.getPath(), true);
				}else if(EventType.NodeDataChanged == event.getType()) {
					log.debug("Node(" +event.getPath()+ ")DataChanged");
					zk.exists(event.getPath(), true);
				}
			}catch(Exception e) {
				
			}
		}
	}
	

}
