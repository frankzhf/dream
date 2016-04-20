package net.frank.dede.bean;


public class DedeMemberGroup extends net.frank.framework.bo.BaseEntity{


	private String groupname;

	private Integer mid;





	public String getGroupname(){
		return this.groupname;
	}

	public void setGroupname(String groupname){
		this.groupname=groupname;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getGroupname()+"\t"
		+this.getMid()+"\t"
		;
	}


}
