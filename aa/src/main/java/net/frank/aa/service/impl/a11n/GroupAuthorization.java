package net.frank.aa.service.impl.a11n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.frank.commons.CommonConstants;
import net.frank.framework.security.Authorization;

import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.dao.Account2GroupDao;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;

public class GroupAuthorization implements Authorization {
	
	//private final Long DEFAULT_GROUP_RES_ID = 18L;
	
	private Account2GroupDao account2GroupDao;

	private QueryService queryService;
	
	public void setAccount2GroupDao(Account2GroupDao account2GroupDao) {
		this.account2GroupDao = account2GroupDao;
	}
	
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}
	@Override
	public void exec(Session session) {
		if(Session.STATUS_LOGINED.equals(session.getStatus())){
			List<Account2Group> list = account2GroupDao.listGroupByAccount(session
					.getAccount());
			List<Resource> groupList = new ArrayList<Resource>();
			if (list != null && !list.isEmpty()) { 
				for(Iterator<Account2Group> it = list.iterator(); it .hasNext();) {
					Account2Group current = it.next();
					groupList.add(current.getGroup$6()); 
				}
			}else{
				Resource groupRes = queryService.getResourceAsPath(CommonConstants.PATH.GUEST_GROUP);
				Group currentGroup =(Group) queryService .getBo(groupRes.getId());
				groupList.add(currentGroup.getResource()); 
			}
			session.setCurrentGroup((Group) queryService.getBo(groupList
					 .iterator().next().getId()));
			session.getAttributes().put(Session.CS_ATTRIBLE_GROUPS_KEY,groupList); 
		}
	}

}
