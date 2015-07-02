package net.frank.dede.bean;


public class DedeScores extends net.frank.framework.bo.BaseEntity{


	private String titles;

	private Integer icon;

	private Integer integral;

	private Boolean isdefault;





	public String getTitles(){
		return this.titles;
	}

	public void setTitles(String titles){
		this.titles=titles;
	}

	public Integer getIcon(){
		return this.icon;
	}

	public void setIcon(Integer icon){
		this.icon=icon;
	}

	public Integer getIntegral(){
		return this.integral;
	}

	public void setIntegral(Integer integral){
		this.integral=integral;
	}

	public Boolean getIsdefault(){
		return this.isdefault;
	}

	public void setIsdefault(Boolean isdefault){
		this.isdefault=isdefault;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTitles()+"\t"
		+this.getIcon()+"\t"
		+this.getIntegral()+"\t"
		+this.getIsdefault()+"\t"
		;
	}


}
