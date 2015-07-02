package net.frank.springweb.home.form;

import java.io.Serializable;

public class LoginForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6752151817634168557L;

	private String loginname;
	
	private String password;
	
	private Integer screenWith;
	
	private Integer screenHeight;

	public Integer getScreenWith() {
		return screenWith;
	}

	public void setScreenWith(Integer screenWith) {
		this.screenWith = screenWith;
	}

	public Integer getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(Integer screenHeight) {
		this.screenHeight = screenHeight;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
