package net.frank.dede.bean;


public class DedeMemberOperation extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String buyid;

	private String pname;

	private String product;

	private Integer money;

	private Integer mtime;

	private Integer pid;

	private Integer mid;

	private Integer sta;

	private String oldinfo;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getBuyid(){
		return this.buyid;
	}

	public void setBuyid(String buyid){
		this.buyid=buyid;
	}

	public String getPname(){
		return this.pname;
	}

	public void setPname(String pname){
		this.pname=pname;
	}

	public String getProduct(){
		return this.product;
	}

	public void setProduct(String product){
		this.product=product;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public Integer getMtime(){
		return this.mtime;
	}

	public void setMtime(Integer mtime){
		this.mtime=mtime;
	}

	public Integer getPid(){
		return this.pid;
	}

	public void setPid(Integer pid){
		this.pid=pid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getSta(){
		return this.sta;
	}

	public void setSta(Integer sta){
		this.sta=sta;
	}

	public String getOldinfo(){
		return this.oldinfo;
	}

	public void setOldinfo(String oldinfo){
		this.oldinfo=oldinfo;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getBuyid()+"\t"
		+this.getPname()+"\t"
		+this.getProduct()+"\t"
		+this.getMoney()+"\t"
		+this.getMtime()+"\t"
		+this.getPid()+"\t"
		+this.getMid()+"\t"
		+this.getSta()+"\t"
		+this.getOldinfo()+"\t"
		;
	}


}
