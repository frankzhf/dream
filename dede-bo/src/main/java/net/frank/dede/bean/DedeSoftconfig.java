package net.frank.dede.bean;


public class DedeSoftconfig extends net.frank.framework.bo.BaseEntity{


	private Integer downtype;

	private Integer ismoresite;

	private Integer gotojump;

	private Integer islocal;

	private char[] sites;

	private char[] downmsg;

	private Integer moresitedo;

	private Integer dfrank;

	private Integer dfywboy;

	private Integer argrange;





	public Integer getDowntype(){
		return this.downtype;
	}

	public void setDowntype(Integer downtype){
		this.downtype=downtype;
	}

	public Integer getIsmoresite(){
		return this.ismoresite;
	}

	public void setIsmoresite(Integer ismoresite){
		this.ismoresite=ismoresite;
	}

	public Integer getGotojump(){
		return this.gotojump;
	}

	public void setGotojump(Integer gotojump){
		this.gotojump=gotojump;
	}

	public Integer getIslocal(){
		return this.islocal;
	}

	public void setIslocal(Integer islocal){
		this.islocal=islocal;
	}

	public char[] getSites(){
		return this.sites;
	}

	public void setSites(char[] sites){
		this.sites=sites;
	}

	public char[] getDownmsg(){
		return this.downmsg;
	}

	public void setDownmsg(char[] downmsg){
		this.downmsg=downmsg;
	}

	public Integer getMoresitedo(){
		return this.moresitedo;
	}

	public void setMoresitedo(Integer moresitedo){
		this.moresitedo=moresitedo;
	}

	public Integer getDfrank(){
		return this.dfrank;
	}

	public void setDfrank(Integer dfrank){
		this.dfrank=dfrank;
	}

	public Integer getDfywboy(){
		return this.dfywboy;
	}

	public void setDfywboy(Integer dfywboy){
		this.dfywboy=dfywboy;
	}

	public Integer getArgrange(){
		return this.argrange;
	}

	public void setArgrange(Integer argrange){
		this.argrange=argrange;
	}





	public String toString(){
		return ""
		+this.getDowntype()+"\t"
		+this.getIsmoresite()+"\t"
		+this.getGotojump()+"\t"
		+this.getIslocal()+"\t"
		+new String(this.getSites())+"\t"
		+new String(this.getDownmsg())+"\t"
		+this.getMoresitedo()+"\t"
		+this.getDfrank()+"\t"
		+this.getDfywboy()+"\t"
		+this.getArgrange()+"\t"
		;
	}


}
