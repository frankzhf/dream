package net.frank.dede.bean;


public class DedeArctype extends net.frank.framework.bo.BaseEntity{


	private Integer reid;

	private Integer topid;

	private Integer sortrank;

	private String typename;

	private String typedir;

	private Integer isdefault;

	private String defaultname;

	private Integer issend;

	private Integer channeltype;

	private Integer maxpage;

	private Integer ispart;

	private Integer corank;

	private String tempindex;

	private String templist;

	private String temparticle;

	private String namerule;

	private String namerule2;

	private String modname;

	private String description;

	private String keywords;

	private String seotitle;

	private Boolean moresite;

	private String sitepath;

	private String siteurl;

	private Integer ishidden;

	private Boolean cross;

	private char[] crossid;

	private char[] content;

	private char[] smalltypes;





	public Integer getReid(){
		return this.reid;
	}

	public void setReid(Integer reid){
		this.reid=reid;
	}

	public Integer getTopid(){
		return this.topid;
	}

	public void setTopid(Integer topid){
		this.topid=topid;
	}

	public Integer getSortrank(){
		return this.sortrank;
	}

	public void setSortrank(Integer sortrank){
		this.sortrank=sortrank;
	}

	public String getTypename(){
		return this.typename;
	}

	public void setTypename(String typename){
		this.typename=typename;
	}

	public String getTypedir(){
		return this.typedir;
	}

	public void setTypedir(String typedir){
		this.typedir=typedir;
	}

	public Integer getIsdefault(){
		return this.isdefault;
	}

	public void setIsdefault(Integer isdefault){
		this.isdefault=isdefault;
	}

	public String getDefaultname(){
		return this.defaultname;
	}

	public void setDefaultname(String defaultname){
		this.defaultname=defaultname;
	}

	public Integer getIssend(){
		return this.issend;
	}

	public void setIssend(Integer issend){
		this.issend=issend;
	}

	public Integer getChanneltype(){
		return this.channeltype;
	}

	public void setChanneltype(Integer channeltype){
		this.channeltype=channeltype;
	}

	public Integer getMaxpage(){
		return this.maxpage;
	}

	public void setMaxpage(Integer maxpage){
		this.maxpage=maxpage;
	}

	public Integer getIspart(){
		return this.ispart;
	}

	public void setIspart(Integer ispart){
		this.ispart=ispart;
	}

	public Integer getCorank(){
		return this.corank;
	}

	public void setCorank(Integer corank){
		this.corank=corank;
	}

	public String getTempindex(){
		return this.tempindex;
	}

	public void setTempindex(String tempindex){
		this.tempindex=tempindex;
	}

	public String getTemplist(){
		return this.templist;
	}

	public void setTemplist(String templist){
		this.templist=templist;
	}

	public String getTemparticle(){
		return this.temparticle;
	}

	public void setTemparticle(String temparticle){
		this.temparticle=temparticle;
	}

	public String getNamerule(){
		return this.namerule;
	}

	public void setNamerule(String namerule){
		this.namerule=namerule;
	}

	public String getNamerule2(){
		return this.namerule2;
	}

	public void setNamerule2(String namerule2){
		this.namerule2=namerule2;
	}

	public String getModname(){
		return this.modname;
	}

	public void setModname(String modname){
		this.modname=modname;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public String getKeywords(){
		return this.keywords;
	}

	public void setKeywords(String keywords){
		this.keywords=keywords;
	}

	public String getSeotitle(){
		return this.seotitle;
	}

	public void setSeotitle(String seotitle){
		this.seotitle=seotitle;
	}

	public Boolean getMoresite(){
		return this.moresite;
	}

	public void setMoresite(Boolean moresite){
		this.moresite=moresite;
	}

	public String getSitepath(){
		return this.sitepath;
	}

	public void setSitepath(String sitepath){
		this.sitepath=sitepath;
	}

	public String getSiteurl(){
		return this.siteurl;
	}

	public void setSiteurl(String siteurl){
		this.siteurl=siteurl;
	}

	public Integer getIshidden(){
		return this.ishidden;
	}

	public void setIshidden(Integer ishidden){
		this.ishidden=ishidden;
	}

	public Boolean getCross(){
		return this.cross;
	}

	public void setCross(Boolean cross){
		this.cross=cross;
	}

	public char[] getCrossid(){
		return this.crossid;
	}

	public void setCrossid(char[] crossid){
		this.crossid=crossid;
	}

	public char[] getContent(){
		return this.content;
	}

	public void setContent(char[] content){
		this.content=content;
	}

	public char[] getSmalltypes(){
		return this.smalltypes;
	}

	public void setSmalltypes(char[] smalltypes){
		this.smalltypes=smalltypes;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getReid()+"\t"
		+this.getTopid()+"\t"
		+this.getSortrank()+"\t"
		+this.getTypename()+"\t"
		+this.getTypedir()+"\t"
		+this.getIsdefault()+"\t"
		+this.getDefaultname()+"\t"
		+this.getIssend()+"\t"
		+this.getChanneltype()+"\t"
		+this.getMaxpage()+"\t"
		+this.getIspart()+"\t"
		+this.getCorank()+"\t"
		+this.getTempindex()+"\t"
		+this.getTemplist()+"\t"
		+this.getTemparticle()+"\t"
		+this.getNamerule()+"\t"
		+this.getNamerule2()+"\t"
		+this.getModname()+"\t"
		+this.getDescription()+"\t"
		+this.getKeywords()+"\t"
		+this.getSeotitle()+"\t"
		+this.getMoresite()+"\t"
		+this.getSitepath()+"\t"
		+this.getSiteurl()+"\t"
		+this.getIshidden()+"\t"
		+this.getCross()+"\t"
		+new String(this.getCrossid())+"\t"
		+new String(this.getContent())+"\t"
		+new String(this.getSmalltypes())+"\t"
		;
	}


}
