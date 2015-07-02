package net.frank.framework.dao.paginator;

import net.frank.framework.bo.BaseEntity;

public class OrderData extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8834046274608357607L;
	private String fieldName;
	private Boolean asc;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Boolean isAsc() {
		return asc;
	}
	public void setAsc(Boolean asc) {
		this.asc = asc;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[\n");
		sb.append("fieldName:\t"+fieldName);
		sb.append("\nasc:\t"+asc);
		sb.append("\n]\n");
		return sb.toString();
	}
}
