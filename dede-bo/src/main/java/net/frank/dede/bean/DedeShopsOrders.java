package net.frank.dede.bean;


public class DedeShopsOrders extends net.frank.framework.bo.BaseEntity{


	private String oid;

	private Integer userid;

	private Integer pid;

	private Byte paytype;

	private Integer cartcount;

	private Float dprice;

	private Float price;

	private Float pricecount;

	private Boolean state;

	private String ip;

	private Integer stime;





	public String getOid(){
		return this.oid;
	}

	public void setOid(String oid){
		this.oid=oid;
	}

	public Integer getUserid(){
		return this.userid;
	}

	public void setUserid(Integer userid){
		this.userid=userid;
	}

	public Integer getPid(){
		return this.pid;
	}

	public void setPid(Integer pid){
		this.pid=pid;
	}

	public Byte getPaytype(){
		return this.paytype;
	}

	public void setPaytype(Byte paytype){
		this.paytype=paytype;
	}

	public Integer getCartcount(){
		return this.cartcount;
	}

	public void setCartcount(Integer cartcount){
		this.cartcount=cartcount;
	}

	public Float getDprice(){
		return this.dprice;
	}

	public void setDprice(Float dprice){
		this.dprice=dprice;
	}

	public Float getPrice(){
		return this.price;
	}

	public void setPrice(Float price){
		this.price=price;
	}

	public Float getPricecount(){
		return this.pricecount;
	}

	public void setPricecount(Float pricecount){
		this.pricecount=pricecount;
	}

	public Boolean getState(){
		return this.state;
	}

	public void setState(Boolean state){
		this.state=state;
	}

	public String getIp(){
		return this.ip;
	}

	public void setIp(String ip){
		this.ip=ip;
	}

	public Integer getStime(){
		return this.stime;
	}

	public void setStime(Integer stime){
		this.stime=stime;
	}





	public String toString(){
		return ""
		+this.getOid()+"\t"
		+this.getUserid()+"\t"
		+this.getPid()+"\t"
		+this.getPaytype()+"\t"
		+this.getCartcount()+"\t"
		+this.getDprice()+"\t"
		+this.getPrice()+"\t"
		+this.getPricecount()+"\t"
		+this.getState()+"\t"
		+this.getIp()+"\t"
		+this.getStime()+"\t"
		;
	}


}
