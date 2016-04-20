package net.frank.dede.bean;

import java.util.Date;

public class DedeMemberPerson extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private Boolean onlynet;

	private String sex;

	private String uname;

	private String qq;

	private String msn;

	private String tel;

	private String mobile;

	private Integer place;

	private Integer oldplace;

	private Date birthday;

	private Integer star;

	private Integer income;

	private Integer education;

	private Integer height;

	private Integer bodytype;

	private Integer blood;

	private Integer vocation;

	private Integer smoke;

	private Integer marital;

	private Integer house;

	private Integer drink;

	private Integer datingtype;

	private String language;

	private String nature;

	private String lovemsg;

	private String address;

	private Integer uptime;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public Boolean getOnlynet(){
		return this.onlynet;
	}

	public void setOnlynet(Boolean onlynet){
		this.onlynet=onlynet;
	}

	public String getSex(){
		return this.sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public String getUname(){
		return this.uname;
	}

	public void setUname(String uname){
		this.uname=uname;
	}

	public String getQq(){
		return this.qq;
	}

	public void setQq(String qq){
		this.qq=qq;
	}

	public String getMsn(){
		return this.msn;
	}

	public void setMsn(String msn){
		this.msn=msn;
	}

	public String getTel(){
		return this.tel;
	}

	public void setTel(String tel){
		this.tel=tel;
	}

	public String getMobile(){
		return this.mobile;
	}

	public void setMobile(String mobile){
		this.mobile=mobile;
	}

	public Integer getPlace(){
		return this.place;
	}

	public void setPlace(Integer place){
		this.place=place;
	}

	public Integer getOldplace(){
		return this.oldplace;
	}

	public void setOldplace(Integer oldplace){
		this.oldplace=oldplace;
	}

	public Date getBirthday(){
		return this.birthday;
	}

	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}

	public Integer getStar(){
		return this.star;
	}

	public void setStar(Integer star){
		this.star=star;
	}

	public Integer getIncome(){
		return this.income;
	}

	public void setIncome(Integer income){
		this.income=income;
	}

	public Integer getEducation(){
		return this.education;
	}

	public void setEducation(Integer education){
		this.education=education;
	}

	public Integer getHeight(){
		return this.height;
	}

	public void setHeight(Integer height){
		this.height=height;
	}

	public Integer getBodytype(){
		return this.bodytype;
	}

	public void setBodytype(Integer bodytype){
		this.bodytype=bodytype;
	}

	public Integer getBlood(){
		return this.blood;
	}

	public void setBlood(Integer blood){
		this.blood=blood;
	}

	public Integer getVocation(){
		return this.vocation;
	}

	public void setVocation(Integer vocation){
		this.vocation=vocation;
	}

	public Integer getSmoke(){
		return this.smoke;
	}

	public void setSmoke(Integer smoke){
		this.smoke=smoke;
	}

	public Integer getMarital(){
		return this.marital;
	}

	public void setMarital(Integer marital){
		this.marital=marital;
	}

	public Integer getHouse(){
		return this.house;
	}

	public void setHouse(Integer house){
		this.house=house;
	}

	public Integer getDrink(){
		return this.drink;
	}

	public void setDrink(Integer drink){
		this.drink=drink;
	}

	public Integer getDatingtype(){
		return this.datingtype;
	}

	public void setDatingtype(Integer datingtype){
		this.datingtype=datingtype;
	}

	public String getLanguage(){
		return this.language;
	}

	public void setLanguage(String language){
		this.language=language;
	}

	public String getNature(){
		return this.nature;
	}

	public void setNature(String nature){
		this.nature=nature;
	}

	public String getLovemsg(){
		return this.lovemsg;
	}

	public void setLovemsg(String lovemsg){
		this.lovemsg=lovemsg;
	}

	public String getAddress(){
		return this.address;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getOnlynet()+"\t"
		+this.getSex()+"\t"
		+this.getUname()+"\t"
		+this.getQq()+"\t"
		+this.getMsn()+"\t"
		+this.getTel()+"\t"
		+this.getMobile()+"\t"
		+this.getPlace()+"\t"
		+this.getOldplace()+"\t"
		+this.getBirthday()+"\t"
		+this.getStar()+"\t"
		+this.getIncome()+"\t"
		+this.getEducation()+"\t"
		+this.getHeight()+"\t"
		+this.getBodytype()+"\t"
		+this.getBlood()+"\t"
		+this.getVocation()+"\t"
		+this.getSmoke()+"\t"
		+this.getMarital()+"\t"
		+this.getHouse()+"\t"
		+this.getDrink()+"\t"
		+this.getDatingtype()+"\t"
		+this.getLanguage()+"\t"
		+this.getNature()+"\t"
		+this.getLovemsg()+"\t"
		+this.getAddress()+"\t"
		+this.getUptime()+"\t"
		;
	}


}
