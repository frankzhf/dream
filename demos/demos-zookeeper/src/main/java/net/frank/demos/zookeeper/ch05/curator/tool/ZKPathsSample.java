package net.frank.demos.zookeeper.ch05.curator.tool;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.ZKPaths;
import org.apache.curator.utils.ZKPaths.PathAndNode;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZKPathsSample {

	private static Logger log = LoggerFactory.getLogger(ZKPathsSample.class);
	
	static String path = "/curator_zkpath_sample";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		ZooKeeper zookeeper = client.getZookeeperClient().getZooKeeper();
		log.debug(ZKPaths.fixForNamespace(path, "sub"));
		log.debug(ZKPaths.makePath(path, "sub"));
		log.debug(ZKPaths.getNodeFromPath("/curator_zkpath_sample/sub1"));
		PathAndNode pn = ZKPaths.getPathAndNode("/curator_zkpath_sample/sub1");
		log.debug(pn.getPath());
		log.debug(pn.getNode());
		
		String dir1 = path + "/child1";
		String dir2 = path + "/child2";
		
		ZKPaths.mkdirs(zookeeper, dir1);
		ZKPaths.mkdirs(zookeeper, dir2);
		
		log.debug(""+ZKPaths.getSortedChildren(zookeeper, path));
		ZKPaths.deleteChildren(zookeeper, path, true);
		
		
		
	}

}
