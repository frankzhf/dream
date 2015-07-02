package net.frank.dede.bean;


public class DedeMoneycardRecord extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer ctid;

	private String cardid;

	private Integer uid;

	private Integer isexp;

	private Integer mtime;

	private Integer utime;

	private Integer money;

	private Integer num;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getCtid(){
		return this.ctid;
	}

	public void setCtid(Integer ctid){
		this.ctid=ctid;
	}

	public String getCardid(){
		return this.cardid;
	}

	public void setCardid(String cardid){
		this.cardid=cardid;
	}

	public Integer getUid(){
		return this.uid;
	}

	public void setUid(Integer uid){
		this.uid=uid;
	}

	public Integer getIsexp(){
		return this.isexp;
	}

	public void setIsexp(Integer isexp){
		this.isexp=isexp;
	}

	public Integer getMtime(){
		return this.mtime;
	}

	public void setMtime(Integer mtime){
		this.mtime=mtime;
	}

	public Integer getUtime(){
		return this.utime;
	}

	public void setUtime(Integer utime){
		this.utime=utime;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public Integer getNum(){
		return this.num;
	}

	public void setNum(Integer num){
		this.num=num;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getCtid()+"\t"
		+this.getCardid()+"\t"
		+this.getUid()+"\t"
		+this.getIsexp()+"\t"
		+this.getMtime()+"\t"
		+this.getUtime()+"\t"
		+this.getMoney()+"\t"
		+this.getNum()+"\t"
		;
	}


}
