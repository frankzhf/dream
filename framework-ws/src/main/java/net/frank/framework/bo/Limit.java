package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;

public class Limit extends BusinessObject {
	
	private static final long serialVersionUID = -8345458334837200272L;
	
	private String limitName;
	private Long limitValue;
	private Long currentValue;
	public String getLimitName() {
		return limitName;
	}
	public void setLimitName(String limitName) {
		this.limitName = limitName;
	}
	public Long getLimitValue() {
		return limitValue;
	}
	public void setLimitValue(Long limitValue) {
		this.limitValue = limitValue;
	}
	public Long getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(Long currentValue) {
		this.currentValue = currentValue;
	}
	
}
