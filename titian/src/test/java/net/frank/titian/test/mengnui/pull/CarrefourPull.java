package net.frank.titian.test.mengnui.pull;

import net.frank.titian.base.AbstractRetailerPullExecutor;

public class CarrefourPull extends AbstractRetailerPullExecutor {
	
	private static final String HOME_URL = "http://www.szfcweb.com/";
	
	@Override
	public String getHomeUrl() {
		return HOME_URL;
	}

}