package net.frank.dede.bean;


public class DedeArccache extends net.frank.framework.bo.BaseEntity{


	private String md5hash;

	private Integer uptime;

	private char[] cachedata;





	public String getMd5hash(){
		return this.md5hash;
	}

	public void setMd5hash(String md5hash){
		this.md5hash=md5hash;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public char[] getCachedata(){
		return this.cachedata;
	}

	public void setCachedata(char[] cachedata){
		this.cachedata=cachedata;
	}





	public String toString(){
		return ""
		+this.getMd5hash()+"\t"
		+this.getUptime()+"\t"
		+new String(this.getCachedata())+"\t"
		;
	}


}
