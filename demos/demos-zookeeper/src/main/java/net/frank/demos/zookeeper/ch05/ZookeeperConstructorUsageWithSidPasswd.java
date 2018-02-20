package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperConstructorUsageWithSidPasswd implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperConstructorUsageWithSidPasswd.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperConstructorUsageWithSidPasswd());
		log.debug("Variable [zookeeper.state] -> " +zookeeper.getState());
		connectedSemaphore.await();
		long sessionId = zookeeper.getSessionId();
		byte[] passwd = zookeeper.getSessionPasswd();
		//invalid sessionId & sessionPasswd
		zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperConstructorUsageWithSidPasswd(),1L,"test".getBytes());
		//correct sessionId & sessionPasswd
		zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperConstructorUsageWithSidPasswd(),sessionId,passwd);
		Thread.sleep(10000);
		log.debug("Zookeeper session established.");
	}

	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			connectedSemaphore.countDown();
		}
	}

}
