package net.frank.dede.bean;


public class DedeFreelist extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String title;

	private String namerule;

	private String listdir;

	private String defaultpage;

	private Integer nodefault;

	private String templet;

	private Integer edtime;

	private Integer maxpage;

	private Integer click;

	private char[] listtag;

	private String keywords;

	private String description;





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

	public String getNamerule(){
		return this.namerule;
	}

	public void setNamerule(String namerule){
		this.namerule=namerule;
	}

	public String getListdir(){
		return this.listdir;
	}

	public void setListdir(String listdir){
		this.listdir=listdir;
	}

	public String getDefaultpage(){
		return this.defaultpage;
	}

	public void setDefaultpage(String defaultpage){
		this.defaultpage=defaultpage;
	}

	public Integer getNodefault(){
		return this.nodefault;
	}

	public void setNodefault(Integer nodefault){
		this.nodefault=nodefault;
	}

	public String getTemplet(){
		return this.templet;
	}

	public void setTemplet(String templet){
		this.templet=templet;
	}

	public Integer getEdtime(){
		return this.edtime;
	}

	public void setEdtime(Integer edtime){
		this.edtime=edtime;
	}

	public Integer getMaxpage(){
		return this.maxpage;
	}

	public void setMaxpage(Integer maxpage){
		this.maxpage=maxpage;
	}

	public Integer getClick(){
		return this.click;
	}

	public void setClick(Integer click){
		this.click=click;
	}

	public char[] getListtag(){
		return this.listtag;
	}

	public void setListtag(char[] listtag){
		this.listtag=listtag;
	}

	public String getKeywords(){
		return this.keywords;
	}

	public void setKeywords(String keywords){
		this.keywords=keywords;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTitle()+"\t"
		+this.getNamerule()+"\t"
		+this.getListdir()+"\t"
		+this.getDefaultpage()+"\t"
		+this.getNodefault()+"\t"
		+this.getTemplet()+"\t"
		+this.getEdtime()+"\t"
		+this.getMaxpage()+"\t"
		+this.getClick()+"\t"
		+new String(this.getListtag())+"\t"
		+this.getKeywords()+"\t"
		+this.getDescription()+"\t"
		;
	}


}
