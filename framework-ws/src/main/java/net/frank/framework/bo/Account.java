package net.frank.framework.bo;

import java.util.Map;

import net.frank.framework.bo.BusinessObject;

public final class Account extends BusinessObject implements Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5495296179820702210L;

	public static final Integer TYPE_DEFAULT = 0;
	
	public static final Integer TYPE_LDAP = 1;
	
	public static final Integer TYPE_OTHERS = 2;
	
	private static final String ICON_PATH = "/global/images/xloadtree2b/account_icon.jpg";
	
	private String loginName;

	private String password;

	private String umask;
	
	private String email;
	
	private Resource staff$16 =new Resource();

	private Resource home$3 = new Resource();

	private Map<String, Object> params;
	
	private Integer type=TYPE_DEFAULT;

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getUmask() {
		return umask;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUmask(String umask) {
		this.umask = umask;
	}

	public Resource getHome$3() {
		return home$3;
	}

	public void setHome$3(Resource home$3) {
		this.home$3 = home$3;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	@Override
	public String getNodeIcon() {
		return ICON_PATH;
	}
	
	@Override
	public String getNodeOpenIcon() {
		return ICON_PATH;
	}

	@Override
	public Account clone() {
		Object cloneObject = null;
		cloneObject = super.clone();
		Account _clone = cloneObject instanceof Account ? (Account) cloneObject
				: null;
		return _clone;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void setStaff$16(Resource staff$16){
		this.staff$16 = staff$16;
	}
	
	public Resource getStaff$16(){
		return staff$16;
	}
	
}
