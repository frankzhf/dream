package net.frank.framework.ws.define;

import java.io.Serializable;
import java.util.Date;

import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;

public class WsRequest extends BaseEntity implements Serializable {
	
	public static final Integer ACTION_GET = 1;
	
	public static final Integer ACTION_CREATE = 2;
	
	public static final Integer ACTION_UPDATE = 3;
	
	public static final Integer ACTION_DELETE = 4;
	
	private static final long serialVersionUID = 681788683324839510L;

	private Integer action = ACTION_GET;
	
	private Date createDate = new Date();
	
	private Resource resource;

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createdDate) {
		this.createDate = createdDate;
	}
}
