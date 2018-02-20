package net.frank.demos.zookeeper.ch05.curator.count;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesDistAtomicInt {

	private static Logger log = LoggerFactory.getLogger(RecipesDistAtomicInt.class);
	
	static String path = "/curator_recipes_distatomicint_path";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		DistributedAtomicInteger atomicInteger = new 
				DistributedAtomicInteger(client,path,new RetryNTimes(3,1000));
		AtomicValue<Integer> rc = atomicInteger.add(8);
		log.debug("Result : " + rc.succeeded());
	}

}
