package net.frank.dede.bean;


public class DedeCoUrls extends net.frank.framework.bo.BaseEntity{


	private String hash;

	private Integer nid;





	public String getHash(){
		return this.hash;
	}

	public void setHash(String hash){
		this.hash=hash;
	}

	public Integer getNid(){
		return this.nid;
	}

	public void setNid(Integer nid){
		this.nid=nid;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getHash()+"\t"
		+this.getNid()+"\t"
		;
	}


}
