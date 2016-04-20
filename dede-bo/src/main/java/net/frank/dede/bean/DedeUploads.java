package net.frank.dede.bean;


public class DedeUploads extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer arcid;

	private String title;

	private String url;

	private Integer mediatype;

	private String width;

	private String height;

	private String playtime;

	private Integer filesize;

	private Integer uptime;

	private Integer mid;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public Integer getArcid(){
		return this.arcid;
	}

	public void setArcid(Integer arcid){
		this.arcid=arcid;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url=url;
	}

	public Integer getMediatype(){
		return this.mediatype;
	}

	public void setMediatype(Integer mediatype){
		this.mediatype=mediatype;
	}

	public String getWidth(){
		return this.width;
	}

	public void setWidth(String width){
		this.width=width;
	}

	public String getHeight(){
		return this.height;
	}

	public void setHeight(String height){
		this.height=height;
	}

	public String getPlaytime(){
		return this.playtime;
	}

	public void setPlaytime(String playtime){
		this.playtime=playtime;
	}

	public Integer getFilesize(){
		return this.filesize;
	}

	public void setFilesize(Integer filesize){
		this.filesize=filesize;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getArcid()+"\t"
		+this.getTitle()+"\t"
		+this.getUrl()+"\t"
		+this.getMediatype()+"\t"
		+this.getWidth()+"\t"
		+this.getHeight()+"\t"
		+this.getPlaytime()+"\t"
		+this.getFilesize()+"\t"
		+this.getUptime()+"\t"
		+this.getMid()+"\t"
		;
	}


}
