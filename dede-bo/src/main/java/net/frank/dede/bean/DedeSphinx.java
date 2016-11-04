package net.frank.dede.bean;


public class DedeSphinx extends net.frank.framework.bo.BaseEntity{


	private Integer countid;

	private Integer maxaid;





	public Integer getCountid(){
		return this.countid;
	}

	public void setCountid(Integer countid){
		this.countid=countid;
	}

	public Integer getMaxaid(){
		return this.maxaid;
	}

	public void setMaxaid(Integer maxaid){
		this.maxaid=maxaid;
	}





	public String toString(){
		return ""
		+this.getCountid()+"\t"
		+this.getMaxaid()+"\t"
		;
	}


}
