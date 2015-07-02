package net.frank.dede.bean;


public class DedeSysSet extends net.frank.framework.bo.BaseEntity{


	private String sname;

	private char[] items;





	public String getSname(){
		return this.sname;
	}

	public void setSname(String sname){
		this.sname=sname;
	}

	public char[] getItems(){
		return this.items;
	}

	public void setItems(char[] items){
		this.items=items;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getSname()+"\t"
		+new String(this.getItems())+"\t"
		;
	}


}
