package net.frank.dede.bean;


public class DedeMemberCompany extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String company;

	private String product;

	private Integer place;

	private Integer vocation;

	private Integer cosize;

	private String tel;

	private String fax;

	private String linkman;

	private String address;

	private String mobile;

	private String email;

	private String url;

	private Integer uptime;

	private Boolean checked;

	private char[] introduce;

	private String comface;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getCompany(){
		return this.company;
	}

	public void setCompany(String company){
		this.company=company;
	}

	public String getProduct(){
		return this.product;
	}

	public void setProduct(String product){
		this.product=product;
	}

	public Integer getPlace(){
		return this.place;
	}

	public void setPlace(Integer place){
		this.place=place;
	}

	public Integer getVocation(){
		return this.vocation;
	}

	public void setVocation(Integer vocation){
		this.vocation=vocation;
	}

	public Integer getCosize(){
		return this.cosize;
	}

	public void setCosize(Integer cosize){
		this.cosize=cosize;
	}

	public String getTel(){
		return this.tel;
	}

	public void setTel(String tel){
		this.tel=tel;
	}

	public String getFax(){
		return this.fax;
	}

	public void setFax(String fax){
		this.fax=fax;
	}

	public String getLinkman(){
		return this.linkman;
	}

	public void setLinkman(String linkman){
		this.linkman=linkman;
	}

	public String getAddress(){
		return this.address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getMobile(){
		return this.mobile;
	}

	public void setMobile(String mobile){
		this.mobile=mobile;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public Boolean getChecked(){
		return this.checked;
	}

	public void setChecked(Boolean checked){
		this.checked=checked;
	}

	public char[] getIntroduce(){
		return this.introduce;
	}

	public void setIntroduce(char[] introduce){
		this.introduce=introduce;
	}

	public String getComface(){
		return this.comface;
	}

	public void setComface(String comface){
		this.comface=comface;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getCompany()+"\t"
		+this.getProduct()+"\t"
		+this.getPlace()+"\t"
		+this.getVocation()+"\t"
		+this.getCosize()+"\t"
		+this.getTel()+"\t"
		+this.getFax()+"\t"
		+this.getLinkman()+"\t"
		+this.getAddress()+"\t"
		+this.getMobile()+"\t"
		+this.getEmail()+"\t"
		+this.getUrl()+"\t"
		+this.getUptime()+"\t"
		+this.getChecked()+"\t"
		+new String(this.getIntroduce())+"\t"
		+this.getComface()+"\t"
		;
	}


}
