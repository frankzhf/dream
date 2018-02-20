package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

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

public class ZookeeperGetDataApiSyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperGetDataApiSyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;
	private static Stat stat = new Stat();
	public static void main(String[] args) throws Exception {
		String path ="/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperSetDataApiSyncUsage());
		log.debug("Variable [zookeeper.state] -> " +zk.getState());
		connectedSemaphore.await();
		zk.create(path, "123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		log.debug(new String(zk.getData(path, true, stat)));
		log.debug("Variable [stat] ->" + stat.getCzxid() +"," + stat.getMzxid() +"," + stat.getVersion());
		zk.setData(path, "123".getBytes(),-1);
		Thread.sleep(10000);
	}
	
	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			if(EventType.None == event.getType() && null == event.getPath()) {
				connectedSemaphore.countDown();
			}else if(event.getType() == EventType.NodeDataChanged) {
				try {
					log.debug( new String(zk.getData(event.getPath(), true, stat)));
					log.debug("Variable [stat] ->" + stat.getCzxid() +"," + stat.getMzxid() +"," + stat.getVersion()) ;
				}catch(InterruptedException | KeeperException e) {
					log.error(e.getMessage(),e);
				}
			}
		}
	}
	

}
