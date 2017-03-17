package net.frank.titian.define;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface BatchContext{
	
	public int getThreadNum();
	
	public int getRetryNum();
	
	public List<AccountInfo> getAccountInfoList();
	
	public Map<String,RetailerPullExecutor> getPullExecutor();
	
	public Map<String,RetailerMapperExcutor> getMapperExecutor();
	
	public AccountInfo getNextAccountInfo();
	
	public void joinRetryAccountInfoList(AccountInfo accountInfo);
	
	public boolean needRetry();
	
	public void prepareRetry();
	
	public String getStorage();
	
	public int getRetailerCount();
	
	public Properties getSysProperties();
	
}
