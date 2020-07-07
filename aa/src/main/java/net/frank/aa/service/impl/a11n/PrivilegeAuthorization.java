package net.frank.aa.service.impl.a11n;

import java.util.List;

import net.frank.framework.security.Authorization;
import net.frank.framework.bo.Privilege;
import net.frank.framework.dao.PrivilegeDao;
import net.frank.framework.security.Session;

public class PrivilegeAuthorization implements Authorization {

	private PrivilegeDao privilegeDao;

	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	@Override
	public void exec(Session session) {
		if(Session.STATUS_LOGINED.equals(session.getStatus())){
			List<Privilege> privileges = privilegeDao.getPrivilege(session
					.getAccount());
			session.getAttributes().put(Session.CS_ATTRIBLE_PRIVILEGES_KEY,
					privileges);
		}
	}
}