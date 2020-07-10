package net.frank.framework.security;

public interface Authenticator {
	void authenticate(String loginName, String password,
			Session session);
}
