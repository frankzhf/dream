package net.frank.dede.bean;


public class DedeDiyforms extends net.frank.framework.bo.BaseEntity{


	private Integer diyid;

	private String name;

	private String posttemplate;

	private String viewtemplate;

	private String listtemplate;

	private String table;

	private char[] info;

	private Boolean _public;





	public Integer getDiyid(){
		return this.diyid;
	}

	public void setDiyid(Integer diyid){
		this.diyid=diyid;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getPosttemplate(){
		return this.posttemplate;
	}

	public void setPosttemplate(String posttemplate){
		this.posttemplate=posttemplate;
	}

	public String getViewtemplate(){
		return this.viewtemplate;
	}

	public void setViewtemplate(String viewtemplate){
		this.viewtemplate=viewtemplate;
	}

	public String getListtemplate(){
		return this.listtemplate;
	}

	public void setListtemplate(String listtemplate){
		this.listtemplate=listtemplate;
	}

	public String getTable(){
		return this.table;
	}

	public void setTable(String table){
		this.table=table;
	}

	public char[] getInfo(){
		return this.info;
	}

	public void setInfo(char[] info){
		this.info=info;
	}

	public Boolean getPublic(){
		return this._public;
	}

	public void setPublic(Boolean _public){
		this._public=_public;
	}





	public String toString(){
		return ""
		+this.getDiyid()+"\t"
		+this.getName()+"\t"
		+this.getPosttemplate()+"\t"
		+this.getViewtemplate()+"\t"
		+this.getListtemplate()+"\t"
		+this.getTable()+"\t"
		+new String(this.getInfo())+"\t"
		+this.getPublic()+"\t"
		;
	}


}
