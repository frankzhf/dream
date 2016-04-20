package net.frank.framework.job.model;

import java.io.Serializable;

public class DataColumn implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7684190844369806143L;
	private String columnName;
	private String columnValue;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnValue() {
		return columnValue;
	}
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer(512);
		sb.append(getClass().getName()).append("[\n");
		sb.append("columnName : ").append(getColumnName()).append("\n");
		sb.append("columnValue : ").append(getColumnValue()).append("\n");
		sb.append("]\n");
		return sb.toString();
	}
}
