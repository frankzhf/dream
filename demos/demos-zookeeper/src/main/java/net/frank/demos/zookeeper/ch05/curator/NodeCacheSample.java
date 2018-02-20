package net.frank.demos.zookeeper.ch05.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NodeCacheSample {
	private static Logger log = LoggerFactory.getLogger(NodeCacheSample.class);
	
	static String path = "/zk-book/nodecache";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path,"init".getBytes());
		try(final NodeCache cache = new NodeCache(client,path,false)){;//true的话第一次启动就会从Zookeeper上取数据
			cache.start();
			cache.getListenable().addListener(new NodeCacheListener() {
				@Override
				public void nodeChanged() throws Exception {
					if(cache.getCurrentData()!= null) {
						log.debug("Node data update, new data: " + new String (cache.getCurrentData().getData()));
					}else {//老版本delete不会触发这个listener
						log.debug("Node deleted.");
					}
				}
			});
			
			client.setData().forPath(path,"u".getBytes());
			Thread.sleep(1000);
			client.delete().deletingChildrenIfNeeded().forPath(path);
			Thread.sleep(10000);
		}
	}

}
