package net.frank.dede.bean;


public class DedeMultiservConfig extends net.frank.framework.bo.BaseEntity{


	private Integer remoteuploads;

	private char[] remoteupurl;

	private char[] rminfo;

	private char[] servinfo;





	public Integer getRemoteuploads(){
		return this.remoteuploads;
	}

	public void setRemoteuploads(Integer remoteuploads){
		this.remoteuploads=remoteuploads;
	}

	public char[] getRemoteupurl(){
		return this.remoteupurl;
	}

	public void setRemoteupurl(char[] remoteupurl){
		this.remoteupurl=remoteupurl;
	}

	public char[] getRminfo(){
		return this.rminfo;
	}

	public void setRminfo(char[] rminfo){
		this.rminfo=rminfo;
	}

	public char[] getServinfo(){
		return this.servinfo;
	}

	public void setServinfo(char[] servinfo){
		this.servinfo=servinfo;
	}





	public String toString(){
		return ""
		+this.getRemoteuploads()+"\t"
		+new String(this.getRemoteupurl())+"\t"
		+new String(this.getRminfo())+"\t"
		+new String(this.getServinfo())+"\t"
		;
	}


}
