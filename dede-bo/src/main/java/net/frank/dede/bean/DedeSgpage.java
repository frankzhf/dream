package net.frank.dede.bean;


public class DedeSgpage extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String title;

	private Integer ismake;

	private String filename;

	private String keywords;

	private String template;

	private String likeid;

	private String description;

	private Integer uptime;

	private char[] body;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public Integer getIsmake(){
		return this.ismake;
	}

	public void setIsmake(Integer ismake){
		this.ismake=ismake;
	}

	public String getFilename(){
		return this.filename;
	}

	public void setFilename(String filename){
		this.filename=filename;
	}

	public String getKeywords(){
		return this.keywords;
	}

	public void setKeywords(String keywords){
		this.keywords=keywords;
	}

	public String getTemplate(){
		return this.template;
	}

	public void setTemplate(String template){
		this.template=template;
	}

	public String getLikeid(){
		return this.likeid;
	}

	public void setLikeid(String likeid){
		this.likeid=likeid;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public char[] getBody(){
		return this.body;
	}

	public void setBody(char[] body){
		this.body=body;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTitle()+"\t"
		+this.getIsmake()+"\t"
		+this.getFilename()+"\t"
		+this.getKeywords()+"\t"
		+this.getTemplate()+"\t"
		+this.getLikeid()+"\t"
		+this.getDescription()+"\t"
		+this.getUptime()+"\t"
		+new String(this.getBody())+"\t"
		;
	}


}
