package net.frank.dede.bean;


public class DedeMemberVhistory extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String loginid;

	private Integer vid;

	private String vloginid;

	private Integer count;

	private String vip;

	private Integer vtime;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getLoginid(){
		return this.loginid;
	}

	public void setLoginid(String loginid){
		this.loginid=loginid;
	}

	public Integer getVid(){
		return this.vid;
	}

	public void setVid(Integer vid){
		this.vid=vid;
	}

	public String getVloginid(){
		return this.vloginid;
	}

	public void setVloginid(String vloginid){
		this.vloginid=vloginid;
	}

	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count){
		this.count=count;
	}

	public String getVip(){
		return this.vip;
	}

	public void setVip(String vip){
		this.vip=vip;
	}

	public Integer getVtime(){
		return this.vtime;
	}

	public void setVtime(Integer vtime){
		this.vtime=vtime;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getMid()+"\t"
		+this.getLoginid()+"\t"
		+this.getVid()+"\t"
		+this.getVloginid()+"\t"
		+this.getCount()+"\t"
		+this.getVip()+"\t"
		+this.getVtime()+"\t"
		;
	}


}
