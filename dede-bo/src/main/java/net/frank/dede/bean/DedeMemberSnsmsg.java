package net.frank.dede.bean;


public class DedeMemberSnsmsg extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String userid;

	private Integer sendtime;

	private String msg;





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

	public Integer getSendtime(){
		return this.sendtime;
	}

	public void setSendtime(Integer sendtime){
		this.sendtime=sendtime;
	}

	public String getMsg(){
		return this.msg;
	}

	public void setMsg(String msg){
		this.msg=msg;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getMid()+"\t"
		+this.getUserid()+"\t"
		+this.getSendtime()+"\t"
		+this.getMsg()+"\t"
		;
	}


}
