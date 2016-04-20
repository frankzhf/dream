package net.frank.framework.thin;

import java.util.List;

import net.frank.framework.bo.BaseEntity;

public class SimpleQueryPage extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7813523051452693574L;
	
	private List<Condition> conditionList;
	
	private List<OrderBy> orderByList;
	
	private Integer currentPage = 1;
	
	private Integer size;
	
	private Integer count;
	
	private char[] mainQuerySql;

	private String rowMapperName;
	
	private List<BaseEntity> result;

	public List<Condition> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<Condition> conditionList) {
		this.conditionList = conditionList;
	}

	public List<OrderBy> getOrderByList() {
		return orderByList;
	}

	public void setOrderByList(List<OrderBy> orderByList) {
		this.orderByList = orderByList;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	public char[] getMainQuerySql() {
		return mainQuerySql;
	}

	public void setMainQuerySql(char[] mainQuerySql) {
		this.mainQuerySql = mainQuerySql;
	}

	public String getRowMapperName() {
		return rowMapperName;
	}

	public void setRowMapperName(String rowMapperName) {
		this.rowMapperName = rowMapperName;
	}

	public List<BaseEntity> getResult() {
		return result;
	}

	public void setResult(List<BaseEntity> result) {
		this.result = result;
	}
	
	public void next(){
		currentPage++;
	}
	
	public void previous(){
		currentPage--;
	}
	
	public void first(){
		currentPage = 1;
	}
	
	public void last(){
		if(count!=null && count!=0)
			currentPage = count;
	}
	
	public void goTo(Integer page){
		currentPage = page;
	}
	
}
