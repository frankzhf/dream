package net.frank.dede.bean;


public class DedeVote extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String votename;

	private Integer starttime;

	private Integer endtime;

	private Integer totalcount;

	private Byte ismore;

	private Byte isallow;

	private Byte view;

	private Integer spec;

	private Byte isenable;

	private char[] votenote;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getVotename(){
		return this.votename;
	}

	public void setVotename(String votename){
		this.votename=votename;
	}

	public Integer getStarttime(){
		return this.starttime;
	}

	public void setStarttime(Integer starttime){
		this.starttime=starttime;
	}

	public Integer getEndtime(){
		return this.endtime;
	}

	public void setEndtime(Integer endtime){
		this.endtime=endtime;
	}

	public Integer getTotalcount(){
		return this.totalcount;
	}

	public void setTotalcount(Integer totalcount){
		this.totalcount=totalcount;
	}

	public Byte getIsmore(){
		return this.ismore;
	}

	public void setIsmore(Byte ismore){
		this.ismore=ismore;
	}

	public Byte getIsallow(){
		return this.isallow;
	}

	public void setIsallow(Byte isallow){
		this.isallow=isallow;
	}

	public Byte getView(){
		return this.view;
	}

	public void setView(Byte view){
		this.view=view;
	}

	public Integer getSpec(){
		return this.spec;
	}

	public void setSpec(Integer spec){
		this.spec=spec;
	}

	public Byte getIsenable(){
		return this.isenable;
	}

	public void setIsenable(Byte isenable){
		this.isenable=isenable;
	}

	public char[] getVotenote(){
		return this.votenote;
	}

	public void setVotenote(char[] votenote){
		this.votenote=votenote;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getVotename()+"\t"
		+this.getStarttime()+"\t"
		+this.getEndtime()+"\t"
		+this.getTotalcount()+"\t"
		+this.getIsmore()+"\t"
		+this.getIsallow()+"\t"
		+this.getView()+"\t"
		+this.getSpec()+"\t"
		+this.getIsenable()+"\t"
		+new String(this.getVotenote())+"\t"
		;
	}


}
