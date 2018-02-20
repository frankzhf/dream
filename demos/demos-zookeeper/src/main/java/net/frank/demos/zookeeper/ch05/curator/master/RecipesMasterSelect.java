package net.frank.demos.zookeeper.ch05.curator.master;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipesMasterSelect {
	private static Logger log = LoggerFactory.getLogger(RecipesMasterSelect.class);
	
	static String masterPath = "/curator_recipes_master_path";

	static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181")
			.sessionTimeoutMs(5000).connectionTimeoutMs(3000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

	public static void main(String[] args) throws Exception {
		client.start();
		try(LeaderSelector selector = new LeaderSelector(client,masterPath,new LeaderSelectorListenerAdapter() {
			@Override
			public void takeLeadership(CuratorFramework client) throws Exception {
				log.debug("成为master角色");
				Thread.sleep(3000);
				log.debug("完成Master操作,释放Master权利");
			}			
		})){
			selector.autoRequeue();
			selector.start();
			Thread.sleep(30000);
		}
		

	}

}
