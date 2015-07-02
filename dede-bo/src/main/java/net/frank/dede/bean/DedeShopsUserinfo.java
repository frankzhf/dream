package net.frank.dede.bean;


public class DedeShopsUserinfo extends net.frank.framework.bo.BaseEntity{


	private Integer userid;

	private String oid;

	private String consignee;

	private String address;

	private Integer zip;

	private String tel;

	private String email;

	private String des;





	public Integer getUserid(){
		return this.userid;
	}

	public void setUserid(Integer userid){
		this.userid=userid;
	}

	public String getOid(){
		return this.oid;
	}

	public void setOid(String oid){
		this.oid=oid;
	}

	public String getConsignee(){
		return this.consignee;
	}

	public void setConsignee(String consignee){
		this.consignee=consignee;
	}

	public String getAddress(){
		return this.address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public Integer getZip(){
		return this.zip;
	}

	public void setZip(Integer zip){
		this.zip=zip;
	}

	public String getTel(){
		return this.tel;
	}

	public void setTel(String tel){
		this.tel=tel;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getDes(){
		return this.des;
	}

	public void setDes(String des){
		this.des=des;
	}





	public String toString(){
		return ""
		+this.getUserid()+"\t"
		+this.getOid()+"\t"
		+this.getConsignee()+"\t"
		+this.getAddress()+"\t"
		+this.getZip()+"\t"
		+this.getTel()+"\t"
		+this.getEmail()+"\t"
		+this.getDes()+"\t"
		;
	}


}
