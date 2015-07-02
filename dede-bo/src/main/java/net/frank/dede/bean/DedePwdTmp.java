package net.frank.dede.bean;


public class DedePwdTmp extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String membername;

	private String pwd;

	private Integer mailtime;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getMembername(){
		return this.membername;
	}

	public void setMembername(String membername){
		this.membername=membername;
	}

	public String getPwd(){
		return this.pwd;
	}

	public void setPwd(String pwd){
		this.pwd=pwd;
	}

	public Integer getMailtime(){
		return this.mailtime;
	}

	public void setMailtime(Integer mailtime){
		this.mailtime=mailtime;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getMembername()+"\t"
		+this.getPwd()+"\t"
		+this.getMailtime()+"\t"
		;
	}


}
