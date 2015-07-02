package net.frank.dede.bean;


public class DedeMemberFeed extends net.frank.framework.bo.BaseEntity{


	private Integer fid;

	private Integer mid;

	private String userid;

	private String uname;

	private String type;

	private Integer aid;

	private Integer dtime;

	private String title;

	private String note;

	private Integer ischeck;





	public Integer getFid(){
		return this.fid;
	}

	public void setFid(Integer fid){
		this.fid=fid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getUserid(){
		return this.userid;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}

	public String getUname(){
		return this.uname;
	}

	public void setUname(String uname){
		this.uname=uname;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type=type;
	}

	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getDtime(){
		return this.dtime;
	}

	public void setDtime(Integer dtime){
		this.dtime=dtime;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getNote(){
		return this.note;
	}

	public void setNote(String note){
		this.note=note;
	}

	public Integer getIscheck(){
		return this.ischeck;
	}

	public void setIscheck(Integer ischeck){
		this.ischeck=ischeck;
	}





	public String toString(){
		return ""
		+this.getFid()+"\t"
		+this.getMid()+"\t"
		+this.getUserid()+"\t"
		+this.getUname()+"\t"
		+this.getType()+"\t"
		+this.getAid()+"\t"
		+this.getDtime()+"\t"
		+this.getTitle()+"\t"
		+this.getNote()+"\t"
		+this.getIscheck()+"\t"
		;
	}


}
