package net.frank.demos.zookeeper.ch05.curator.master;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.CancelLeadershipException;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;

public abstract class LeaderSelectorListenerAdapter implements LeaderSelectorListener {

	@Override
	public void stateChanged(CuratorFramework client, ConnectionState newState) {
		if( (newState == ConnectionState.SUSPENDED) || (newState == ConnectionState.LOST )) {
			throw new CancelLeadershipException();
		}
	}
}
