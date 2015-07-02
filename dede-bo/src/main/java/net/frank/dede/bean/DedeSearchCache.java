package net.frank.dede.bean;


public class DedeSearchCache extends net.frank.framework.bo.BaseEntity{


	private String hash;

	private Integer lasttime;

	private Integer rsnum;

	private char[] ids;





	public String getHash(){
		return this.hash;
	}

	public void setHash(String hash){
		this.hash=hash;
	}

	public Integer getLasttime(){
		return this.lasttime;
	}

	public void setLasttime(Integer lasttime){
		this.lasttime=lasttime;
	}

	public Integer getRsnum(){
		return this.rsnum;
	}

	public void setRsnum(Integer rsnum){
		this.rsnum=rsnum;
	}

	public char[] getIds(){
		return this.ids;
	}

	public void setIds(char[] ids){
		this.ids=ids;
	}





	public String toString(){
		return ""
		+this.getHash()+"\t"
		+this.getLasttime()+"\t"
		+this.getRsnum()+"\t"
		+new String(this.getIds())+"\t"
		;
	}


}
