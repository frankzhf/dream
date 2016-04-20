package net.frank.dede.bean;


public class DedeFeedback extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private String username;

	private String arctitle;

	private String ip;

	private Integer ischeck;

	private Integer dtime;

	private Integer mid;

	private Integer bad;

	private Integer good;

	private String ftype;

	private Integer face;

	private char[] msg;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getArctitle(){
		return this.arctitle;
	}

	public void setArctitle(String arctitle){
		this.arctitle=arctitle;
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

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getBad(){
		return this.bad;
	}

	public void setBad(Integer bad){
		this.bad=bad;
	}

	public Integer getGood(){
		return this.good;
	}

	public void setGood(Integer good){
		this.good=good;
	}

	public String getFtype(){
		return this.ftype;
	}

	public void setFtype(String ftype){
		this.ftype=ftype;
	}

	public Integer getFace(){
		return this.face;
	}

	public void setFace(Integer face){
		this.face=face;
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
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+this.getUsername()+"\t"
		+this.getArctitle()+"\t"
		+this.getIp()+"\t"
		+this.getIscheck()+"\t"
		+this.getDtime()+"\t"
		+this.getMid()+"\t"
		+this.getBad()+"\t"
		+this.getGood()+"\t"
		+this.getFtype()+"\t"
		+this.getFace()+"\t"
		+new String(this.getMsg())+"\t"
		;
	}


}
