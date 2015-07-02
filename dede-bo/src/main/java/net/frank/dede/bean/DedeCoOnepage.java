package net.frank.dede.bean;


public class DedeCoOnepage extends net.frank.framework.bo.BaseEntity{


	private String url;

	private String title;

	private Integer issource;

	private String lang;

	private char[] rule;





	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public Integer getIssource(){
		return this.issource;
	}

	public void setIssource(Integer issource){
		this.issource=issource;
	}

	public String getLang(){
		return this.lang;
	}

	public void setLang(String lang){
		this.lang=lang;
	}

	public char[] getRule(){
		return this.rule;
	}

	public void setRule(char[] rule){
		this.rule=rule;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getUrl()+"\t"
		+this.getTitle()+"\t"
		+this.getIssource()+"\t"
		+this.getLang()+"\t"
		+new String(this.getRule())+"\t"
		;
	}


}
