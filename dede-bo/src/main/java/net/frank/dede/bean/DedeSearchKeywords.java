package net.frank.dede.bean;


public class DedeSearchKeywords extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String keyword;

	private String spwords;

	private Integer count;

	private Integer result;

	private Integer lasttime;

	private Integer channelid;

	private Integer typeid;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getKeyword(){
		return this.keyword;
	}

	public void setKeyword(String keyword){
		this.keyword=keyword;
	}

	public String getSpwords(){
		return this.spwords;
	}

	public void setSpwords(String spwords){
		this.spwords=spwords;
	}

	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count){
		this.count=count;
	}

	public Integer getResult(){
		return this.result;
	}

	public void setResult(Integer result){
		this.result=result;
	}

	public Integer getLasttime(){
		return this.lasttime;
	}

	public void setLasttime(Integer lasttime){
		this.lasttime=lasttime;
	}

	public Integer getChannelid(){
		return this.channelid;
	}

	public void setChannelid(Integer channelid){
		this.channelid=channelid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getKeyword()+"\t"
		+this.getSpwords()+"\t"
		+this.getCount()+"\t"
		+this.getResult()+"\t"
		+this.getLasttime()+"\t"
		+this.getChannelid()+"\t"
		+this.getTypeid()+"\t"
		;
	}


}
