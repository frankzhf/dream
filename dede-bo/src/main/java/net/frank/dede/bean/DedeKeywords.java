package net.frank.dede.bean;


public class DedeKeywords extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String keyword;

	private Integer rank;

	private Integer sta;

	private String rpurl;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getKeyword(){
		return this.keyword;
	}

	public void setKeyword(String keyword){
		this.keyword=keyword;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank=rank;
	}

	public Integer getSta(){
		return this.sta;
	}

	public void setSta(Integer sta){
		this.sta=sta;
	}

	public String getRpurl(){
		return this.rpurl;
	}

	public void setRpurl(String rpurl){
		this.rpurl=rpurl;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getKeyword()+"\t"
		+this.getRank()+"\t"
		+this.getSta()+"\t"
		+this.getRpurl()+"\t"
		;
	}


}
