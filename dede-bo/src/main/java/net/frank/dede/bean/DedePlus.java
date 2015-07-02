package net.frank.dede.bean;


public class DedePlus extends net.frank.framework.bo.BaseEntity{


	private Integer aid;

	private String plusname;

	private String menustring;

	private String mainurl;

	private String writer;

	private Integer isshow;

	private char[] filelist;





	public Integer getAid(){
		return this.aid;
	}

	public void setAid(Integer aid){
		this.aid=aid;
	}

	public String getPlusname(){
		return this.plusname;
	}

	public void setPlusname(String plusname){
		this.plusname=plusname;
	}

	public String getMenustring(){
		return this.menustring;
	}

	public void setMenustring(String menustring){
		this.menustring=menustring;
	}

	public String getMainurl(){
		return this.mainurl;
	}

	public void setMainurl(String mainurl){
		this.mainurl=mainurl;
	}

	public String getWriter(){
		return this.writer;
	}

	public void setWriter(String writer){
		this.writer=writer;
	}

	public Integer getIsshow(){
		return this.isshow;
	}

	public void setIsshow(Integer isshow){
		this.isshow=isshow;
	}

	public char[] getFilelist(){
		return this.filelist;
	}

	public void setFilelist(char[] filelist){
		this.filelist=filelist;
	}





	public String toString(){
		return ""
		+this.getAid()+"\t"
		+this.getPlusname()+"\t"
		+this.getMenustring()+"\t"
		+this.getMainurl()+"\t"
		+this.getWriter()+"\t"
		+this.getIsshow()+"\t"
		+new String(this.getFilelist())+"\t"
		;
	}


}
