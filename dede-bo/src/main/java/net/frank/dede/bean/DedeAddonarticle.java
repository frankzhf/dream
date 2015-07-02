package net.frank.dede.bean;


public class DedeAddonarticle extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private char[] body;

	private String redirecturl;

	private String templet;

	private String userip;





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

	public String getRedirecturl(){
		return this.redirecturl;
	}

	public void setRedirecturl(String redirecturl){
		this.redirecturl=redirecturl;
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





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+new String(this.getBody())+"\t"
		+this.getRedirecturl()+"\t"
		+this.getTemplet()+"\t"
		+this.getUserip()+"\t"
		;
	}


}
