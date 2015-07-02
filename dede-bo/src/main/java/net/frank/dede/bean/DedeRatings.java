package net.frank.dede.bean;


public class DedeRatings extends net.frank.framework.bo.BaseEntity{


	private Integer totalVotes;

	private Integer totalValue;

	private char[] usedIps;





	public Integer getTotalVotes(){
		return this.totalVotes;
	}

	public void setTotalVotes(Integer totalVotes){
		this.totalVotes=totalVotes;
	}

	public Integer getTotalValue(){
		return this.totalValue;
	}

	public void setTotalValue(Integer totalValue){
		this.totalValue=totalValue;
	}

	public char[] getUsedIps(){
		return this.usedIps;
	}

	public void setUsedIps(char[] usedIps){
		this.usedIps=usedIps;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTotalVotes()+"\t"
		+this.getTotalValue()+"\t"
		+new String(this.getUsedIps())+"\t"
		;
	}


}
