package net.frank.framework.thin.tools.model;

import java.util.List;

public class TableData {
	private String tableName;
	private String javaClassName;
	private List<Column> columnList;
	private List<Column> pkList;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getJavaClassName() {
		return javaClassName;
	}
	public void setJavaClassName(String javaClassName) {
		this.javaClassName = javaClassName;
	}
	public List<Column> getColumnList() {
		return columnList;
	}
	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	public List<Column> getPkList() {
		return pkList;
	}
	public void setPkList(List<Column> pkList) {
		this.pkList = pkList;
	}
	
}
