package net.frank.dede.bean;


public class DedeCoHtmls extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer nid;

	private Integer typeid;

	private String title;

	private String litpic;

	private String url;

	private Integer dtime;

	private Boolean isdown;

	private Boolean isexport;

	private char[] result;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getNid(){
		return this.nid;
	}

	public void setNid(Integer nid){
		this.nid=nid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getLitpic(){
		return this.litpic;
	}

	public void setLitpic(String litpic){
		this.litpic=litpic;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public Integer getDtime(){
		return this.dtime;
	}

	public void setDtime(Integer dtime){
		this.dtime=dtime;
	}

	public Boolean getIsdown(){
		return this.isdown;
	}

	public void setIsdown(Boolean isdown){
		this.isdown=isdown;
	}

	public Boolean getIsexport(){
		return this.isexport;
	}

	public void setIsexport(Boolean isexport){
		this.isexport=isexport;
	}

	public char[] getResult(){
		return this.result;
	}

	public void setResult(char[] result){
		this.result=result;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getNid()+"\t"
		+this.getTypeid()+"\t"
		+this.getTitle()+"\t"
		+this.getLitpic()+"\t"
		+this.getUrl()+"\t"
		+this.getDtime()+"\t"
		+this.getIsdown()+"\t"
		+this.getIsexport()+"\t"
		+new String(this.getResult())+"\t"
		;
	}


}
