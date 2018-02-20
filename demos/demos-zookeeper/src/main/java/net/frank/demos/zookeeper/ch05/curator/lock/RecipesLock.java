package net.frank.demos.zookeeper.ch05.curator.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RecipesLock {
	private static Logger log = LoggerFactory.getLogger(RecipesLock.class);
	
	static String lockPath = "/curator_recipes_lock_path";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		final InterProcessMutex lock = new InterProcessMutex(client,lockPath);
		
		final CountDownLatch down = new CountDownLatch(1);
		for(int i=0;i<30;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						down.await();
						lock.acquire();
					}catch(Exception e) {
					}
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
					String orderNo = sdf.format(new Date());
					log.debug("生成订单号:" + orderNo);
					try {
						lock.release();
					}catch(Exception e) {
						
					}
				}
			}).start();
		}
		down.countDown();
	}

}
