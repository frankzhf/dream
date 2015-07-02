package net.frank.tasklist.bo;

import java.util.Date;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

public final class Task extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4819120117970192772L;

	public static final Integer STATUS_DRAFT=0;
	
	public static final Integer STATUS_OPEN=1;
	
	public static final Integer STATUS_CLOSE=2;
	
	private String taskId;
	
	private String taskSummary;
	
	private char[] description;
	
	private Resource unit$14=new Resource();
	
	private Integer status;
	
	private Resource context$3=new Resource();
	
	private Date startDate;
	
	private Date targetDate;
	
	private Date endDate;
	
	private Boolean reOpen;
	
	private Resource refTask$50002 = new Resource();
	
	private Resource parentTask$50002 = new Resource();

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskSummary(){
		return taskSummary;
	}
	
	public void setTaskSummary(String taskSummary){
		this.taskSummary = taskSummary;
	}

	public char[] getDescription() {
		return description;
	}

	public void setDescription(char[] description) {
		this.description = description;
	}

	public Resource getUnit$14() {
		return unit$14;
	}

	public void setUnit$14(Resource unit$14) {
		this.unit$14 = unit$14;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Resource getContext$3() {
		return context$3;
	}

	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getTargetDate(){
		return targetDate;
	}
	
	public void setTargetDate(Date targetDate){
		this.targetDate = targetDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getReOpen() {
		return reOpen;
	}

	public void setReOpen(Boolean reOpen) {
		this.reOpen = reOpen;
	}

	public Resource getRefTask$50002() {
		return refTask$50002;
	}

	public void setRefTask$50002(Resource refTask$50002) {
		this.refTask$50002 = refTask$50002;
	}

	public Resource getParentTask$50002() {
		return parentTask$50002;
	}

	public void setParentTask$50002(Resource parentTask$50002) {
		this.parentTask$50002 = parentTask$50002;
	}
	
}