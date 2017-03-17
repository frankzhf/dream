package net.frank.titian.define;

import java.io.Serializable;
import java.util.Map;

public class AccountInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5427666832796677068L;
	
	private String retailerId;

	private String loginId;
	
	private String password;
	
	private boolean available;
	
	private Map<String,String> context;
	
	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Map<String, String> getContext() {
		return context;
	}

	public void setContext(Map<String, String> context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "AccountInfo [retailerId="+retailerId+"loginId=" + loginId + ", password=" + password + ", available=" + available + ", context="
				+ context + "]";
	}

	
	
	
	
}
