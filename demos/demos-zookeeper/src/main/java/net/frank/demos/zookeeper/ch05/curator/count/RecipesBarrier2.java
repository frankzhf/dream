package net.frank.demos.zookeeper.ch05.curator.count;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedDoubleBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesBarrier2 {
	private static Logger log = LoggerFactory.getLogger(RecipesBarrier2.class);
	static String barrier_path = "/curator_recipes_barrier_path";
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
						DistributedDoubleBarrier barrier = new DistributedDoubleBarrier(client,barrier_path,5);
						Thread.sleep(Math.round(Math.random() * 3000));
						log.debug("进入barrier");
						
						barrier.enter();
						log.debug("启动...");
						Thread.sleep(Math.round(Math.random() * 3000));
						barrier.leave();
						log.debug("退出...");
					}catch(Exception e) {}
				}
			}).start();	
		}
	}

}
