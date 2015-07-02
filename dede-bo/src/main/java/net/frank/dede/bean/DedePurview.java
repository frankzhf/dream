package net.frank.dede.bean;


public class DedePurview extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private Integer typeid;

	private Integer rank;

	private String pkey;

	private char[] pvalue;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank=rank;
	}

	public String getPkey(){
		return this.pkey;
	}

	public void setPkey(String pkey){
		this.pkey=pkey;
	}

	public char[] getPvalue(){
		return this.pvalue;
	}

	public void setPvalue(char[] pvalue){
		this.pvalue=pvalue;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getTypeid()+"\t"
		+this.getRank()+"\t"
		+this.getPkey()+"\t"
		+new String(this.getPvalue())+"\t"
		;
	}


}
