package net.frank.framework.bo;

import java.io.Serializable;

public class Acl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8082800912380203635L;
	private Long id;
	private Long resourceId;
	private Long ownId;
	private Byte permission;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public Long getOwnId() {
		return ownId;
	}
	public void setOwnId(Long ownId) {
		this.ownId = ownId;
	}
	public Byte getPermission() {
		return permission;
	}
	public void setPermission(Byte permission) {
		this.permission = permission;
	}
}