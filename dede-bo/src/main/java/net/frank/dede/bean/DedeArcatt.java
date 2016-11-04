package net.frank.dede.bean;


public class DedeArcatt extends net.frank.framework.bo.BaseEntity{


	private Integer sortid;

	private String att;

	private String attname;





	public Integer getSortid(){
		return this.sortid;
	}

	public void setSortid(Integer sortid){
		this.sortid=sortid;
	}

	public String getAtt(){
		return this.att;
	}

	public void setAtt(String att){
		this.att=att;
	}

	public String getAttname(){
		return this.attname;
	}

	public void setAttname(String attname){
		this.attname=attname;
	}





	public String toString(){
		return ""
		+this.getSortid()+"\t"
		+this.getAtt()+"\t"
		+this.getAttname()+"\t"
		;
	}


}
