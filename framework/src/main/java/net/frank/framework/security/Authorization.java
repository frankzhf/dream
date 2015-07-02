package net.frank.framework.security;

import net.frank.framework.security.Session;

public interface Authorization {
	public void exec(Session session);
}
