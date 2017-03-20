package net.frank.titian.test.mengnui.context;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.frank.titian.base.AbstractBatchContext;
import net.frank.titian.define.AccountInfo;
import net.frank.titian.define.RetailerPullExecutor;
import net.frank.titian.retailer.action.carrefour.LoginAction;
import net.frank.titian.test.mengnui.action.carrefour.OrderAction;
import net.frank.titian.test.mengnui.pull.CarrefourPull;
import net.frank.titian.util.RetailerPropertiesUtil;

public class MengniuContext extends AbstractBatchContext {

	@Override
	public void fillData(String retailerId) {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setLoginId("Z18O");
		accountInfo.setPassword("shanghai123");
		accountInfo.setRetailerId("carrefour");
		getAccountInfoList().add(accountInfo);
		RetailerPullExecutor carrefourPullExecutor = new CarrefourPull();
		Map<String,RetailerPullExecutor> pullExecutorMap = new HashMap<String,RetailerPullExecutor>();
		pullExecutorMap.put("carrefour", carrefourPullExecutor);
		LoginAction loginAction = new LoginAction();
		carrefourPullExecutor.getAntActionList().add(loginAction);
		OrderAction orderAction = new OrderAction();
		carrefourPullExecutor.getAntActionList().add(orderAction);
		setSysProperties(RetailerPropertiesUtil.getBatchProperties());
		//设置爬虫下载数据存放目录
		setStorage(getSysProperties().getProperty("local.storeage.path") + File.separator 
				+ Thread.currentThread().getId()+"_" + Thread.currentThread().getName() 
				+ File.separator);
		setPullExecutor(pullExecutorMap);
	}
}
