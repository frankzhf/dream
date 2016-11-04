package net.frank.dede.bean;


public class DedeFlink extends net.frank.framework.bo.BaseEntity{


	private Integer sortrank;

	private String url;

	private String webname;

	private String msg;

	private String email;

	private String logo;

	private Integer dtime;

	private Integer typeid;

	private Integer ischeck;





	public Integer getSortrank(){
		return this.sortrank;
	}

	public void setSortrank(Integer sortrank){
		this.sortrank=sortrank;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public String getWebname(){
		return this.webname;
	}

	public void setWebname(String webname){
		this.webname=webname;
	}

	public String getMsg(){
		return this.msg;
	}

	public void setMsg(String msg){
		this.msg=msg;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getLogo(){
		return this.logo;
	}

	public void setLogo(String logo){
		this.logo=logo;
	}

	public Integer getDtime(){
		return this.dtime;
	}

	public void setDtime(Integer dtime){
		this.dtime=dtime;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public Integer getIscheck(){
		return this.ischeck;
	}

	public void setIscheck(Integer ischeck){
		this.ischeck=ischeck;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getSortrank()+"\t"
		+this.getUrl()+"\t"
		+this.getWebname()+"\t"
		+this.getMsg()+"\t"
		+this.getEmail()+"\t"
		+this.getLogo()+"\t"
		+this.getDtime()+"\t"
		+this.getTypeid()+"\t"
		+this.getIscheck()+"\t"
		;
	}


}
