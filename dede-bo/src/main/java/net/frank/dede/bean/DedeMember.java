package net.frank.dede.bean;


public class DedeMember extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String mtype;

	private String userid;

	private String pwd;

	private String uname;

	private String sex;

	private Integer rank;

	private Integer uptime;

	private Integer exptime;

	private Integer money;

	private String email;

	private Integer scores;

	private Integer matt;

	private Integer spacesta;

	private String face;

	private Integer safequestion;

	private String safeanswer;

	private Integer jointime;

	private String joinip;

	private Integer logintime;

	private String loginip;

	private Integer checkmail;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getMtype(){
		return this.mtype;
	}

	public void setMtype(String mtype){
		this.mtype=mtype;
	}

	public String getUserid(){
		return this.userid;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}

	public String getPwd(){
		return this.pwd;
	}

	public void setPwd(String pwd){
		this.pwd=pwd;
	}

	public String getUname(){
		return this.uname;
	}

	public void setUname(String uname){
		this.uname=uname;
	}

	public String getSex(){
		return this.sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRank(Integer rank){
		this.rank=rank;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public Integer getExptime(){
		return this.exptime;
	}

	public void setExptime(Integer exptime){
		this.exptime=exptime;
	}

	public Integer getMoney(){
		return this.money;
	}

	public void setMoney(Integer money){
		this.money=money;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email=email;
	}

	public Integer getScores(){
		return this.scores;
	}

	public void setScores(Integer scores){
		this.scores=scores;
	}

	public Integer getMatt(){
		return this.matt;
	}

	public void setMatt(Integer matt){
		this.matt=matt;
	}

	public Integer getSpacesta(){
		return this.spacesta;
	}

	public void setSpacesta(Integer spacesta){
		this.spacesta=spacesta;
	}

	public String getFace(){
		return this.face;
	}

	public void setFace(String face){
		this.face=face;
	}

	public Integer getSafequestion(){
		return this.safequestion;
	}

	public void setSafequestion(Integer safequestion){
		this.safequestion=safequestion;
	}

	public String getSafeanswer(){
		return this.safeanswer;
	}

	public void setSafeanswer(String safeanswer){
		this.safeanswer=safeanswer;
	}

	public Integer getJointime(){
		return this.jointime;
	}

	public void setJointime(Integer jointime){
		this.jointime=jointime;
	}

	public String getJoinip(){
		return this.joinip;
	}

	public void setJoinip(String joinip){
		this.joinip=joinip;
	}

	public Integer getLogintime(){
		return this.logintime;
	}

	public void setLogintime(Integer logintime){
		this.logintime=logintime;
	}

	public String getLoginip(){
		return this.loginip;
	}

	public void setLoginip(String loginip){
		this.loginip=loginip;
	}

	public Integer getCheckmail(){
		return this.checkmail;
	}

	public void setCheckmail(Integer checkmail){
		this.checkmail=checkmail;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getMtype()+"\t"
		+this.getUserid()+"\t"
		+this.getPwd()+"\t"
		+this.getUname()+"\t"
		+this.getSex()+"\t"
		+this.getRank()+"\t"
		+this.getUptime()+"\t"
		+this.getExptime()+"\t"
		+this.getMoney()+"\t"
		+this.getEmail()+"\t"
		+this.getScores()+"\t"
		+this.getMatt()+"\t"
		+this.getSpacesta()+"\t"
		+this.getFace()+"\t"
		+this.getSafequestion()+"\t"
		+this.getSafeanswer()+"\t"
		+this.getJointime()+"\t"
		+this.getJoinip()+"\t"
		+this.getLogintime()+"\t"
		+this.getLoginip()+"\t"
		+this.getCheckmail()+"\t"
		;
	}


}
