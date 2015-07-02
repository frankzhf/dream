package net.frank.dede.bean;


public class DedeAdmin extends net.frank.framework.bo.BaseEntity{


	private Float usertype;

	private String userid;

	private String pwd;

	private String uname;

	private String tname;

	private String email;

	private char[] typeid;

	private Integer logintime;

	private String loginip;





	public Float getUsertype(){
		return this.usertype;
	}

	public void setUsertype(Float usertype){
		this.usertype=usertype;
	}

	public String getUserid(){
		return this.userid;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}

	public String getPwd(){
		return this.pwd;
	}

	public void setPwd(String pwd){
		this.pwd=pwd;
	}

	public String getUname(){
		return this.uname;
	}

	public void setUname(String uname){
		this.uname=uname;
	}

	public String getTname(){
		return this.tname;
	}

	public void setTname(String tname){
		this.tname=tname;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public char[] getTypeid(){
		return this.typeid;
	}

	public void setTypeid(char[] typeid){
		this.typeid=typeid;
	}

	public Integer getLogintime(){
		return this.logintime;
	}

	public void setLogintime(Integer logintime){
		this.logintime=logintime;
	}

	public String getLoginip(){
		return this.loginip;
	}

	public void setLoginip(String loginip){
		this.loginip=loginip;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getUsertype()+"\t"
		+this.getUserid()+"\t"
		+this.getPwd()+"\t"
		+this.getUname()+"\t"
		+this.getTname()+"\t"
		+this.getEmail()+"\t"
		+new String(this.getTypeid())+"\t"
		+this.getLogintime()+"\t"
		+this.getLoginip()+"\t"
		;
	}


}
