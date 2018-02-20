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

public class ZookeeperSetDataApiSyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperSetDataApiSyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;
	
	public static void main(String[] args) throws Exception {
		String path ="/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperSetDataApiSyncUsage());
		log.debug("Variable [zookeeper.state] -> " +zk.getState());
		connectedSemaphore.await();
		zk.create(path, "123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		zk.getData(path, true, null);
		Stat stat = zk.setData(path, "456".getBytes(), -1);//版本号，-1为最新版本
		log.debug("Varable [stat] -> " + stat.getCzxid() + "," + stat.getMzxid() +"," + stat.getVersion());
		Stat stat2 = zk.setData(path, "456".getBytes(), stat.getVersion());
		log.debug("Varable [stat] -> " + stat2.getCzxid() + "," + stat2.getMzxid() +"," + stat2.getVersion());
		try {
			zk.setData(path, "456".getBytes(), stat.getVersion());
		}catch(KeeperException e) {
			log.error("Error" + e.code().intValue() + "," + e.getMessage(),e );
		}
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
