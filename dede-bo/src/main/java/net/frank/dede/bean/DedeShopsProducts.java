package net.frank.dede.bean;


public class DedeShopsProducts extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String oid;

	private Integer userid;

	private String title;

	private Float price;

	private Integer buynum;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

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

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public Float getPrice(){
		return this.price;
	}

	public void setPrice(Float price){
		this.price=price;
	}

	public Integer getBuynum(){
		return this.buynum;
	}

	public void setBuynum(Integer buynum){
		this.buynum=buynum;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getOid()+"\t"
		+this.getUserid()+"\t"
		+this.getTitle()+"\t"
		+this.getPrice()+"\t"
		+this.getBuynum()+"\t"
		;
	}


}
