package net.frank.framework.bo;

import java.io.Serializable;
import java.util.Date;

public final class SystemHistory  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2078896929642566566L;
	
	private Long id;
	private Long resourceId;
	private Date logDate;
	private Long opResoureId;
	private byte[] historyContent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getResourceId(){
		return resourceId;
	}
	public void setResourceId(Long resourceId){
		this.resourceId = resourceId;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public Long getOpResoureId() {
		return opResoureId;
	}
	public void setOpResoureId(Long opResoureId) {
		this.opResoureId = opResoureId;
	}
	public byte[] getHistoryContent() {
		return historyContent;
	}
	public void setHistoryContent(byte[] historyContent) {
		this.historyContent = historyContent;
	}
	
}
