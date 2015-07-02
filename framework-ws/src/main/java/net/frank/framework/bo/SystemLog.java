package net.frank.framework.bo;

import java.io.Serializable;
import java.util.Date;

public final class SystemLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9133868900748527616L;
	private Long id;
	private String action;
	private String result;
	private String desc;
	private Long opResoureId;
	private Date logDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getOpResoureId() {
		return opResoureId;
	}
	public void setOpResoureId(Long opResoureId) {
		this.opResoureId = opResoureId;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
}
