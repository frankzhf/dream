package net.frank.dede.bean;


public class DedeLog extends net.frank.framework.bo.BaseEntity{


	private Integer lid;

	private Integer adminid;

	private String filename;

	private String method;

	private String query;

	private String cip;

	private Integer dtime;





	public Integer getLid(){
		return this.lid;
	}

	public void setLid(Integer lid){
		this.lid=lid;
	}

	public Integer getAdminid(){
		return this.adminid;
	}

	public void setAdminid(Integer adminid){
		this.adminid=adminid;
	}

	public String getFilename(){
		return this.filename;
	}

	public void setFilename(String filename){
		this.filename=filename;
	}

	public String getMethod(){
		return this.method;
	}

	public void setMethod(String method){
		this.method=method;
	}

	public String getQuery(){
		return this.query;
	}

	public void setQuery(String query){
		this.query=query;
	}

	public String getCip(){
		return this.cip;
	}

	public void setCip(String cip){
		this.cip=cip;
	}

	public Integer getDtime(){
		return this.dtime;
	}

	public void setDtime(Integer dtime){
		this.dtime=dtime;
	}





	public String toString(){
		return ""
		+this.getLid()+"\t"
		+this.getAdminid()+"\t"
		+this.getFilename()+"\t"
		+this.getMethod()+"\t"
		+this.getQuery()+"\t"
		+this.getCip()+"\t"
		+this.getDtime()+"\t"
		;
	}


}
