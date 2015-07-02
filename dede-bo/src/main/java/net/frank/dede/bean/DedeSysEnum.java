package net.frank.dede.bean;


public class DedeSysEnum extends net.frank.framework.bo.BaseEntity{


	private String ename;

	private String evalue;

	private String egroup;

	private Integer disorder;

	private Boolean issign;





	public String getEname(){
		return this.ename;
	}

	public void setEname(String ename){
		this.ename=ename;
	}

	public String getEvalue(){
		return this.evalue;
	}

	public void setEvalue(String evalue){
		this.evalue=evalue;
	}

	public String getEgroup(){
		return this.egroup;
	}

	public void setEgroup(String egroup){
		this.egroup=egroup;
	}

	public Integer getDisorder(){
		return this.disorder;
	}

	public void setDisorder(Integer disorder){
		this.disorder=disorder;
	}

	public Boolean getIssign(){
		return this.issign;
	}

	public void setIssign(Boolean issign){
		this.issign=issign;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getEname()+"\t"
		+this.getEvalue()+"\t"
		+this.getEgroup()+"\t"
		+this.getDisorder()+"\t"
		+this.getIssign()+"\t"
		;
	}


}
