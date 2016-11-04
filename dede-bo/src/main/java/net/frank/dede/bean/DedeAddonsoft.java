package net.frank.dede.bean;


public class DedeAddonsoft extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private String filetype;

	private String language;

	private String softtype;

	private String accredit;

	private String os;

	private Integer softrank;

	private String officialurl;

	private String officialdemo;

	private String softsize;

	private char[] softlinks;

	private char[] introduce;

	private Integer daccess;

	private Integer needmoney;

	private String templet;

	private String userip;

	private String redirecturl;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public String getFiletype(){
		return this.filetype;
	}

	public void setFiletype(String filetype){
		this.filetype=filetype;
	}

	public String getLanguage(){
		return this.language;
	}

	public void setLanguage(String language){
		this.language=language;
	}

	public String getSofttype(){
		return this.softtype;
	}

	public void setSofttype(String softtype){
		this.softtype=softtype;
	}

	public String getAccredit(){
		return this.accredit;
	}

	public void setAccredit(String accredit){
		this.accredit=accredit;
	}

	public String getOs(){
		return this.os;
	}

	public void setOs(String os){
		this.os=os;
	}

	public Integer getSoftrank(){
		return this.softrank;
	}

	public void setSoftrank(Integer softrank){
		this.softrank=softrank;
	}

	public String getOfficialurl(){
		return this.officialurl;
	}

	public void setOfficialurl(String officialurl){
		this.officialurl=officialurl;
	}

	public String getOfficialdemo(){
		return this.officialdemo;
	}

	public void setOfficialdemo(String officialdemo){
		this.officialdemo=officialdemo;
	}

	public String getSoftsize(){
		return this.softsize;
	}

	public void setSoftsize(String softsize){
		this.softsize=softsize;
	}

	public char[] getSoftlinks(){
		return this.softlinks;
	}

	public void setSoftlinks(char[] softlinks){
		this.softlinks=softlinks;
	}

	public char[] getIntroduce(){
		return this.introduce;
	}

	public void setIntroduce(char[] introduce){
		this.introduce=introduce;
	}

	public Integer getDaccess(){
		return this.daccess;
	}

	public void setDaccess(Integer daccess){
		this.daccess=daccess;
	}

	public Integer getNeedmoney(){
		return this.needmoney;
	}

	public void setNeedmoney(Integer needmoney){
		this.needmoney=needmoney;
	}

	public String getTemplet(){
		return this.templet;
	}

	public void setTemplet(String templet){
		this.templet=templet;
	}

	public String getUserip(){
		return this.userip;
	}

	public void setUserip(String userip){
		this.userip=userip;
	}

	public String getRedirecturl(){
		return this.redirecturl;
	}

	public void setRedirecturl(String redirecturl){
		this.redirecturl=redirecturl;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+this.getFiletype()+"\t"
		+this.getLanguage()+"\t"
		+this.getSofttype()+"\t"
		+this.getAccredit()+"\t"
		+this.getOs()+"\t"
		+this.getSoftrank()+"\t"
		+this.getOfficialurl()+"\t"
		+this.getOfficialdemo()+"\t"
		+this.getSoftsize()+"\t"
		+new String(this.getSoftlinks())+"\t"
		+new String(this.getIntroduce())+"\t"
		+this.getDaccess()+"\t"
		+this.getNeedmoney()+"\t"
		+this.getTemplet()+"\t"
		+this.getUserip()+"\t"
		+this.getRedirecturl()+"\t"
		;
	}


}
