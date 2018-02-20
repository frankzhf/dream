package net.frank.demos.zookeeper.ch05.curator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Curator 异步API
 * 
 *  public T inBackground()
 *  public T inBackground(Object conetxt)
 *  public T inBackground(BackgroundCallback callback)
 *  public T inBackground(BackgroundCallback callback, Object context)
 *  public T inBackground(BackgroundCallback callback, Executor executor)
 *  public T inBackground(BackgroundCallback callback, Object context, Executor executor)
 *  
 */


public class CreateNodeBackgroundSample {
	private static Logger log = LoggerFactory.getLogger(SetDataSample.class);

	static String path = "/zk-book";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	static CountDownLatch semaphore = new CountDownLatch(2);

	static ExecutorService tp = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws Exception {
		client.start();
		log.debug("Main thread: " + Thread.currentThread().getName());

		client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				log.debug("event[code: " + event.getResultCode() +", type :" + event.getType() +"]");
				log.debug("Thread of processResult: " + Thread.currentThread().getName());
				semaphore.countDown();
			}
		}, tp).forPath(path, "init".getBytes());
		
		client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				log.debug("event[code: " + event.getResultCode() +", type :" + event.getType() +"]");
				log.debug("Thread of processResult: " + Thread.currentThread().getName());
				semaphore.countDown();
			}
		}).forPath(path, "init".getBytes());
		
		semaphore.await();
		tp.shutdown();
	}

}
