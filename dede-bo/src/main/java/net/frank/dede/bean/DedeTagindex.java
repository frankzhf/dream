package net.frank.dede.bean;


public class DedeTagindex extends net.frank.framework.bo.BaseEntity{


	private String tag;

	private Integer typeid;

	private Integer count;

	private Integer total;

	private Integer weekcc;

	private Integer monthcc;

	private Integer weekup;

	private Integer monthup;

	private Integer addtime;





	public String getTag(){
		return this.tag;
	}

	public void setTag(String tag){
		this.tag=tag;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setTypeid(Integer typeid){
		this.typeid=typeid;
	}

	public Integer getCount(){
		return this.count;
	}

	public void setCount(Integer count){
		this.count=count;
	}

	public Integer getTotal(){
		return this.total;
	}

	public void setTotal(Integer total){
		this.total=total;
	}

	public Integer getWeekcc(){
		return this.weekcc;
	}

	public void setWeekcc(Integer weekcc){
		this.weekcc=weekcc;
	}

	public Integer getMonthcc(){
		return this.monthcc;
	}

	public void setMonthcc(Integer monthcc){
		this.monthcc=monthcc;
	}

	public Integer getWeekup(){
		return this.weekup;
	}

	public void setWeekup(Integer weekup){
		this.weekup=weekup;
	}

	public Integer getMonthup(){
		return this.monthup;
	}

	public void setMonthup(Integer monthup){
		this.monthup=monthup;
	}

	public Integer getAddtime(){
		return this.addtime;
	}

	public void setAddtime(Integer addtime){
		this.addtime=addtime;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getTag()+"\t"
		+this.getTypeid()+"\t"
		+this.getCount()+"\t"
		+this.getTotal()+"\t"
		+this.getWeekcc()+"\t"
		+this.getMonthcc()+"\t"
		+this.getWeekup()+"\t"
		+this.getMonthup()+"\t"
		+this.getAddtime()+"\t"
		;
	}


}
