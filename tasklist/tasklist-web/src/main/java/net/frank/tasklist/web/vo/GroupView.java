package net.frank.tasklist.web.vo;

import java.io.Serializable;

public class GroupView implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5348740993054753562L;
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
