package net.frank.dede.bean;


public class DedeArcrank extends net.frank.framework.bo.BaseEntity{


	private Integer rank;

	private String membername;

	private Integer adminrank;

	private Integer money;

	private Integer scores;

	private char[] purviews;





	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank=rank;
	}

	public String getMembername(){
		return this.membername;
	}

	public void setMembername(String membername){
		this.membername=membername;
	}

	public Integer getAdminrank(){
		return this.adminrank;
	}

	public void setAdminrank(Integer adminrank){
		this.adminrank=adminrank;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public Integer getScores(){
		return this.scores;
	}

	public void setScores(Integer scores){
		this.scores=scores;
	}

	public char[] getPurviews(){
		return this.purviews;
	}

	public void setPurviews(char[] purviews){
		this.purviews=purviews;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getRank()+"\t"
		+this.getMembername()+"\t"
		+this.getAdminrank()+"\t"
		+this.getMoney()+"\t"
		+this.getScores()+"\t"
		+new String(this.getPurviews())+"\t"
		;
	}


}
