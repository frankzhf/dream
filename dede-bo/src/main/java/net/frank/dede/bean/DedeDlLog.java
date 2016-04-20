package net.frank.dede.bean;


public class DedeDlLog extends net.frank.framework.bo.BaseEntity{


	private String ip;

	private String lang;

	private String dtype;

	private Integer dltime;

	private String referrer;

	private String userAgent;





	public String getIp(){
		return this.ip;
	}

	public void setIp(String ip){
		this.ip=ip;
	}

	public String getLang(){
		return this.lang;
	}

	public void setLang(String lang){
		this.lang=lang;
	}

	public String getDtype(){
		return this.dtype;
	}

	public void setDtype(String dtype){
		this.dtype=dtype;
	}

	public Integer getDltime(){
		return this.dltime;
	}

	public void setDltime(Integer dltime){
		this.dltime=dltime;
	}

	public String getReferrer(){
		return this.referrer;
	}

	public void setReferrer(String referrer){
		this.referrer=referrer;
	}

	public String getUserAgent(){
		return this.userAgent;
	}

	public void setUserAgent(String userAgent){
		this.userAgent=userAgent;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getIp()+"\t"
		+this.getLang()+"\t"
		+this.getDtype()+"\t"
		+this.getDltime()+"\t"
		+this.getReferrer()+"\t"
		+this.getUserAgent()+"\t"
		;
	}


}
