package net.frank.cms.web.core.forms.vo;

import java.util.Date;

public final class SessionView implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7514682043794881438L;
	private Boolean selected = Boolean.FALSE;
	private String clientIp;
	private String loginName;
	private Date prevRequestTime;
	private String platform;
	private String application;
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getPrevRequestTime() {
		return prevRequestTime;
	}
	public void setPrevRequestTime(Date prevRequestTime) {
		this.prevRequestTime = prevRequestTime;
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
