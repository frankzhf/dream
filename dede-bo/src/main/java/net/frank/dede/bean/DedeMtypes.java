package net.frank.dede.bean;


public class DedeMtypes extends net.frank.framework.bo.BaseEntity{


	private Integer mtypeid;

	private String mtypename;

	private Integer channelid;

	private Integer mid;





	public Integer getMtypeid(){
		return this.mtypeid;
	}

	public void setMtypeid(Integer mtypeid){
		this.mtypeid=mtypeid;
	}

	public String getMtypename(){
		return this.mtypename;
	}

	public void setMtypename(String mtypename){
		this.mtypename=mtypename;
	}

	public Integer getChannelid(){
		return this.channelid;
	}

	public void setChannelid(Integer channelid){
		this.channelid=channelid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}





	public String toString(){
		return ""
		+this.getMtypeid()+"\t"
		+this.getMtypename()+"\t"
		+this.getChannelid()+"\t"
		+this.getMid()+"\t"
		;
	}


}
