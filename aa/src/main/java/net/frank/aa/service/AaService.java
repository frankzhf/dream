package net.frank.aa.service;

import net.frank.framework.security.Session;

public interface AaService {

	public Session login(Session cs, String loginName, String password,
			Integer loginType);

	public void logout(Session cs);
}
