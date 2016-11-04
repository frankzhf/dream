package net.frank.dede.bean;


public class DedeTaglist extends net.frank.framework.bo.BaseEntity{


	private Integer tid;

	private Integer aid;

	private Integer arcrank;

	private Integer typeid;

	private String tag;





	public Integer getTid(){
		return this.tid;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}

	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getArcrank(){
		return this.arcrank;
	}

	public void setArcrank(Integer arcrank){
		this.arcrank=arcrank;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getTag(){
		return this.tag;
	}

	public void setTag(String tag){
		this.tag=tag;
	}





	public String toString(){
		return ""
		+this.getTid()+"\t"
		+this.getAid()+"\t"
		+this.getArcrank()+"\t"
		+this.getTypeid()+"\t"
		+this.getTag()+"\t"
		;
	}


}
