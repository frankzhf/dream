package net.frank.cms.web.core.forms;

import org.apache.struts.action.ActionForm;

public class TypeRegistrationForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2691980881762321218L;

	private Long appResourceId;
	
	private String entityClassName;
	
	private String description;
	
	private String typeKey;

	public Long getAppResourceId() {
		return appResourceId;
	}

	public void setAppResourceId(Long appResourceId) {
		this.appResourceId = appResourceId;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}
	
	
}
