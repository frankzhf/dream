package net.frank.framework.ws.define;

import java.io.Serializable;

import net.frank.framework.bo.BaseEntity;

public class WsRegister extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	
	public static final Integer NO_REGISATION = 0;
	
	public static final Integer REGISATION = 1;
	
	public static final Integer EXIST = -1;
	
	private static final long serialVersionUID = -1362282987978538995L;
	
	private String loginId;
	
	private String password;
	
	private Integer status = NO_REGISATION;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
