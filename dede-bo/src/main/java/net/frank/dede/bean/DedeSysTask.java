package net.frank.dede.bean;


public class DedeSysTask extends net.frank.framework.bo.BaseEntity{


	private String taskname;

	private String dourl;

	private Boolean islock;

	private Boolean runtype;

	private String runtime;

	private Integer starttime;

	private Integer endtime;

	private Byte freq;

	private Integer lastrun;

	private String description;

	private char[] parameter;

	private Integer settime;

	private String sta;





	public String getTaskname(){
		return this.taskname;
	}

	public void setTaskname(String taskname){
		this.taskname=taskname;
	}

	public String getDourl(){
		return this.dourl;
	}

	public void setDourl(String dourl){
		this.dourl=dourl;
	}

	public Boolean getIslock(){
		return this.islock;
	}

	public void setIslock(Boolean islock){
		this.islock=islock;
	}

	public Boolean getRuntype(){
		return this.runtype;
	}

	public void setRuntype(Boolean runtype){
		this.runtype=runtype;
	}

	public String getRuntime(){
		return this.runtime;
	}

	public void setRuntime(String runtime){
		this.runtime=runtime;
	}

	public Integer getStarttime(){
		return this.starttime;
	}

	public void setStarttime(Integer starttime){
		this.starttime=starttime;
	}

	public Integer getEndtime(){
		return this.endtime;
	}

	public void setEndtime(Integer endtime){
		this.endtime=endtime;
	}

	public Byte getFreq(){
		return this.freq;
	}

	public void setFreq(Byte freq){
		this.freq=freq;
	}

	public Integer getLastrun(){
		return this.lastrun;
	}

	public void setLastrun(Integer lastrun){
		this.lastrun=lastrun;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public char[] getParameter(){
		return this.parameter;
	}

	public void setParameter(char[] parameter){
		this.parameter=parameter;
	}

	public Integer getSettime(){
		return this.settime;
	}

	public void setSettime(Integer settime){
		this.settime=settime;
	}

	public String getSta(){
		return this.sta;
	}

	public void setSta(String sta){
		this.sta=sta;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTaskname()+"\t"
		+this.getDourl()+"\t"
		+this.getIslock()+"\t"
		+this.getRuntype()+"\t"
		+this.getRuntime()+"\t"
		+this.getStarttime()+"\t"
		+this.getEndtime()+"\t"
		+this.getFreq()+"\t"
		+this.getLastrun()+"\t"
		+this.getDescription()+"\t"
		+new String(this.getParameter())+"\t"
		+this.getSettime()+"\t"
		+this.getSta()+"\t"
		;
	}


}
