package net.frank.dede.bean;


public class DedeDownloads extends net.frank.framework.bo.BaseEntity{


	private String hash;

	private Integer downloads;





	public String getHash(){
		return this.hash;
	}

	public void setHash(String hash){
		this.hash=hash;
	}

	public Integer getDownloads(){
		return this.downloads;
	}

	public void setDownloads(Integer downloads){
		this.downloads=downloads;
	}





	public String toString(){
		return ""
		+this.getHash()+"\t"
		+this.getId()+"\t"
		+this.getDownloads()+"\t"
		;
	}


}
