package net.frank.framework.ftp.model;

import net.frank.commons.CommonConstants;

public class FtpConnectInfo {
	
	private String serverIp;
	private int serverPort=21;
	private boolean anonymous=false;
	private String userName;
	private String password;
	private boolean pasv=false;
	private String workingDirectory=CommonConstants.PATH_SYMBOL;
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
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
	public boolean isPasv() {
		return pasv;
	}
	public void setPasv(boolean pasv) {
		this.pasv = pasv;
	}
	public String getWorkingDirectory() {
		return workingDirectory;
	}
	public void setWorkingDirectory(String workingDirectory) {
		this.workingDirectory = workingDirectory;
	}
	/**
	 * private String anonymousUserName;
	private String anonymousPassword;
	private String userName;
	private String password;
	private boolean isPasv=false;
	private String workingDirectory;
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		sb.append(getClass()).append(CommonConstants.LEFT_MED_BRACKET).append(CommonConstants.STRING_ENTER)
			.append("serverIp -> ").append(getServerIp()).append(CommonConstants.STRING_ENTER)
			.append("serverPort -> ").append(getServerPort()).append(CommonConstants.STRING_ENTER)
			.append("isAnonymous -> ").append(isAnonymous()).append(CommonConstants.STRING_ENTER)
			.append("userName -> ").append(getUserName()).append(CommonConstants.STRING_ENTER)
			.append("password -> ").append(getPassword()).append(CommonConstants.STRING_ENTER)
			.append("isPasv -> ").append(isPasv()).append(CommonConstants.STRING_ENTER)
			.append("workingDirectory -> ").append(getWorkingDirectory()).append(CommonConstants.RIGHT_MED_BRACKET);
		return sb.toString();
	}
	
	
}
