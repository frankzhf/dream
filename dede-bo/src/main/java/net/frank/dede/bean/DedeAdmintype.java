package net.frank.dede.bean;


public class DedeAdmintype extends net.frank.framework.bo.BaseEntity{


	private Float rank;

	private String typename;

	private Integer system;

	private char[] purviews;





	public Float getRank(){
		return this.rank;
	}

	public void setRank(Float rank){
		this.rank=rank;
	}

	public String getTypename(){
		return this.typename;
	}

	public void setTypename(String typename){
		this.typename=typename;
	}

	public Integer getSystem(){
		return this.system;
	}

	public void setSystem(Integer system){
		this.system=system;
	}

	public char[] getPurviews(){
		return this.purviews;
	}

	public void setPurviews(char[] purviews){
		this.purviews=purviews;
	}





	public String toString(){
		return ""
		+this.getRank()+"\t"
		+this.getTypename()+"\t"
		+this.getSystem()+"\t"
		+new String(this.getPurviews())+"\t"
		;
	}


}
