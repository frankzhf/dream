package net.frank.frankwork.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;

import net.frank.commons.util.StringUtil;
import net.frank.framework.BaseTestCase;
import net.frank.framework.mail.VelocityEmailTemplate;

public class TestCallEmail extends BaseTestCase {

	private VelocityEmailTemplate velocityEmailTemplate;

	@Override
	public String[] getSpringConfig() {
		return new String[] { "classpath:applicationContext-base.xml",
				"classpath:applicationContext-framework-mail.xml" };
	}

	@Override
	public void setUp() {
		super.setUp();
		velocityEmailTemplate = (VelocityEmailTemplate) getBean("velocityEmailTemplate");
	}
	
	public void testSendResetPasswordMail()throws Exception{
		String newPassword = StringUtil.generateString(8);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		logger.info("New Password:"+newPassword);
		paramMap.put("loginName", "zhaofeng");
		paramMap.put("newPassword", newPassword);
		velocityEmailTemplate.send("resetPassword.vm", paramMap, "Reset Password", "zhaofeng@ncsi.com.cn");
		
		logger.info("testSendResetPasswordMail() end");
	}
	
	
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
}
