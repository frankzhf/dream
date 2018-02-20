package net.frank.demos.zookeeper.ch05;

import java.util.Arrays;
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

public class ZookeeperGetDataApiASyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperGetDataApiASyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
	private static ZooKeeper zk;

	public static void main(String[] args) throws Exception {
		String path = "/zk-book";
		zk = new ZooKeeper("localhost:2181", 5000, new ZookeeperGetDataApiASyncUsage());
		log.debug("Variable [zookeeper.state] -> " + zk.getState());
		connectedSemaphore.await();
		zk.create(path, "123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		zk.getData(path, true, new IDataCallback(),null);
		zk.setData(path, "123".getBytes(), -1);
		Thread.sleep(10000);
	}

	@Override
	public void process(WatchedEvent event) {
		log.debug("Receive watched event:" + event);
		if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
			if (EventType.None == event.getType() && null == event.getPath()) {
				connectedSemaphore.countDown();
			} else if (event.getType() == EventType.NodeDataChanged) {
				zk.getData(event.getPath(), true, new IDataCallback(), null);
			}
		}
	}
}

class IDataCallback implements AsyncCallback.DataCallback {
	private static Logger log = LoggerFactory.getLogger(IChildren2Callback.class);

	@Override
	public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
		log.debug("Param [rc] ->" + rc);
		log.debug("Param [ctx] ->" + ctx);
		log.debug("Param [data] ->" + Arrays.toString(data));
		log.debug("Param [stat] ->" + stat.getCzxid() +"," + stat.getMzxid() + "," + stat.getVersion());
	}

	

}
