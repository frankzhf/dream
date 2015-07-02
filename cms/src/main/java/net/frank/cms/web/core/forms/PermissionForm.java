package net.frank.cms.web.core.forms;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public class PermissionForm extends ActionForm {
	
	private static final long serialVersionUID = -5573142775342987023L;
	
	private Boolean chagePermissionFlag = Boolean.TRUE;
	private String resourceFullPath;
	private Boolean chageOwnFlag = Boolean.FALSE;
	private Long ownResourceId;
	private Boolean chageGroupFlag = Boolean.FALSE;
	private Long groupResourceId;
	private Boolean recursive = Boolean.FALSE;
	
	private Map<Integer, Boolean> permissionMap = new HashMap<Integer, Boolean>();
	
	public PermissionForm(){
		setPermission("0",Boolean.FALSE);
		setPermission("1",Boolean.FALSE);
		setPermission("2",Boolean.FALSE);
		setPermission("3",Boolean.FALSE);
		setPermission("4",Boolean.FALSE);
		setPermission("5",Boolean.FALSE);
		setPermission("6",Boolean.FALSE);
		setPermission("7",Boolean.FALSE);
		setPermission("8",Boolean.FALSE);
	}
	
	
	public Boolean getChagePermissionFlag() {
		return chagePermissionFlag;
	}

	public void setChagePermissionFlag(Boolean chagePermissionFlag) {
		this.chagePermissionFlag = chagePermissionFlag;
	}

	public String getResourceFullPath() {
		return resourceFullPath;
	}

	public void setResourceFullPath(String resourceFullPath) {
		this.resourceFullPath = resourceFullPath;
	}

	public Boolean getChageOwnFlag() {
		return chageOwnFlag;
	}

	public void setChageOwnFlag(Boolean chageOwnFlag) {
		this.chageOwnFlag = chageOwnFlag;
	}

	public Long getOwnResourceId() {
		return ownResourceId;
	}

	public void setOwnResourceId(Long ownResourceId) {
		this.ownResourceId = ownResourceId;
	}

	public Boolean getChageGroupFlag() {
		return chageGroupFlag;
	}

	public void setChageGroupFlag(Boolean chageGroupFlag) {
		this.chageGroupFlag = chageGroupFlag;
	}

	public Long getGroupResourceId() {
		return groupResourceId;
	}

	public void setGroupResourceId(Long groupResourceId) {
		this.groupResourceId = groupResourceId;
	}

	public Boolean getRecursive() {
		return recursive;
	}

	public void setRecursive(Boolean recursive) {
		this.recursive = recursive;
	}

	public Map<Integer, Boolean> getPermissionMap() {
		return permissionMap;
	}

	public void setPermissionMap(Map<Integer, Boolean> permissionMap) {
		this.permissionMap = permissionMap;
	}

	public Boolean getPermission(String key) {
		Integer _key = Integer.decode(key);
		return permissionMap.get(_key);
	}

	public void setPermission(String key, Boolean obj) {
		Integer _key = Integer.decode(key);
		permissionMap.put(_key, obj);
	}
	
}
