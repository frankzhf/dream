package net.frank.framework.service;

import net.frank.framework.bo.Account;
import net.frank.framework.security.Session;

public interface AccountService {
	
	public boolean existAccount(String loginName);
	
	public Account createLdapAccount(String loginName,String password, Session session);
	
	public Account addAccount(String loginName, String password, Session session);
}
