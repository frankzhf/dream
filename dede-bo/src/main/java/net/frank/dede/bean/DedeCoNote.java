package net.frank.dede.bean;


public class DedeCoNote extends net.frank.framework.bo.BaseEntity{


	private Integer nid;

	private Integer channelid;

	private String notename;

	private String sourcelang;

	private Integer uptime;

	private Integer cotime;

	private Integer pnum;

	private Boolean isok;

	private Boolean usemore;

	private char[] listconfig;

	private char[] itemconfig;





	public Integer getNid(){
		return this.nid;
	}

	public void setNid(Integer nid){
		this.nid=nid;
	}

	public Integer getChannelid(){
		return this.channelid;
	}

	public void setChannelid(Integer channelid){
		this.channelid=channelid;
	}

	public String getNotename(){
		return this.notename;
	}

	public void setNotename(String notename){
		this.notename=notename;
	}

	public String getSourcelang(){
		return this.sourcelang;
	}

	public void setSourcelang(String sourcelang){
		this.sourcelang=sourcelang;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public Integer getCotime(){
		return this.cotime;
	}

	public void setCotime(Integer cotime){
		this.cotime=cotime;
	}

	public Integer getPnum(){
		return this.pnum;
	}

	public void setPnum(Integer pnum){
		this.pnum=pnum;
	}

	public Boolean getIsok(){
		return this.isok;
	}

	public void setIsok(Boolean isok){
		this.isok=isok;
	}

	public Boolean getUsemore(){
		return this.usemore;
	}

	public void setUsemore(Boolean usemore){
		this.usemore=usemore;
	}

	public char[] getListconfig(){
		return this.listconfig;
	}

	public void setListconfig(char[] listconfig){
		this.listconfig=listconfig;
	}

	public char[] getItemconfig(){
		return this.itemconfig;
	}

	public void setItemconfig(char[] itemconfig){
		this.itemconfig=itemconfig;
	}





	public String toString(){
		return ""
		+this.getNid()+"\t"
		+this.getChannelid()+"\t"
		+this.getNotename()+"\t"
		+this.getSourcelang()+"\t"
		+this.getUptime()+"\t"
		+this.getCotime()+"\t"
		+this.getPnum()+"\t"
		+this.getIsok()+"\t"
		+this.getUsemore()+"\t"
		+new String(this.getListconfig())+"\t"
		+new String(this.getItemconfig())+"\t"
		;
	}


}
