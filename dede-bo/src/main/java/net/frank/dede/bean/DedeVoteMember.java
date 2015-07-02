package net.frank.dede.bean;


public class DedeVoteMember extends net.frank.framework.bo.BaseEntity{


	private Integer voteid;

	private String userid;

	private Integer uptime;





	public Integer getVoteid(){
		return this.voteid;
	}

	public void setVoteid(Integer voteid){
		this.voteid=voteid;
	}

	public String getUserid(){
		return this.userid;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}

	public Integer getUptime(){
		return this.uptime;
	}

	public void setUptime(Integer uptime){
		this.uptime=uptime;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getVoteid()+"\t"
		+this.getUserid()+"\t"
		+this.getUptime()+"\t"
		;
	}


}
