package net.frank.tasklist.web.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.frank.tasklist.CommonConstants;

public class AccountView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4162436740579971054L;
	
	private Long accountResId;
	
	private String loginName;
	
	private List<GroupView> groupList = new ArrayList<GroupView>();

	public Long getAccountResId() {
		return accountResId;
	}

	public void setAccountResId(Long accountResId) {
		this.accountResId = accountResId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public List<GroupView> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<GroupView> groupList) {
		this.groupList = groupList;
	}
	
	public String getDisplayGroup(){
		StringBuffer sb = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		if(groupList!=null && !groupList.isEmpty()){
			for(int i=0;i<groupList.size();i++){
				GroupView gv = groupList.get(i);
				if(i != 0){
					sb.append(CommonConstants.COMMA);
				}
				sb.append(gv.getGroupName());
			}
		}
		return sb.toString();
	}
}
