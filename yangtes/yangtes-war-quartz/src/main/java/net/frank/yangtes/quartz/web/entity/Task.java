package net.frank.yangtes.quartz.web.entity;

import net.frank.yangtes.commons.persistence.DataEntity;

public class Task extends DataEntity<Task> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7094237365019014946L;

	private String clazzName;
	
	private String desc;

	private Byte status;
	
	private String timeRule;
	
	private String ruleDesc;
	
	private String branchId;
	

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getTimeRule() {
		return timeRule;
	}

	public void setTimeRule(String timeRule) {
		this.timeRule = timeRule;
	}

	public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}


	@Override
	public String toString() {
		return "Task [clazzName=" + clazzName + ", desc=" + desc + ", status=" + status + ", timeRule=" + timeRule + ", ruleDesc="
				+ ruleDesc + ", branchId=" + branchId  + "]";
	}
	
	
}
