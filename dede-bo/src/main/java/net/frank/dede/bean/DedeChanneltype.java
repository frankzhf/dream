package net.frank.dede.bean;


public class DedeChanneltype extends net.frank.framework.bo.BaseEntity{


	private String nid;

	private String typename;

	private String maintable;

	private String addtable;

	private String addcon;

	private String mancon;

	private String editcon;

	private String useraddcon;

	private String usermancon;

	private String usereditcon;

	private char[] fieldset;

	private char[] listfields;

	private char[] allfields;

	private Integer issystem;

	private Integer isshow;

	private Integer issend;

	private Integer arcsta;

	private String usertype;

	private Integer sendrank;

	private Integer isdefault;

	private Boolean needdes;

	private Boolean needpic;

	private String titlename;

	private Integer onlyone;

	private Integer dfcid;





	public String getNid(){
		return this.nid;
	}

	public void setNid(String nid){
		this.nid=nid;
	}

	public String getTypename(){
		return this.typename;
	}

	public void setTypename(String typename){
		this.typename=typename;
	}

	public String getMaintable(){
		return this.maintable;
	}

	public void setMaintable(String maintable){
		this.maintable=maintable;
	}

	public String getAddtable(){
		return this.addtable;
	}

	public void setAddtable(String addtable){
		this.addtable=addtable;
	}

	public String getAddcon(){
		return this.addcon;
	}

	public void setAddcon(String addcon){
		this.addcon=addcon;
	}

	public String getMancon(){
		return this.mancon;
	}

	public void setMancon(String mancon){
		this.mancon=mancon;
	}

	public String getEditcon(){
		return this.editcon;
	}

	public void setEditcon(String editcon){
		this.editcon=editcon;
	}

	public String getUseraddcon(){
		return this.useraddcon;
	}

	public void setUseraddcon(String useraddcon){
		this.useraddcon=useraddcon;
	}

	public String getUsermancon(){
		return this.usermancon;
	}

	public void setUsermancon(String usermancon){
		this.usermancon=usermancon;
	}

	public String getUsereditcon(){
		return this.usereditcon;
	}

	public void setUsereditcon(String usereditcon){
		this.usereditcon=usereditcon;
	}

	public char[] getFieldset(){
		return this.fieldset;
	}

	public void setFieldset(char[] fieldset){
		this.fieldset=fieldset;
	}

	public char[] getListfields(){
		return this.listfields;
	}

	public void setListfields(char[] listfields){
		this.listfields=listfields;
	}

	public char[] getAllfields(){
		return this.allfields;
	}

	public void setAllfields(char[] allfields){
		this.allfields=allfields;
	}

	public Integer getIssystem(){
		return this.issystem;
	}

	public void setIssystem(Integer issystem){
		this.issystem=issystem;
	}

	public Integer getIsshow(){
		return this.isshow;
	}

	public void setIsshow(Integer isshow){
		this.isshow=isshow;
	}

	public Integer getIssend(){
		return this.issend;
	}

	public void setIssend(Integer issend){
		this.issend=issend;
	}

	public Integer getArcsta(){
		return this.arcsta;
	}

	public void setArcsta(Integer arcsta){
		this.arcsta=arcsta;
	}

	public String getUsertype(){
		return this.usertype;
	}

	public void setUsertype(String usertype){
		this.usertype=usertype;
	}

	public Integer getSendrank(){
		return this.sendrank;
	}

	public void setSendrank(Integer sendrank){
		this.sendrank=sendrank;
	}

	public Integer getIsdefault(){
		return this.isdefault;
	}

	public void setIsdefault(Integer isdefault){
		this.isdefault=isdefault;
	}

	public Boolean getNeeddes(){
		return this.needdes;
	}

	public void setNeeddes(Boolean needdes){
		this.needdes=needdes;
	}

	public Boolean getNeedpic(){
		return this.needpic;
	}

	public void setNeedpic(Boolean needpic){
		this.needpic=needpic;
	}

	public String getTitlename(){
		return this.titlename;
	}

	public void setTitlename(String titlename){
		this.titlename=titlename;
	}

	public Integer getOnlyone(){
		return this.onlyone;
	}

	public void setOnlyone(Integer onlyone){
		this.onlyone=onlyone;
	}

	public Integer getDfcid(){
		return this.dfcid;
	}

	public void setDfcid(Integer dfcid){
		this.dfcid=dfcid;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getNid()+"\t"
		+this.getTypename()+"\t"
		+this.getMaintable()+"\t"
		+this.getAddtable()+"\t"
		+this.getAddcon()+"\t"
		+this.getMancon()+"\t"
		+this.getEditcon()+"\t"
		+this.getUseraddcon()+"\t"
		+this.getUsermancon()+"\t"
		+this.getUsereditcon()+"\t"
		+new String(this.getFieldset())+"\t"
		+new String(this.getListfields())+"\t"
		+new String(this.getAllfields())+"\t"
		+this.getIssystem()+"\t"
		+this.getIsshow()+"\t"
		+this.getIssend()+"\t"
		+this.getArcsta()+"\t"
		+this.getUsertype()+"\t"
		+this.getSendrank()+"\t"
		+this.getIsdefault()+"\t"
		+this.getNeeddes()+"\t"
		+this.getNeedpic()+"\t"
		+this.getTitlename()+"\t"
		+this.getOnlyone()+"\t"
		+this.getDfcid()+"\t"
		;
	}


}
