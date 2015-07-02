package net.frank.framework.security;

import java.util.List;
import java.util.Map;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;


public interface Session {
	
	public static final String CS_ATTRIBLE_GROUPS_KEY = "cs-groups";
	public static final String CS_ATTRIBLE_PRIVILEGES_KEY = "cs-privileges";
	public static final String CS_ATTRIBLE_TYPES_KEY = "cs-types";
	
	
	public static final Integer STATUS_INITIAL = 0;
	public static final Integer STATUS_LOGINED = 1;
	public static final Integer STATUS_NOT_EXISTS = -1;
	public static final Integer STATUS_INCORRERT_PW = -2;
	
	public static final Integer LOGIN_TYPE_DEFAULT = 0;
	public static final Integer LOGIN_TYPE_LDAP = 1;
	
	public interface ATTRIBUTE_KEY{
		public String IS_ADMIN = "cs-is-admin";
	}
	
	public String getLocalCd();
	
	public void setLocalCd(String localCd);
	
	public Integer getLoginType();
	
	public Integer getStatus();
	
	public void setStatus(Integer status);
		
	public String getLoginName();
	
	public Account getAccount();
	
	public Group getCurrentGroup();
	
	public List<Resource> getGroups();
	
	public List<Privilege> getPrivileges();
	
	public Map<Long,Type> getUserTypeMap();
	
	public void setAccount(Account account);
	
	public void setCurrentGroup(Group currentGroup);
	
	public void setAttributes(Map<String, Object> attributes);
	
	public Map<String, Object> getAttributes();
	
	public void setAttribute(String key, Object value);
	
	public Object getAttribute(String key);
}
