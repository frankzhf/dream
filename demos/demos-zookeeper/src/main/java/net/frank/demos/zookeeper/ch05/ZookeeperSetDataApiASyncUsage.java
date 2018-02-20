package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperSetDataApiASyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperSetDataApiASyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;
	
	public static void main(String[] args) throws Exception {
		String path ="/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperSetDataApiASyncUsage());
		log.debug("Variable [zookeeper.state] -> " +zk.getState());
		connectedSemaphore.await();
		zk.create(path, "123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		
		zk.setData(path, "456".getBytes(),-1, new IStatCallback(),null);//版本号，-1为最新版本
		
		Thread.sleep(10000);
	}
	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			if(EventType.None == event.getType() && null == event.getPath()) {
				connectedSemaphore.countDown();
			}
		}
	}
}

class IStatCallback implements AsyncCallback.StatCallback{
	private static Logger log = LoggerFactory.getLogger(IStatCallback.class);
	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		if(rc == 0) {
			log.debug("SUCCESS");
		}
	}	
}