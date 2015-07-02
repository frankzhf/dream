package net.frank.cms.web.common.forms;

import org.apache.struts.action.ActionForm;

public class DialogForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6385298769662513676L;
	
	private Long currentTime;
	
	private String fieldName;
	
	private String fieldValue;
	
	private String elementId;
	
	private Long dialogRootId;
	
	private Long resourceId;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}

	public Long getCurrentTime() {
		return currentTime;
	}

	public Long getDialogRootId() {
		return dialogRootId;
	}

	public void setDialogRootId(Long dialogRootId) {
		this.dialogRootId = dialogRootId;
	}
}