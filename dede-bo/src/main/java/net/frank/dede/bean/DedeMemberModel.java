package net.frank.dede.bean;


public class DedeMemberModel extends net.frank.framework.bo.BaseEntity{


	private String name;

	private String table;

	private String description;

	private Integer state;

	private Integer issystem;

	private char[] info;





	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getTable(){
		return this.table;
	}

	public void setTable(String table){
		this.table=table;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public Integer getState(){
		return this.state;
	}

	public void setState(Integer state){
		this.state=state;
	}

	public Integer getIssystem(){
		return this.issystem;
	}

	public void setIssystem(Integer issystem){
		this.issystem=issystem;
	}

	public char[] getInfo(){
		return this.info;
	}

	public void setInfo(char[] info){
		this.info=info;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getName()+"\t"
		+this.getTable()+"\t"
		+this.getDescription()+"\t"
		+this.getState()+"\t"
		+this.getIssystem()+"\t"
		+new String(this.getInfo())+"\t"
		;
	}


}
