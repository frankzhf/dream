package net.frank.demos.zookeeper.ch05.curator.test;

import org.apache.curator.test.TestingCluster;
import org.apache.curator.test.TestingZooKeeperServer;

public class TestingClusterSample {
	

	public static void main(String[] args)  throws Exception{
		try(TestingCluster cluster = new TestingCluster(3)){
			cluster.start();
			Thread.sleep(2000);
			
			TestingZooKeeperServer leader = null;
			for(TestingZooKeeperServer zs : cluster.getServers()) {
				System.out.println(zs.getInstanceSpec().getServerId() + "-" + zs.getQuorumPeer().getServerState() + "-" + zs.getInstanceSpec().getDataDirectory().getAbsolutePath());
				if(zs.getQuorumPeer().getServerState().equals("leading")) {
					leader = zs;
				}
			}
			leader.kill();
			System.out.println("--After leader kill : ");
			for(TestingZooKeeperServer zs : cluster.getServers()) {
				System.out.println(zs.getInstanceSpec().getServerId() + "-" + zs.getQuorumPeer().getServerState() + "-" + zs.getInstanceSpec().getDataDirectory().getAbsolutePath());
			}
			cluster.stop();
		}
	}
}
