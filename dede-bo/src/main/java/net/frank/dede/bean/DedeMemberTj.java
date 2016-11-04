package net.frank.dede.bean;


public class DedeMemberTj extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private Integer article;

	private Integer album;

	private Integer archives;

	private Integer homecount;

	private Integer pagecount;

	private Integer feedback;

	private Integer friend;

	private Integer stow;

	private Integer soft;

	private Integer info;

	private Integer shop;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getArticle(){
		return this.article;
	}

	public void setArticle(Integer article){
		this.article=article;
	}

	public Integer getAlbum(){
		return this.album;
	}

	public void setAlbum(Integer album){
		this.album=album;
	}

	public Integer getArchives(){
		return this.archives;
	}

	public void setArchives(Integer archives){
		this.archives=archives;
	}

	public Integer getHomecount(){
		return this.homecount;
	}

	public void setHomecount(Integer homecount){
		this.homecount=homecount;
	}

	public Integer getPagecount(){
		return this.pagecount;
	}

	public void setPagecount(Integer pagecount){
		this.pagecount=pagecount;
	}

	public Integer getFeedback(){
		return this.feedback;
	}

	public void setFeedback(Integer feedback){
		this.feedback=feedback;
	}

	public Integer getFriend(){
		return this.friend;
	}

	public void setFriend(Integer friend){
		this.friend=friend;
	}

	public Integer getStow(){
		return this.stow;
	}

	public void setStow(Integer stow){
		this.stow=stow;
	}

	public Integer getSoft(){
		return this.soft;
	}

	public void setSoft(Integer soft){
		this.soft=soft;
	}

	public Integer getInfo(){
		return this.info;
	}

	public void setInfo(Integer info){
		this.info=info;
	}

	public Integer getShop(){
		return this.shop;
	}

	public void setShop(Integer shop){
		this.shop=shop;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getArticle()+"\t"
		+this.getAlbum()+"\t"
		+this.getArchives()+"\t"
		+this.getHomecount()+"\t"
		+this.getPagecount()+"\t"
		+this.getFeedback()+"\t"
		+this.getFriend()+"\t"
		+this.getStow()+"\t"
		+this.getSoft()+"\t"
		+this.getInfo()+"\t"
		+this.getShop()+"\t"
		;
	}


}
