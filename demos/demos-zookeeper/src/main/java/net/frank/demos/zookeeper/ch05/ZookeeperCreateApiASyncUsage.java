package net.frank.demos.zookeeper.ch05;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 
 * 异步创建节点
 */
public class ZookeeperCreateApiASyncUsage implements Watcher {
	private static Logger log = LoggerFactory.getLogger(ZookeeperCreateApiASyncUsage.class);
	private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zookeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperCreateApiASyncUsage());
		log.debug("Variable [zookeeper.state] -> " + zookeeper.getState());
		connectedSemaphore.await();
		
		/**
		 * @param createMode 
		 * 		PERSISTENT				持久
		 * 		PERSISTENT_SEQUENTIAL	持久顺序
		 * 		EPHEMERAL				临时
		 * 		EPHEMERAL_SEQUENTIAL		临时顺序
		 */
		
		zookeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL, new IStringCallback(),"I'm context");
		zookeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL, new IStringCallback(),"I'm context");
		zookeeper.create("/zk-test-ephemeral-", "".getBytes(), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL, new IStringCallback(),"I'm context");
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

class IStringCallback implements AsyncCallback.StringCallback{
	private static Logger log = LoggerFactory.getLogger(IStringCallback.class);
	
	/***
	 *  		@param rc
	 *  		0		接口调用成功
	 *  		-4		客户端和服务器连接已经断开
	 *  		-110		指定的节点已经存在
	 *  		-112		会话已经过期
	 *  	
	 *  		@param path 调用方法时传入的路径
	 *  		@param ctx	调用方法时传入的上下文
	 *  		@param name	全路径名称
	 */
	@Override
	public void processResult(int rc, String path, Object ctx, String name) {
		log.debug("Create path result : " + rc +"," + path + "," + ctx + ", real path name :" + name);
	}
}
