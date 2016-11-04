package net.frank.dede.bean;


public class DedeArea extends net.frank.framework.bo.BaseEntity{


	private String name;

	private Integer reid;

	private Integer disorder;





	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public Integer getReid(){
		return this.reid;
	}

	public void setReid(Integer reid){
		this.reid=reid;
	}

	public Integer getDisorder(){
		return this.disorder;
	}

	public void setDisorder(Integer disorder){
		this.disorder=disorder;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getName()+"\t"
		+this.getReid()+"\t"
		+this.getDisorder()+"\t"
		;
	}


}
