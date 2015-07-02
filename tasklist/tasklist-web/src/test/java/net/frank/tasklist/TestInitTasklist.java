package net.frank.tasklist;

import net.frank.framework.TestInitCase;
import net.frank.framework.app.InitialService;

public class TestInitTasklist extends TestInitCase {
	
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml"};
	}
	
	public void testInit(){
		InitialService initialService = (InitialService)getBean("initialTasklistService");
		if(initialService.checkAppInitial()){
			initialService.initialApp();
		}
	}
}
