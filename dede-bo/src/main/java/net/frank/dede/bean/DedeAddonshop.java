package net.frank.dede.bean;


public class DedeAddonshop extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private char[] body;

	private Float price;

	private Float trueprice;

	private String brand;

	private String units;

	private String templet;

	private String userip;

	private String redirecturl;

	private String vocation;

	private String infotype;

	private Integer uptime;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public char[] getBody(){
		return this.body;
	}

	public void setBody(char[] body){
		this.body=body;
	}

	public Float getPrice(){
		return this.price;
	}

	public void setPrice(Float price){
		this.price=price;
	}

	public Float getTrueprice(){
		return this.trueprice;
	}

	public void setTrueprice(Float trueprice){
		this.trueprice=trueprice;
	}

	public String getBrand(){
		return this.brand;
	}

	public void setBrand(String brand){
		this.brand=brand;
	}

	public String getUnits(){
		return this.units;
	}

	public void setUnits(String units){
		this.units=units;
	}

	public String getTemplet(){
		return this.templet;
	}

	public void setTemplet(String templet){
		this.templet=templet;
	}

	public String getUserip(){
		return this.userip;
	}

	public void setUserip(String userip){
		this.userip=userip;
	}

	public String getRedirecturl(){
		return this.redirecturl;
	}

	public void setRedirecturl(String redirecturl){
		this.redirecturl=redirecturl;
	}

	public String getVocation(){
		return this.vocation;
	}

	public void setVocation(String vocation){
		this.vocation=vocation;
	}

	public String getInfotype(){
		return this.infotype;
	}

	public void setInfotype(String infotype){
		this.infotype=infotype;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+new String(this.getBody())+"\t"
		+this.getPrice()+"\t"
		+this.getTrueprice()+"\t"
		+this.getBrand()+"\t"
		+this.getUnits()+"\t"
		+this.getTemplet()+"\t"
		+this.getUserip()+"\t"
		+this.getRedirecturl()+"\t"
		+this.getVocation()+"\t"
		+this.getInfotype()+"\t"
		+this.getUptime()+"\t"
		;
	}


}
