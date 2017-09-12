package net.frank.yangtes.modules.sys.security;

import java.io.Serializable;

import net.frank.yangtes.modules.sys.entity.User;
import net.frank.yangtes.modules.sys.utils.UserUtils;

public class Principal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 725756449149746215L;
	private String id; // 编号
	private String loginName; // 登录名
	private String name; // 姓名
	private boolean mobileLogin; // 是否手机登录
	public Principal(User user, boolean mobileLogin) {
		this.id = user.getId();
		this.loginName = user.getLoginName();
		this.name = user.getName();
		this.mobileLogin = mobileLogin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMobileLogin() {
		return mobileLogin;
	}
	public void setMobileLogin(boolean mobileLogin) {
		this.mobileLogin = mobileLogin;
	}
	
	/**
	 * 获取SESSIONID
	 */
	public String getSessionid() {
		try{
			return (String) UserUtils.getSession().getId();
		}catch (Exception e) {
			return "";
		}
	}
	@Override
	public String toString() {
		return "Principal [id=" + id + ", loginName=" + loginName + ", name=" + name + ", mobileLogin=" + mobileLogin
				+ "]";
	}
	
	
}
