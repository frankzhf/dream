package net.frank.framework.bsui.grid;

import java.util.List;

import net.frank.framework.bo.Resource;

public class DataSource {
	
	private int total;
	
	private List<Resource> data;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Resource> getData() {
		return data;
	}
	
	public void setData(List<Resource> data){
		this.data = data;
	}
}
