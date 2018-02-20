package net.frank.demos.zookeeper.ch05.curator.count;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesBarrier {
	private static Logger log = LoggerFactory.getLogger(RecipesBarrier.class);
	static String barrier_path = "/curator_recipes_barrier_path";
	static DistributedBarrier barrier;
	public static void main(String[] args) throws Exception {
		for(int i=0;i<5;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						CuratorFramework client = CuratorFrameworkFactory.builder()
								.connectString("localhost:2181").retryPolicy(new ExponentialBackoffRetry(1000,3))
								.build();
						client.start();
						barrier = new DistributedBarrier(client,barrier_path);
						log.debug("barrier设置");
						
						barrier.setBarrier();
						barrier.waitOnBarrier();
						log.debug("启动");
						
					}catch(Exception e) {}
				}
				
			}).start();
			
		}
		Thread.sleep(2000);
		barrier.removeBarrier();
	}

}
