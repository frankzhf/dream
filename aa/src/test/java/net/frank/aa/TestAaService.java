package net.frank.aa;

import net.frank.aa.service.AaService;
import net.frank.framework.BaseTestCase;

public class TestAaService extends BaseTestCase {
	
	private static final String DUMMY_IP_ADDRESS = "127.0.0.1";
	
	private AaService aaService;
	
	public void setUp() {
		super.setUp();
		aaService = (AaService)getBean("aaService");
	}
	
	
	public void testLogin(){
		System.out.println("hi");
		/**
		ClientSession firstCs = aaService.login("root", "p@ssw0rd", DUMMY_IP_ADDRESS,null);
		assertEquals(ClientSession.STATUS_LOGINED, firstCs.getStatus());
		aaService.logout(firstCs);
		assertEquals(ClientSession.STATUS_INITIAL, firstCs.getStatus());
		firstCs = aaService.login("root", "passw0rd", DUMMY_IP_ADDRESS,null);
		assertEquals(ClientSession.STATUS_INCORRERT_PW, firstCs.getStatus());
		firstCs = aaService.login("zhaofeng", "passw0rd", DUMMY_IP_ADDRESS,null);
		assertEquals(ClientSession.STATUS_NOT_EXISTS, firstCs.getStatus());
		**/
	}


	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-test.xml"};
	}
	
}
