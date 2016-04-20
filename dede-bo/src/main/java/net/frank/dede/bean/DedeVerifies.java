package net.frank.dede.bean;


public class DedeVerifies extends net.frank.framework.bo.BaseEntity{


	private String nameid;

	private String cthash;

	private String method;

	private String filename;





	public String getNameid(){
		return this.nameid;
	}

	public void setNameid(String nameid){
		this.nameid=nameid;
	}

	public String getCthash(){
		return this.cthash;
	}

	public void setCthash(String cthash){
		this.cthash=cthash;
	}

	public String getMethod(){
		return this.method;
	}

	public void setMethod(String method){
		this.method=method;
	}

	public String getFilename(){
		return this.filename;
	}

	public void setFilename(String filename){
		this.filename=filename;
	}





	public String toString(){
		return ""
		+this.getNameid()+"\t"
		+this.getCthash()+"\t"
		+this.getMethod()+"\t"
		+this.getFilename()+"\t"
		;
	}


}
