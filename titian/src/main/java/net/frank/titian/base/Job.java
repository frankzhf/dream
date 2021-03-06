package net.frank.titian.base;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.titian.define.AccountInfo;
import net.frank.titian.define.Ant;
import net.frank.titian.define.AntResult;
import net.frank.titian.define.BatchContext;
import net.frank.titian.define.Constants;
import net.frank.titian.define.RetailerPullExecutor;
import net.frank.titian.util.HttpUtil;
import net.frank.titian.util.RetailerPropertiesUtil;

public class Job implements Runnable {
	
	private BatchContext context;
	
	private final CountDownLatch mDoneSignal;
	
	public Job(BatchContext context,CountDownLatch mDoneSignal){
		this.context = context;
		this.mDoneSignal = mDoneSignal;
	}
	
	@Override
	public void run() {
		Logger log = LoggerFactory.getLogger(getClass());
		log.debug("Job run start");
		AccountInfo accountInfo = context.getNextAccountInfo();
		while(accountInfo!=null){
			RetailerPullExecutor executor = context.getPullExecutor().get(accountInfo.getRetailerId());
			executor.setRetailerProperties(RetailerPropertiesUtil.getRetailerProperties(accountInfo.getRetailerId()));
			String workspace = context.getStorage()+ File.separator + Constants.PHASE.CREEP + File.separator + accountInfo.getRetailerId() 
					+ File.separator + accountInfo.getLoginId();
			executor.setWorkspace(workspace);
			File _workspace = new File(workspace);
			if(!_workspace.exists()){
				_workspace.mkdirs();
			}
			executor.setLogger(log);
			
			int timeout = Integer.parseInt(RetailerPropertiesUtil.getRetailerProperties(accountInfo.getRetailerId()).getProperty("sleep.time"));
			
			CloseableHttpClient httpClient = HttpUtil.createHttpClient(timeout);
			AntResult result = executor.home(httpClient,context);
			if(Constants.ACTION_RESULT.SUCCESS != result.getStatus()){
				log.debug("Process user [accountInfo]  -> " + accountInfo +" Failure!" );
				log.debug("Add user [accountInfo]  -> " + accountInfo +" to RetryAccountList" );
				context.joinRetryAccountInfoList(accountInfo);
				continue;
			}
			List<Ant> todoList = executor.getAntActionList();
			if(todoList!=null && 
					!todoList.isEmpty()){
				Iterator<Ant> it = todoList.iterator();
				do{
					Ant unit = it.next();
					unit.setWorkspace(workspace + File.separator + unit.getOperateId());
					unit.setLog(log);
					if(unit.check()){
						AntResult unitResult = unit.process(httpClient,accountInfo,RetailerPropertiesUtil.getRetailerProperties(accountInfo.getRetailerId()),context);
						if(Constants.ACTION_RESULT.FAILURE == unitResult.getStatus()){
							break;
						}
					}
				}while(it.hasNext());
			}
			if(httpClient!=null){
				try{
					httpClient.close();
				}catch(IOException e){
					log.error(e.getMessage(),e);
				}	
			}
			accountInfo = context.getNextAccountInfo();
		}
		log.debug("Job run end");
		mDoneSignal.countDown();
	}
}
