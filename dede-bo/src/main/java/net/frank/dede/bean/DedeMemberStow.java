package net.frank.dede.bean;


public class DedeMemberStow extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private Integer aid;

	private String title;

	private Integer addtime;

	private String type;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public Integer getAddtime(){
		return this.addtime;
	}

	public void setAddtime(Integer addtime){
		this.addtime=addtime;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type=type;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getMid()+"\t"
		+this.getAid()+"\t"
		+this.getTitle()+"\t"
		+this.getAddtime()+"\t"
		+this.getType()+"\t"
		;
	}


}
