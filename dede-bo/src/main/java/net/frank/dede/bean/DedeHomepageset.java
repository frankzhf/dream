package net.frank.dede.bean;


public class DedeHomepageset extends net.frank.framework.bo.BaseEntity{


	private String templet;

	private String position;

	private Byte showmod;





	public String getTemplet(){
		return this.templet;
	}

	public void setTemplet(String templet){
		this.templet=templet;
	}

	public String getPosition(){
		return this.position;
	}

	public void setPosition(String position){
		this.position=position;
	}

	public Byte getShowmod(){
		return this.showmod;
	}

	public void setShowmod(Byte showmod){
		this.showmod=showmod;
	}





	public String toString(){
		return ""
		+this.getTemplet()+"\t"
		+this.getPosition()+"\t"
		+this.getShowmod()+"\t"
		;
	}


}
