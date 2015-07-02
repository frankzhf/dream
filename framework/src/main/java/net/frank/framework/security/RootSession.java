package net.frank.framework.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;

public class RootSession implements Session{
	
	private static final String DEFAULT_LOCAL_CD = "en_US";
	
	private static final String DEFAULT_ROOT_PATH = "/home/root";
	
	private static final String DEFAULT_ADMIN_PATH = "/group/Admin";
	
	private static Account account;
	
	private static Group group;
	
	private static List<Privilege> privilegeList;
	static{	
		privilegeList = new ArrayList<Privilege>();
		Privilege rr = new Privilege();
		Resource domainRes = new Resource();
		domainRes.setId(CommonConstants.RESOURCE_ID.ROOT);
		rr.setDomain$3(domainRes);
		privilegeList.add(rr);
	}
	
	@Override
	public String getLocalCd() {
		return DEFAULT_LOCAL_CD;
	}

	@Override
	public void setLocalCd(String localCd) {
		
	}

	@Override
	public Integer getLoginType() {
		return Session.LOGIN_TYPE_DEFAULT;
	}

	@Override
	public Integer getStatus() {
		return Session.STATUS_LOGINED;
	}

	@Override
	public void setStatus(Integer status) {
		
	}

	@Override
	public String getLoginName() {
		if(account == null ){
			getAccount();
		}
		return account.getLoginName();
	}

	@Override
	public Account getAccount() {
		if(account == null){
			QueryService queryService = (QueryService) SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
			Resource accountRes = queryService.getResourceAsPath(DEFAULT_ROOT_PATH);
			account = ((Account) queryService.getBo(accountRes)).clone();
		}
		return account;
	}

	@Override
	public Group getCurrentGroup() {
		if(group == null){
			QueryService queryService = (QueryService) SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
			Resource groupRes = queryService.getResourceAsPath(DEFAULT_ADMIN_PATH);
			group = (Group) queryService.getBo(groupRes);
		}
		return group;
	}

	@Override
	public List<Resource> getGroups() {
		return null;
	}

	@Override
	public List<Privilege> getPrivileges() {
		return privilegeList;
	}
	

	@Override
	public Map<Long,Type> getUserTypeMap(){
		return null;
	}

	@Override
	public void setAccount(Account account) {
		
	}

	@Override
	public void setCurrentGroup(Group currentGroup) {
		
	}

	@Override
	public void setAttributes(Map<String, Object> attributes) {
		
	}

	@Override
	public Map<String, Object> getAttributes() {
		return null;
	}

	@Override
	public void setAttribute(String key, Object value) {
		
	}

	@Override
	public Object getAttribute(String key) {
		return null;
	}

}
