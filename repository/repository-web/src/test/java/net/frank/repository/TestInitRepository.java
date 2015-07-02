package net.frank.repository;

import net.frank.framework.TestInitCase;
import net.frank.framework.app.InitialService;

public class TestInitRepository extends TestInitCase {
	
	protected static Byte ACCOUNT_PERMISSION = 7;

	protected static Byte GROUP_PERMISSION = 4;

	protected static Byte OTHERS_PERMISSION = 0;
	
	private InitialService initialRepositoryService;
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml",
				"classpath:applicationContext-repository.xml"};
	}
	@Override
	public void setUp() {
		super.setUp();
		initialRepositoryService = (InitialService)getBean("initialRepositoryService");
	}
	
	public void testInit(){
		logger.info("Start Init Repository");
		if(initialRepositoryService.checkAppInitial()){
			initialRepositoryService.initialApp();
		}
		logger.info("End Init Repository");
	}
}
