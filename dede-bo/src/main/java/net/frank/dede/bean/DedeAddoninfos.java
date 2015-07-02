package net.frank.dede.bean;


public class DedeAddoninfos extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private Integer typeid;

	private Integer channel;

	private Integer arcrank;

	private Integer mid;

	private Integer click;

	private String title;

	private String litpic;

	private String userip;

	private Integer senddate;

	private String flag;

	private Integer lastpost;

	private Integer scores;

	private Integer goodpost;

	private Integer badpost;

	private Integer nativeplace;

	private String infotype;

	private char[] body;

	private Integer endtime;

	private String tel;

	private String email;

	private String address;

	private String linkman;





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

	public Integer getChannel(){
		return this.channel;
	}

	public void setChannel(Integer channel){
		this.channel=channel;
	}

	public Integer getArcrank(){
		return this.arcrank;
	}

	public void setArcrank(Integer arcrank){
		this.arcrank=arcrank;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Integer getClick(){
		return this.click;
	}

	public void setClick(Integer click){
		this.click=click;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getLitpic(){
		return this.litpic;
	}

	public void setLitpic(String litpic){
		this.litpic=litpic;
	}

	public String getUserip(){
		return this.userip;
	}

	public void setUserip(String userip){
		this.userip=userip;
	}

	public Integer getSenddate(){
		return this.senddate;
	}

	public void setSenddate(Integer senddate){
		this.senddate=senddate;
	}

	public String getFlag(){
		return this.flag;
	}

	public void setFlag(String flag){
		this.flag=flag;
	}

	public Integer getLastpost(){
		return this.lastpost;
	}

	public void setLastpost(Integer lastpost){
		this.lastpost=lastpost;
	}

	public Integer getScores(){
		return this.scores;
	}

	public void setScores(Integer scores){
		this.scores=scores;
	}

	public Integer getGoodpost(){
		return this.goodpost;
	}

	public void setGoodpost(Integer goodpost){
		this.goodpost=goodpost;
	}

	public Integer getBadpost(){
		return this.badpost;
	}

	public void setBadpost(Integer badpost){
		this.badpost=badpost;
	}

	public Integer getNativeplace(){
		return this.nativeplace;
	}

	public void setNativeplace(Integer nativeplace){
		this.nativeplace=nativeplace;
	}

	public String getInfotype(){
		return this.infotype;
	}

	public void setInfotype(String infotype){
		this.infotype=infotype;
	}

	public char[] getBody(){
		return this.body;
	}

	public void setBody(char[] body){
		this.body=body;
	}

	public Integer getEndtime(){
		return this.endtime;
	}

	public void setEndtime(Integer endtime){
		this.endtime=endtime;
	}

	public String getTel(){
		return this.tel;
	}

	public void setTel(String tel){
		this.tel=tel;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public String getAddress(){
		return this.address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getLinkman(){
		return this.linkman;
	}

	public void setLinkman(String linkman){
		this.linkman=linkman;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getTypeid()+"\t"
		+this.getChannel()+"\t"
		+this.getArcrank()+"\t"
		+this.getMid()+"\t"
		+this.getClick()+"\t"
		+this.getTitle()+"\t"
		+this.getLitpic()+"\t"
		+this.getUserip()+"\t"
		+this.getSenddate()+"\t"
		+this.getFlag()+"\t"
		+this.getLastpost()+"\t"
		+this.getScores()+"\t"
		+this.getGoodpost()+"\t"
		+this.getBadpost()+"\t"
		+this.getNativeplace()+"\t"
		+this.getInfotype()+"\t"
		+new String(this.getBody())+"\t"
		+this.getEndtime()+"\t"
		+this.getTel()+"\t"
		+this.getEmail()+"\t"
		+this.getAddress()+"\t"
		+this.getLinkman()+"\t"
		;
	}


}
