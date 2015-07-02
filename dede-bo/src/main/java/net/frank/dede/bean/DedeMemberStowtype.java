package net.frank.dede.bean;


public class DedeMemberStowtype extends net.frank.framework.bo.BaseEntity{


	private String stowname;

	private String indexname;

	private String indexurl;





	public String getStowname(){
		return this.stowname;
	}

	public void setStowname(String stowname){
		this.stowname=stowname;
	}

	public String getIndexname(){
		return this.indexname;
	}

	public void setIndexname(String indexname){
		this.indexname=indexname;
	}

	public String getIndexurl(){
		return this.indexurl;
	}

	public void setIndexurl(String indexurl){
		this.indexurl=indexurl;
	}





	public String toString(){
		return ""
		+this.getStowname()+"\t"
		+this.getIndexname()+"\t"
		+this.getIndexurl()+"\t"
		;
	}


}
