package net.frank.dede.bean;


public class DedeMemberFriends extends net.frank.framework.bo.BaseEntity{


	private Integer fid;

	private String floginid;

	private String funame;

	private Integer mid;

	private Integer addtime;

	private Byte ftype;

	private Integer groupid;

	private String description;





	public Integer getFid(){
		return this.fid;
	}

	public void setFid(Integer fid){
		this.fid=fid;
	}

	public String getFloginid(){
		return this.floginid;
	}

	public void setFloginid(String floginid){
		this.floginid=floginid;
	}

	public String getFuname(){
		return this.funame;
	}

	public void setFuname(String funame){
		this.funame=funame;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getAddtime(){
		return this.addtime;
	}

	public void setAddtime(Integer addtime){
		this.addtime=addtime;
	}

	public Byte getFtype(){
		return this.ftype;
	}

	public void setFtype(Byte ftype){
		this.ftype=ftype;
	}

	public Integer getGroupid(){
		return this.groupid;
	}

	public void setGroupid(Integer groupid){
		this.groupid=groupid;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getFid()+"\t"
		+this.getFloginid()+"\t"
		+this.getFuname()+"\t"
		+this.getMid()+"\t"
		+this.getAddtime()+"\t"
		+this.getFtype()+"\t"
		+this.getGroupid()+"\t"
		+this.getDescription()+"\t"
		;
	}


}
