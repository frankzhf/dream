package net.frank.dede.bean;


public class DedeAdvancedsearch extends net.frank.framework.bo.BaseEntity{


	private Integer mid;

	private String maintable;

	private char[] mainfields;

	private String addontable;

	private char[] addonfields;

	private char[] forms;

	private String template;





	public Integer getMid(){
		return this.mid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}

	public String getMaintable(){
		return this.maintable;
	}

	public void setMaintable(String maintable){
		this.maintable=maintable;
	}

	public char[] getMainfields(){
		return this.mainfields;
	}

	public void setMainfields(char[] mainfields){
		this.mainfields=mainfields;
	}

	public String getAddontable(){
		return this.addontable;
	}

	public void setAddontable(String addontable){
		this.addontable=addontable;
	}

	public char[] getAddonfields(){
		return this.addonfields;
	}

	public void setAddonfields(char[] addonfields){
		this.addonfields=addonfields;
	}

	public char[] getForms(){
		return this.forms;
	}

	public void setForms(char[] forms){
		this.forms=forms;
	}

	public String getTemplate(){
		return this.template;
	}

	public void setTemplate(String template){
		this.template=template;
	}





	public String toString(){
		return ""
		+this.getMid()+"\t"
		+this.getMaintable()+"\t"
		+new String(this.getMainfields())+"\t"
		+this.getAddontable()+"\t"
		+new String(this.getAddonfields())+"\t"
		+new String(this.getForms())+"\t"
		+this.getTemplate()+"\t"
		;
	}


}
