package net.frank.aa.service.impl.a11n;

import net.frank.framework.app.InitialService;
import net.frank.framework.security.Authorization;
import net.frank.framework.security.Session;

public class InitUserWorkspaceAuthorization implements Authorization {

	private InitialService initialService;
	
	public void setInitialService(InitialService initialService){
		this.initialService = initialService;
	}
	
	@Override
	public void exec(Session session) {
		if(initialService.checkUserWorkspace(session)){
			initialService.initialUserWorkspace(session);
		}
	}

}
