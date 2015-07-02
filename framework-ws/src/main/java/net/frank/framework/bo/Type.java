package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;

public class Type extends BusinessObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6201224799854668542L;

	private String typeKey;
	
	private String description;
	
	private String entityClassName;
	
	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	public String getEntityClassName() {
		return entityClassName;
	}
}
