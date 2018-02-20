package net.frank.demos.zookeeper.ch05.zkclient;

import org.I0Itec.zkclient.ZkClient;

public class CreateNodeSample {
	//private static Logger log = LoggerFactory.getLogger(CreateSessionSample.class);
	
	/***
	 * 创建节点的方法
	 * String create(final String path, Object data, final CreateMode mode)
	 * String create(final String path, Object data, final List<ACL> acl , final CreateMode mode)
	 * void create(final String path, Object data, final CreateMode mode, 
	 * 		final AsyncCallback.StringCallback callback, final Object context)
	 * void createEphemeral(final String path)
	 * void createEphemeral(final String path, final Object data)
	 * void createPersistent(String path);
	 * void createPersistent(String path, boolean createParents);
	 * void createPersistent(String path, Object data);
	 * void createPersistent(String path, List<ACL> acl, Object data)
	 * String createPersistentSequential(String path, Object data)
	 * String createEphemeralSequential(final String path, final Object data)
	 * 
	 * 删除节点
	 * boolean delete(final String path)
	 * delete(final String path, final AsyncCallback.VoidCallback callback, final Object context)
	 * boolean deleteRecursive(String path)
	 * 
	 */
	public static void main(String[] args) {
		ZkClient client = new ZkClient("localhost:2181", 5000);
		client.createPersistent("/zk-book/c1", true);
	}

}
