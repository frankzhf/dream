package net.frank.framework.dao.paginator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BaseEntity;

public class PaginatorData extends BaseEntity{
	
	public static final String SPRING_BEAN_ID = "pageinatorDate";
	
	/***
	 * 
	<bean id="pageinatorDate" class="net.frank.framework.dao.paginator.PaginatorData">
		<property name="pageSize" value="${project.global.paginator.default.size}" />
	</bean>
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4006824686888852905L;
	
	public final static String DEFAULT_TABLE_ALIAS = "t.";

	private Integer pageSize;
	
	private Integer countRecourds = 0;
	
	private Integer currentPage = 1;
	
	private Integer countPages = 1;
	
	private String queryHql;
	
	private String fullQueryHql;
	
	private Boolean existsCondition = false;

	private Map<String,Object> paramMap= new HashMap<String,Object>();
	
	private List<OrderData> orderByList = new ArrayList<OrderData>();
	
	public Boolean getExistsCondition() {
		return existsCondition;
	}

	public void setExistsCondition(Boolean existsCondition) {
		this.existsCondition = existsCondition;
	}
	
	public Object getParam(String key){
		return paramMap.get(key);
	}
	
	public void setParam(String key,Object value){
		if(value!=null){
			paramMap.put(key, value);
		}
	}
	
	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public void setOrderBy(int index,OrderData value){
		while(orderByList.size()<=index){
			orderByList.add(new OrderData());
		}
		orderByList.set(index, value);
	}
	
	public OrderData getOrderBy(int index){
		while(orderByList.size()<=index){
			orderByList.add(new OrderData());
		}
		return orderByList.get(index);
	}
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCountRecourds() {
		return countRecourds;
	}

	public void setCountRecourds(Integer countRecourds) {
		this.countRecourds = countRecourds;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getCountPages() {
		return countPages;
	}

	public void setCountPages(Integer countPages) {
		this.countPages = countPages;
	}

	public List<OrderData> getOrderByList() {
		return orderByList;
	}

	public void setOrderByList(List<OrderData> orderByList) {
		this.orderByList = orderByList;
	}
	
	public String getQueryHql() {
		return queryHql;
	}

	public void setQueryHql(String queryHql) {
		this.queryHql = queryHql;
	}
	
	public String getFullQueryHql() {
		if(fullQueryHql == null){
			StringBuffer sbHql = new StringBuffer(getQueryHql());
			Map<String, Object> paramMap = getParamMap();
			for (Iterator<String> it = paramMap.keySet().iterator(); it.hasNext();) {
				String mapKey = it.next();
				Object param = paramMap.get(mapKey);
				if (param != null && !CommonConstants.EMPTY_STRING.equals(param)
						&& !CommonConstants.SPACE.equals(param)) {
					if (!getExistsCondition()) {
						sbHql.append(" where ");
						setExistsCondition(Boolean.TRUE);
					} else {
						sbHql.append(" and ");
					}
					sbHql.append(DEFAULT_TABLE_ALIAS + mapKey + " like  :" + mapKey);
				}
			}
			fullQueryHql = sbHql.toString();
		}
		return fullQueryHql;
	}
	
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[\n");
		sb.append("pageSize:\t"+pageSize);
		sb.append("\ncountRecourds:\t"+countRecourds);
		sb.append("\ncurrentPage:\t"+currentPage);
		sb.append("\ncountPages:\t"+countPages);
		sb.append("\nparamMap: [" + paramMap + "]");
		sb.append("\norderList: [" + orderByList + "]");
		sb.append("]\n");
		return sb.toString();
	}
}
