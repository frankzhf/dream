package net.frank.framework.app;

import net.frank.framework.security.Session;

public interface InitialService {
	public boolean checkAppInitial();
	public boolean checkUserWorkspace(Session session);
	public void initialApp();
	public void initialUserWorkspace(Session session);
}
