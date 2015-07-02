package net.frank.framework.bsui.grid;

import java.util.Map;

import net.frank.framework.bsui.grid.order.OrderInfo;
import net.frank.framework.bsui.grid.filter.FilterCondition;;

public class Field {
	private OrderInfo orderInfo;
	private Map<String,FilterCondition> filterMap;
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Map<String, FilterCondition> getFilterMap() {
		return filterMap;
	}
	public void setFilterMap(Map<String, FilterCondition> filterMap) {
		this.filterMap = filterMap;
	}
}
