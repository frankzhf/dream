package net.frank.dede.bean;


public class DedeCoMediaurls extends net.frank.framework.bo.BaseEntity{


	private Integer nid;

	private String hash;

	private String tofile;





	public Integer getNid(){
		return this.nid;
	}

	public void setNid(Integer nid){
		this.nid=nid;
	}

	public String getHash(){
		return this.hash;
	}

	public void setHash(String hash){
		this.hash=hash;
	}

	public String getTofile(){
		return this.tofile;
	}

	public void setTofile(String tofile){
		this.tofile=tofile;
	}





	public String toString(){
		return ""
		+this.getNid()+"\t"
		+this.getHash()+"\t"
		+this.getTofile()+"\t"
		;
	}


}
