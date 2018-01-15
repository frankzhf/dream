package net.frank.corejava0.netty.ch09;

import java.io.Serializable;

public class SubResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1646671473363654408L;
	private Integer subScriptID;
	private String respCode;
	private String desc;
	public Integer getSubScriptID() {
		return subScriptID;
	}
	public void setSubScriptID(Integer subScriptID) {
		this.subScriptID = subScriptID;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "SubResponse [subScriptID=" + subScriptID + ", respCode=" + respCode + ", desc=" + desc + "]";
	}
	
	
	
}
