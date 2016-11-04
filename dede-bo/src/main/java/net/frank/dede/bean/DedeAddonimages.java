package net.frank.dede.bean;


public class DedeAddonimages extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private Integer pagestyle;

	private Integer maxwidth;

	private char[] imgurls;

	private Integer row;

	private Integer col;

	private Integer isrm;

	private Integer ddmaxwidth;

	private Integer pagepicnum;

	private String templet;

	private String userip;

	private String redirecturl;

	private char[] body;





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

	public Integer getPagestyle(){
		return this.pagestyle;
	}

	public void setPagestyle(Integer pagestyle){
		this.pagestyle=pagestyle;
	}

	public Integer getMaxwidth(){
		return this.maxwidth;
	}

	public void setMaxwidth(Integer maxwidth){
		this.maxwidth=maxwidth;
	}

	public char[] getImgurls(){
		return this.imgurls;
	}

	public void setImgurls(char[] imgurls){
		this.imgurls=imgurls;
	}

	public Integer getRow(){
		return this.row;
	}

	public void setRow(Integer row){
		this.row=row;
	}

	public Integer getCol(){
		return this.col;
	}

	public void setCol(Integer col){
		this.col=col;
	}

	public Integer getIsrm(){
		return this.isrm;
	}

	public void setIsrm(Integer isrm){
		this.isrm=isrm;
	}

	public Integer getDdmaxwidth(){
		return this.ddmaxwidth;
	}

	public void setDdmaxwidth(Integer ddmaxwidth){
		this.ddmaxwidth=ddmaxwidth;
	}

	public Integer getPagepicnum(){
		return this.pagepicnum;
	}

	public void setPagepicnum(Integer pagepicnum){
		this.pagepicnum=pagepicnum;
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

	public char[] getBody(){
		return this.body;
	}

	public void setBody(char[] body){
		this.body=body;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+this.getPagestyle()+"\t"
		+this.getMaxwidth()+"\t"
		+new String(this.getImgurls())+"\t"
		+this.getRow()+"\t"
		+this.getCol()+"\t"
		+this.getIsrm()+"\t"
		+this.getDdmaxwidth()+"\t"
		+this.getPagepicnum()+"\t"
		+this.getTemplet()+"\t"
		+this.getUserip()+"\t"
		+this.getRedirecturl()+"\t"
		+new String(this.getBody())+"\t"
		;
	}


}
