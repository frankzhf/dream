package net.frank.framework.ws.define;

import java.io.Serializable;

import net.frank.framework.bo.BaseEntity;

public class WsAaInfo extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -5927067166252332645L;

	public static final Integer NO_LOGINED = 0;
	
	public static final Integer LOGINED = 1;
	
	private String loginName;
	
	private String password;
	
	private String platform;
	
	private String application;
	
	private Integer loginStatus = NO_LOGINED;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	
}
