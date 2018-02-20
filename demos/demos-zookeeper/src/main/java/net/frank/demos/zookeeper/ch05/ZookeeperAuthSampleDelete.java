package net.frank.demos.zookeeper.ch05;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperAuthSampleDelete {
	
	private static Logger log = LoggerFactory.getLogger(ZookeeperAuthSampleDelete.class);
	
	final static String PATH = "/zk-book-auth_test";
	final static String PATH2 = "/zk-book-auth_test/child";
	
	public static void main(String[] args) throws Exception{
		ZooKeeper zookeeper1 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper1.addAuthInfo("digest","foo:true".getBytes());
		zookeeper1.create(PATH, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		zookeeper1.create(PATH2, "init".getBytes(), Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
		
		try {
			ZooKeeper zookeeper2 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
			zookeeper2.delete(PATH2, -1);
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
		ZooKeeper zookeeper3 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher());
		zookeeper3.addAuthInfo("digest","foo:true".getBytes());
		zookeeper3.delete(PATH2, -1);
		log.debug("成功删除节点:" + PATH2);
		
		
		ZooKeeper zookeeper4 = new ZooKeeper("localhost:2181", 5000,new DefaultDoNothingWatcher()); //对于删除操作来说，其范围是子节点集合，没有权限也可以删除本节点
		zookeeper4.delete(PATH, -1);
		log.debug("成功删除节点:" + PATH);
		
		
	}

}
