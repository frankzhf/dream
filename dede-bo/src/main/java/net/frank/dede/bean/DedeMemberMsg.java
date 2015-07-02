package net.frank.dede.bean;


public class DedeMemberMsg extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String userid;

	private String ip;

	private Integer ischeck;

	private Integer dtime;

	private char[] msg;





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

	public String getIp(){
		return this.ip;
	}

	public void setIp(String ip){
		this.ip=ip;
	}

	public Integer getIscheck(){
		return this.ischeck;
	}

	public void setIscheck(Integer ischeck){
		this.ischeck=ischeck;
	}

	public Integer getDtime(){
		return this.dtime;
	}

	public void setDtime(Integer dtime){
		this.dtime=dtime;
	}

	public char[] getMsg(){
		return this.msg;
	}

	public void setMsg(char[] msg){
		this.msg=msg;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getMid()+"\t"
		+this.getUserid()+"\t"
		+this.getIp()+"\t"
		+this.getIscheck()+"\t"
		+this.getDtime()+"\t"
		+new String(this.getMsg())+"\t"
		;
	}


}
