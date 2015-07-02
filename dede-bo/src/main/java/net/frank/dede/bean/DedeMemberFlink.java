package net.frank.dede.bean;


public class DedeMemberFlink extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer mid;

	private String title;

	private String url;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getMid()+"\t"
		+this.getTitle()+"\t"
		+this.getUrl()+"\t"
		;
	}


}
