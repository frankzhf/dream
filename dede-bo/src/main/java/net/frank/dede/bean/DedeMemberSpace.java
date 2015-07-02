package net.frank.dede.bean;


public class DedeMemberSpace extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private Integer pagesize;

	private Integer matt;

	private String spacename;

	private String spacelogo;

	private String spacestyle;

	private String sign;

	private char[] spacenews;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getPagesize(){
		return this.pagesize;
	}

	public void setPagesize(Integer pagesize){
		this.pagesize=pagesize;
	}

	public Integer getMatt(){
		return this.matt;
	}

	public void setMatt(Integer matt){
		this.matt=matt;
	}

	public String getSpacename(){
		return this.spacename;
	}

	public void setSpacename(String spacename){
		this.spacename=spacename;
	}

	public String getSpacelogo(){
		return this.spacelogo;
	}

	public void setSpacelogo(String spacelogo){
		this.spacelogo=spacelogo;
	}

	public String getSpacestyle(){
		return this.spacestyle;
	}

	public void setSpacestyle(String spacestyle){
		this.spacestyle=spacestyle;
	}

	public String getSign(){
		return this.sign;
	}

	public void setSign(String sign){
		this.sign=sign;
	}

	public char[] getSpacenews(){
		return this.spacenews;
	}

	public void setSpacenews(char[] spacenews){
		this.spacenews=spacenews;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getPagesize()+"\t"
		+this.getMatt()+"\t"
		+this.getSpacename()+"\t"
		+this.getSpacelogo()+"\t"
		+this.getSpacestyle()+"\t"
		+this.getSign()+"\t"
		+new String(this.getSpacenews())+"\t"
		;
	}


}
