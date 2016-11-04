package net.frank.dede.bean;


public class DedeMemberType extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer rank;

	private String pname;

	private Integer money;

	private Integer exptime;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank=rank;
	}

	public String getPname(){
		return this.pname;
	}

	public void setPname(String pname){
		this.pname=pname;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public Integer getExptime(){
		return this.exptime;
	}

	public void setExptime(Integer exptime){
		this.exptime=exptime;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getRank()+"\t"
		+this.getPname()+"\t"
		+this.getMoney()+"\t"
		+this.getExptime()+"\t"
		;
	}


}
