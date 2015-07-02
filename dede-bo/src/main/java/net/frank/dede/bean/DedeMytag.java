package net.frank.dede.bean;


public class DedeMytag extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private String tagname;

	private Integer timeset;

	private Integer starttime;

	private Integer endtime;

	private char[] normbody;

	private char[] expbody;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getTagname(){
		return this.tagname;
	}

	public void setTagname(String tagname){
		this.tagname=tagname;
	}

	public Integer getTimeset(){
		return this.timeset;
	}

	public void setTimeset(Integer timeset){
		this.timeset=timeset;
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

	public char[] getNormbody(){
		return this.normbody;
	}

	public void setNormbody(char[] normbody){
		this.normbody=normbody;
	}

	public char[] getExpbody(){
		return this.expbody;
	}

	public void setExpbody(char[] expbody){
		this.expbody=expbody;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+this.getTagname()+"\t"
		+this.getTimeset()+"\t"
		+this.getStarttime()+"\t"
		+this.getEndtime()+"\t"
		+new String(this.getNormbody())+"\t"
		+new String(this.getExpbody())+"\t"
		;
	}


}
