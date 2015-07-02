package net.frank.dede.bean;


public class DedeAddonspec extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private char[] note;

	private String templet;

	private String userip;

	private String redirecturl;





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

	public char[] getNote(){
		return this.note;
	}

	public void setNote(char[] note){
		this.note=note;
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





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+new String(this.getNote())+"\t"
		+this.getTemplet()+"\t"
		+this.getUserip()+"\t"
		+this.getRedirecturl()+"\t"
		;
	}


}
