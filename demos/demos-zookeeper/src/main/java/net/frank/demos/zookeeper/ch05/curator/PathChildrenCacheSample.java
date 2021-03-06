package net.frank.demos.zookeeper.ch05.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathChildrenCacheSample {
	private static Logger log = LoggerFactory.getLogger(PathChildrenCacheSample.class);
	
	static String path = "/zk-book";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		try(PathChildrenCache cache = new PathChildrenCache(client,path,true)){
			cache.start(StartMode.POST_INITIALIZED_EVENT);
			cache.getListenable().addListener(new PathChildrenCacheListener() {
				@Override
				public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
					switch(event.getType()) {
					case CHILD_ADDED:
						log.debug("CHILD_ADDED, " + event.getData().getPath());
						break;
					case CHILD_UPDATED:
						log.debug("CHILD_UPDATED, " + event.getData().getPath());
						break;
					case CHILD_REMOVED:
						log.debug("CHILD_REMOVED, " + event.getData().getPath());
						break;
					default:
						break;
					}
				}
			});
			client.create().withMode(CreateMode.PERSISTENT).forPath(path);
			Thread.sleep(1000);
			client.create().withMode(CreateMode.PERSISTENT).forPath(path +"/c1");
			Thread.sleep(1000);
			client.delete().forPath(path +"/c1");
			Thread.sleep(1000);
			client.delete().forPath(path);
			Thread.sleep(10000);
			
			
			
		}
	}

}
