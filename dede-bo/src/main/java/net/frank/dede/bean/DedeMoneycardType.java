package net.frank.dede.bean;


public class DedeMoneycardType extends net.frank.framework.bo.BaseEntity{


	private Integer tid;

	private Integer num;

	private Integer money;

	private String pname;





	public Integer getTid(){
		return this.tid;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}

	public Integer getNum(){
		return this.num;
	}

	public void setNum(Integer num){
		this.num=num;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public String getPname(){
		return this.pname;
	}

	public void setPname(String pname){
		this.pname=pname;
	}





	public String toString(){
		return ""
		+this.getTid()+"\t"
		+this.getNum()+"\t"
		+this.getMoney()+"\t"
		+this.getPname()+"\t"
		;
	}


}
