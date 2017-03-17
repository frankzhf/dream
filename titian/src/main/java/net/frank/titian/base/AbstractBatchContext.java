package net.frank.titian.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.frank.titian.define.AccountInfo;
import net.frank.titian.define.BatchContext;
import net.frank.titian.define.RetailerMapperExcutor;
import net.frank.titian.define.RetailerPullExecutor;

public abstract class AbstractBatchContext implements BatchContext {
	
	private int threadNum = 1;
	
	private int retryNum = 3;
	
	private int retailerCount = 0;
	
	private Object locker = new Object();
	private Object joinLocker = new Object();
	
	private List<AccountInfo> accountInfoList = new ArrayList<AccountInfo>();
	
	private List<AccountInfo> retryAccountInfoList = new ArrayList<AccountInfo>();
	
	private Map<String, RetailerPullExecutor> pullExecutor;
	
	private Map<String, RetailerMapperExcutor> mapperExecutor;
	
	private String storage;
	
	private Properties sysProperties;
	
	@Override
	public int getThreadNum() {
		return threadNum;
	}
	
	public void setThreadNum(int threadNum){
		this.threadNum = threadNum;
	}

	@Override
	public int getRetryNum() {
		return retryNum;
	}
	
	public void setRetryNum(int retryNum){
		this.retryNum = retryNum;
	}

	@Override
	public List<AccountInfo> getAccountInfoList() {
		return accountInfoList;
	}
	
	public void setAccountInfoList(List<AccountInfo> accountInfoList) {
		this.accountInfoList = accountInfoList;
	}

	@Override
	public Map<String, RetailerPullExecutor> getPullExecutor() {
		return pullExecutor;
	}
	
	public void setPullExecutor(Map<String, RetailerPullExecutor> pullExecutor) {
		this.pullExecutor = pullExecutor;
	}

	@Override
	public Map<String, RetailerMapperExcutor> getMapperExecutor() {
		return mapperExecutor;
	}
	
	public void setMapperExecutor(Map<String, RetailerMapperExcutor> mapperExecutor){
		this.mapperExecutor = mapperExecutor;
	}

	@Override
	public AccountInfo getNextAccountInfo() {
		synchronized (locker) {
			for(Iterator<AccountInfo> it= accountInfoList.iterator();it.hasNext();){
				AccountInfo curr = it.next();
				it.remove();
				return curr;
			}
		}
		return null;
	}
	
	@Override
	public void joinRetryAccountInfoList(AccountInfo accountInfo) {
		synchronized (joinLocker) {
			retryAccountInfoList.add(accountInfo);
		}
	}
	
	public boolean needRetry(){
		return retryAccountInfoList != null &&
				! retryAccountInfoList.isEmpty();
	};
	
	public void prepareRetry(){
		accountInfoList.addAll(retryAccountInfoList);
		retryAccountInfoList.clear();
	};
	
	@Override
	public String getStorage(){
		return storage;
	}
	
	public void setStorage(String storage){
		this.storage = storage;
	}
	
	public int getRetailerCount(){
		return retailerCount;
	}
	
	public void increaseRetailer(){
		retailerCount ++;
	}
	@Override
	public Properties getSysProperties(){
		return sysProperties;
	}
	
	public void setSysProperties(Properties sysProperties){
		this.sysProperties = sysProperties;
	}
	
	public abstract void fillData(String retailerId);
}
