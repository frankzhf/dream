package net.frank.aa.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.framework.security.Authenticator;
import net.frank.framework.security.Authorization;
import net.frank.aa.service.AaService;
import net.frank.framework.security.Session;

public class DefaultAaServiceImpl implements AaService {
	protected transient Log log = LogFactory.getLog(this.getClass());
	
	private Map<Integer, Authenticator> authenticatorMap;

	private List<Authenticator> authenticatorList;

	private List<Authorization> authorizationList;

	public void setAuthenticatorMap(Map<Integer, Authenticator> authenticatorMap) {
		this.authenticatorMap = authenticatorMap;
	}

	public void setAuthorizationList(List<Authorization> authorizationList) {
		this.authorizationList = authorizationList;
	}

	public void setAuthenticatorList(List<Authenticator> authenticatorList) {
		this.authenticatorList = authenticatorList;
	}

	@Override
	public Session login(Session session, String loginName, String password,
			Integer loginType) {
		if (loginType != null && authenticatorMap.get(loginType) != null) {
			authenticatorMap.get(loginType).authenticate(loginName, password,
					session);
		} else {
			Iterator<Authenticator> it = authenticatorList.iterator();
			while (!Session.STATUS_LOGINED.equals(session.getStatus())
					&& it.hasNext()) {
				Authenticator currA11r = it.next();
				currA11r.authenticate(loginName, password, session);
			}
		}
		if(Session.STATUS_LOGINED.equals(session.getStatus())) {
			for(Iterator<Authorization> it=authorizationList.iterator();it.hasNext();){
				Authorization currA11n = it.next();
				currA11n.exec(session);
			}
		}
		return session;
	}

	@Override
	public void logout(Session cs) {
		cs.setStatus(Session.STATUS_INITIAL);
	}

}
