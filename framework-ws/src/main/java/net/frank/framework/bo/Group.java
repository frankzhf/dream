package net.frank.framework.bo;

public final class Group extends BusinessObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4137849493682469150L;

	private static final String ICON_PATH = "/global/images/xloadtree2b/group_icon.jpg";
	
	private String groupName;
	
	private String groupDescirption;
	
	private Boolean temporary;
	
	public String getGroupDescirption() {
		return groupDescirption;
	}

	public void setGroupDescirption(String groupDescirption) {
		this.groupDescirption = groupDescirption;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Boolean getTemporary() {
		return temporary;
	}

	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}
	
	@Override
	public String getNodeIcon() {
		return ICON_PATH;
	}
	
	@Override
	public String getNodeOpenIcon() {
		return ICON_PATH;
	}
	
}
