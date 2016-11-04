package net.frank.dede.bean;


public class DedeArcmulti extends net.frank.framework.bo.BaseEntity{


	private String tagid;

	private Integer uptime;

	private String innertext;

	private Integer pagesize;

	private char[] arcids;

	private String ordersql;

	private String addfieldssql;

	private String addfieldssqljoin;

	private char[] attstr;





	public String getTagid(){
		return this.tagid;
	}

	public void setTagid(String tagid){
		this.tagid=tagid;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}

	public String getInnertext(){
		return this.innertext;
	}

	public void setInnertext(String innertext){
		this.innertext=innertext;
	}

	public Integer getPagesize(){
		return this.pagesize;
	}

	public void setPagesize(Integer pagesize){
		this.pagesize=pagesize;
	}

	public char[] getArcids(){
		return this.arcids;
	}

	public void setArcids(char[] arcids){
		this.arcids=arcids;
	}

	public String getOrdersql(){
		return this.ordersql;
	}

	public void setOrdersql(String ordersql){
		this.ordersql=ordersql;
	}

	public String getAddfieldssql(){
		return this.addfieldssql;
	}

	public void setAddfieldssql(String addfieldssql){
		this.addfieldssql=addfieldssql;
	}

	public String getAddfieldssqljoin(){
		return this.addfieldssqljoin;
	}

	public void setAddfieldssqljoin(String addfieldssqljoin){
		this.addfieldssqljoin=addfieldssqljoin;
	}

	public char[] getAttstr(){
		return this.attstr;
	}

	public void setAttstr(char[] attstr){
		this.attstr=attstr;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTagid()+"\t"
		+this.getUptime()+"\t"
		+this.getInnertext()+"\t"
		+this.getPagesize()+"\t"
		+new String(this.getArcids())+"\t"
		+this.getOrdersql()+"\t"
		+this.getAddfieldssql()+"\t"
		+this.getAddfieldssqljoin()+"\t"
		+new String(this.getAttstr())+"\t"
		;
	}


}
