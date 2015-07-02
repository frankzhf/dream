package net.frank.dede.bean;


public class DedeShopsDelivery extends net.frank.framework.bo.BaseEntity{


	private Integer pid;

	private String dname;

	private Float price;

	private String des;

	private Integer orders;





	public Integer getPid(){
		return this.pid;
	}

	public void setPid(Integer pid){
		this.pid=pid;
	}

	public String getDname(){
		return this.dname;
	}

	public void setDname(String dname){
		this.dname=dname;
	}

	public Float getPrice(){
		return this.price;
	}

	public void setPrice(Float price){
		this.price=price;
	}

	public String getDes(){
		return this.des;
	}

	public void setDes(String des){
		this.des=des;
	}

	public Integer getOrders(){
		return this.orders;
	}

	public void setOrders(Integer orders){
		this.orders=orders;
	}





	public String toString(){
		return ""
		+this.getPid()+"\t"
		+this.getDname()+"\t"
		+this.getPrice()+"\t"
		+this.getDes()+"\t"
		+this.getOrders()+"\t"
		;
	}


}
