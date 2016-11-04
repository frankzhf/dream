package net.frank.dede.bean;


public class DedeArctiny extends net.frank.framework.bo.BaseEntity{


	private Integer typeid;

	private String typeid2;

	private Integer arcrank;

	private Integer channel;

	private Integer senddate;

	private Integer sortrank;

	private Integer mid;





	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getTypeid2(){
		return this.typeid2;
	}

	public void setTypeid2(String typeid2){
		this.typeid2=typeid2;
	}

	public Integer getArcrank(){
		return this.arcrank;
	}

	public void setArcrank(Integer arcrank){
		this.arcrank=arcrank;
	}

	public Integer getChannel(){
		return this.channel;
	}

	public void setChannel(Integer channel){
		this.channel=channel;
	}

	public Integer getSenddate(){
		return this.senddate;
	}

	public void setSenddate(Integer senddate){
		this.senddate=senddate;
	}

	public Integer getSortrank(){
		return this.sortrank;
	}

	public void setSortrank(Integer sortrank){
		this.sortrank=sortrank;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTypeid()+"\t"
		+this.getTypeid2()+"\t"
		+this.getArcrank()+"\t"
		+this.getChannel()+"\t"
		+this.getSenddate()+"\t"
		+this.getSortrank()+"\t"
		+this.getMid()+"\t"
		;
	}


}
