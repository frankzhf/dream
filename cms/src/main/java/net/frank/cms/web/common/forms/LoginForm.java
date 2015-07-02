package net.frank.cms.web.common.forms;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = -832048549184658810L;
	private String userName;
	private String password;
	private String localCd;
	private String platform;
	private String application;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLocalCd(String localCd) {
		this.localCd = localCd;
	}
	public String getLocalCd() {
		return localCd;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
	
}
