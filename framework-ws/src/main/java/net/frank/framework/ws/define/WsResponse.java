package net.frank.framework.ws.define;

import java.io.Serializable;
import java.util.Date;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;

public class WsResponse extends BaseEntity implements Serializable {
	
	public static final Integer MESSAGE_SESSION_EXPIRED = -100;
	
	private static final long serialVersionUID = 8280647674366458166L;
	
	private Integer messageNumber = CommonConstants.CMS_CODE.MESSAGE_OK;
	
	private Date createDate = new Date();
	
	private Resource resource;

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

	public void setMessageNumber(Integer messageNumber) {
		this.messageNumber = messageNumber;
	}

	public Integer getMessageNumber() {
		return messageNumber;
	}
}
