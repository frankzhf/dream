package net.frank.dede.bean;


public class DedeStepselect extends net.frank.framework.bo.BaseEntity{


	private String itemname;

	private String egroup;

	private Boolean issign;

	private Boolean issystem;





	public String getItemname(){
		return this.itemname;
	}

	public void setItemname(String itemname){
		this.itemname=itemname;
	}

	public String getEgroup(){
		return this.egroup;
	}

	public void setEgroup(String egroup){
		this.egroup=egroup;
	}

	public Boolean getIssign(){
		return this.issign;
	}

	public void setIssign(Boolean issign){
		this.issign=issign;
	}

	public Boolean getIssystem(){
		return this.issystem;
	}

	public void setIssystem(Boolean issystem){
		this.issystem=issystem;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getItemname()+"\t"
		+this.getEgroup()+"\t"
		+this.getIssign()+"\t"
		+this.getIssystem()+"\t"
		;
	}


}
