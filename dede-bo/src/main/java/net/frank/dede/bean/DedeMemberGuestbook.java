package net.frank.dede.bean;


public class DedeMemberGuestbook extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer mid;

	private String gid;

	private String title;

	private String uname;

	private String email;

	private String qq;

	private String tel;

	private String ip;

	private Integer dtime;

	private char[] msg;





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

	public String getGid(){
		return this.gid;
	}

	public void setGid(String gid){
		this.gid=gid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getUname(){
		return this.uname;
	}

	public void setUname(String uname){
		this.uname=uname;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getQq(){
		return this.qq;
	}

	public void setQq(String qq){
		this.qq=qq;
	}

	public String getTel(){
		return this.tel;
	}

	public void setTel(String tel){
		this.tel=tel;
	}

	public String getIp(){
		return this.ip;
	}

	public void setIp(String ip){
		this.ip=ip;
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
		+this.getAid()+"\t"
		+this.getMid()+"\t"
		+this.getGid()+"\t"
		+this.getTitle()+"\t"
		+this.getUname()+"\t"
		+this.getEmail()+"\t"
		+this.getQq()+"\t"
		+this.getTel()+"\t"
		+this.getIp()+"\t"
		+this.getDtime()+"\t"
		+new String(this.getMsg())+"\t"
		;
	}


}
