package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperConstructorUsageSaimple implements Watcher {
	
	/***
	 * ZooKeeper(String connectString, int sessionTimeout, Watcher watcher)
	 * ZooKeeper(String connectString, int sessionTimeout, Watcher watcher, boolean is==canBeReadOnly);
	 * ZooKeeper(String connectString, int sessionTimeout, Watcher watcher, Long sessionId, byte[] sessionPasswd);
	 * ZooKeeper(String connectString, int sessionTimeout, Watcher watcher, Long sessionId, byte[] sessionPasswd, boolean is==canBeReadOnly);
	 * 
	 * @param connectString	 	tcp地址或多组tcp地址	例如192.168.1.1:2181 或 192.168.1.1:2181,192.168.1.2:2181
	 * 							并可进一步带路径		
	 * 
	 */
	
	
	private static Logger log = LoggerFactory.getLogger(ZookeeperConstructorUsageSaimple.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperConstructorUsageSaimple());
		log.debug("Variable [zookeeper.state] -> " +zookeeper.getState());
		connectedSemaphore.await();
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
