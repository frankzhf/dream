package net.frank.aa;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.LdapTemplate;

public class TestLdap extends TestCase {
	
	protected ApplicationContext context = new ClassPathXmlApplicationContext(
		new String[] {"/applicationContext-ldap.xml"});
	
	private LdapTemplate ldapTemplate;
	
	protected void setUp() {
		//super.setUp();
		ldapTemplate = (LdapTemplate)context.getBean("ldapTemplate");
	}
	
	public void testLDAP(){
		Boolean bool = ldapTemplate.authenticate("", "(mailNickname=zhaofeng)", "P4ssword");
		System.out.println(bool);
	}
}
