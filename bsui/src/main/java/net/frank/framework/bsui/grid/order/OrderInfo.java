package net.frank.framework.bsui.grid.order;

public class OrderInfo {
	
	public static final String ORDER_FLAG_DESC = "D";
	public static final String ORDER_FLAG_ASC = "A";
	public static final String ORDER_FLAG_NVL = "N";
	
	private String field;
	private String orderFlag;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(String orderFlag) {
		this.orderFlag = orderFlag;
	}
	
	
	
	
}
