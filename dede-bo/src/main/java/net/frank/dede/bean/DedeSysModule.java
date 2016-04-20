package net.frank.dede.bean;


public class DedeSysModule extends net.frank.framework.bo.BaseEntity{


	private String hashcode;

	private String modname;

	private String indexname;

	private String indexurl;

	private Byte ismember;

	private char[] menustring;





	public String getHashcode(){
		return this.hashcode;
	}

	public void setHashcode(String hashcode){
		this.hashcode=hashcode;
	}

	public String getModname(){
		return this.modname;
	}

	public void setModname(String modname){
		this.modname=modname;
	}

	public String getIndexname(){
		return this.indexname;
	}

	public void setIndexname(String indexname){
		this.indexname=indexname;
	}

	public String getIndexurl(){
		return this.indexurl;
	}

	public void setIndexurl(String indexurl){
		this.indexurl=indexurl;
	}

	public Byte getIsmember(){
		return this.ismember;
	}

	public void setIsmember(Byte ismember){
		this.ismember=ismember;
	}

	public char[] getMenustring(){
		return this.menustring;
	}

	public void setMenustring(char[] menustring){
		this.menustring=menustring;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getHashcode()+"\t"
		+this.getModname()+"\t"
		+this.getIndexname()+"\t"
		+this.getIndexurl()+"\t"
		+this.getIsmember()+"\t"
		+new String(this.getMenustring())+"\t"
		;
	}


}
