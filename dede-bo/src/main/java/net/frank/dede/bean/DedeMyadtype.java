package net.frank.dede.bean;


public class DedeMyadtype extends net.frank.framework.bo.BaseEntity{


	private String typename;





	public String getTypename(){
		return this.typename;
	}

	public void setTypename(String typename){
		this.typename=typename;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTypename()+"\t"
		;
	}


}
