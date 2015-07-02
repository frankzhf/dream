package net.frank.knowledge;

import net.frank.framework.TestInitCase;
import net.frank.framework.app.InitialService;

public class TestInitKnowledge extends TestInitCase {
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml"};
	}
	
	@Override
	public void setUp() {
		super.setUp();
	}
	
	public void testInit(){
		InitialService initialService = (InitialService)getBean("initialKnowledgeService");
		if(initialService.checkAppInitial()){
			initialService.initialApp();
		}
	}
}
