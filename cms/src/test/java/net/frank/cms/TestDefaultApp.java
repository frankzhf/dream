package net.frank.cms;

import net.frank.framework.BaseTestCase;

import net.frank.framework.bo.Application;
import net.frank.framework.app.ApplicationTemplate;

public class TestDefaultApp extends BaseTestCase {
	
	public void testFunction(){
		ApplicationTemplate cmsApp = (ApplicationTemplate)getBean("cmsApplication");
		Application application = cmsApp.getApplication();
		logger.info("Application Name is "+application.getAppName());
		assertEquals(application.getAppName(), "cms");
	}


	@Override
	public String[] getSpringConfig() {
		return new String[] { "/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-app.xml"};
	}	
}