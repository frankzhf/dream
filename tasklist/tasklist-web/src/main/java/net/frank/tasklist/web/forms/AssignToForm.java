package net.frank.tasklist.web.forms;

import org.apache.struts.action.ActionForm;

public class AssignToForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2900033510764386749L;
	private Long resourceId;
	private Long accountResId;
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public Long getAccountResId() {
		return accountResId;
	}
	public void setAccountResId(Long accountResId) {
		this.accountResId = accountResId;
	}
	
}
