package net.frank.framework.security;

import net.frank.framework.security.Session;

public interface Authenticator {
	public void authenticate(String loginName, String password,
			Session session);
}
