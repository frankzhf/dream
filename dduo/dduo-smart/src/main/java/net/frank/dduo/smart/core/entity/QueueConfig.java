package net.frank.dduo.smart.core.entity;

import java.io.Serializable;

public class QueueConfig implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5713225252772672706L;

	private String queueName;
	
	private String ip;
	
	private String port;
	
	private String user;
	
	private String pwd;
	
	private String groupId;
	
	private String backup;

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	@Override
	public String toString() {
		return "QueueConfig [queueName=" + queueName + ", ip=" + ip + ", port=" + port + ", user=" + user + ", pwd="
				+ pwd + ", groupId=" + groupId + ", backup=" + backup + "]";
	}
	
	
	
}
