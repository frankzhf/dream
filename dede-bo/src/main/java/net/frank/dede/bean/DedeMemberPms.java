package net.frank.dede.bean;


public class DedeMemberPms extends net.frank.framework.bo.BaseEntity{


	private String floginid;

	private Integer fromid;

	private Integer toid;

	private String tologinid;

	private String folder;

	private String subject;

	private Integer sendtime;

	private Integer writetime;

	private Boolean hasview;

	private Boolean isadmin;

	private char[] message;





	public String getFloginid(){
		return this.floginid;
	}

	public void setFloginid(String floginid){
		this.floginid=floginid;
	}

	public Integer getFromid(){
		return this.fromid;
	}

	public void setFromid(Integer fromid){
		this.fromid=fromid;
	}

	public Integer getToid(){
		return this.toid;
	}

	public void setToid(Integer toid){
		this.toid=toid;
	}

	public String getTologinid(){
		return this.tologinid;
	}

	public void setTologinid(String tologinid){
		this.tologinid=tologinid;
	}

	public String getFolder(){
		return this.folder;
	}

	public void setFolder(String folder){
		this.folder=folder;
	}

	public String getSubject(){
		return this.subject;
	}

	public void setSubject(String subject){
		this.subject=subject;
	}

	public Integer getSendtime(){
		return this.sendtime;
	}

	public void setSendtime(Integer sendtime){
		this.sendtime=sendtime;
	}

	public Integer getWritetime(){
		return this.writetime;
	}

	public void setWritetime(Integer writetime){
		this.writetime=writetime;
	}

	public Boolean getHasview(){
		return this.hasview;
	}

	public void setHasview(Boolean hasview){
		this.hasview=hasview;
	}

	public Boolean getIsadmin(){
		return this.isadmin;
	}

	public void setIsadmin(Boolean isadmin){
		this.isadmin=isadmin;
	}

	public char[] getMessage(){
		return this.message;
	}

	public void setMessage(char[] message){
		this.message=message;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getFloginid()+"\t"
		+this.getFromid()+"\t"
		+this.getToid()+"\t"
		+this.getTologinid()+"\t"
		+this.getFolder()+"\t"
		+this.getSubject()+"\t"
		+this.getSendtime()+"\t"
		+this.getWritetime()+"\t"
		+this.getHasview()+"\t"
		+this.getIsadmin()+"\t"
		+new String(this.getMessage())+"\t"
		;
	}


}
