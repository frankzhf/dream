package net.frank.dede.bean;


public class DedeSysconfig extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String varname;

	private String info;

	private Integer groupid;

	private String type;

	private char[] value;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getVarname(){
		return this.varname;
	}

	public void setVarname(String varname){
		this.varname=varname;
	}

	public String getInfo(){
		return this.info;
	}

	public void setInfo(String info){
		this.info=info;
	}

	public Integer getGroupid(){
		return this.groupid;
	}

	public void setGroupid(Integer groupid){
		this.groupid=groupid;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type=type;
	}

	public char[] getValue(){
		return this.value;
	}

	public void setValue(char[] value){
		this.value=value;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getVarname()+"\t"
		+this.getInfo()+"\t"
		+this.getGroupid()+"\t"
		+this.getType()+"\t"
		+new String(this.getValue())+"\t"
		;
	}


}
