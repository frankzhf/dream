package net.frank.dede.bean;


public class DedeErradd extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer mid;

	private String title;

	private Integer type;

	private char[] errtxt;

	private char[] oktxt;

	private Integer sendtime;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public Integer getType(){
		return this.type;
	}

	public void setType(Integer type){
		this.type=type;
	}

	public char[] getErrtxt(){
		return this.errtxt;
	}

	public void setErrtxt(char[] errtxt){
		this.errtxt=errtxt;
	}

	public char[] getOktxt(){
		return this.oktxt;
	}

	public void setOktxt(char[] oktxt){
		this.oktxt=oktxt;
	}

	public Integer getSendtime(){
		return this.sendtime;
	}

	public void setSendtime(Integer sendtime){
		this.sendtime=sendtime;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getAid()+"\t"
		+this.getMid()+"\t"
		+this.getTitle()+"\t"
		+this.getType()+"\t"
		+new String(this.getErrtxt())+"\t"
		+new String(this.getOktxt())+"\t"
		+this.getSendtime()+"\t"
		;
	}


}
