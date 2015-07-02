package net.frank.framework.thin;

import net.frank.framework.bo.BaseEntity;

public class OrderBy extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3374032339093808644L;

	public static final Integer ORDER_STATUS_EMPTY = 0;
	
	public static final Integer ORDER_STATUS_ASC = 1;
	
	public static final Integer ORDER_STATUS_DESC = 2;
	
	private String columnName;
	
	private Integer orderStatus = ORDER_STATUS_EMPTY;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
}
