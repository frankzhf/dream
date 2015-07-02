package net.frank.dede.bean;


public class DedePayment extends net.frank.framework.bo.BaseEntity{


	private String code;

	private String name;

	private String fee;

	private char[] description;

	private Byte rank;

	private char[] config;

	private Boolean enabled;

	private Boolean cod;

	private Boolean online;





	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code=code;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getFee(){
		return this.fee;
	}

	public void setFee(String fee){
		this.fee=fee;
	}

	public char[] getDescription(){
		return this.description;
	}

	public void setDescription(char[] description){
		this.description=description;
	}

	public Byte getRank(){
		return this.rank;
	}

	public void setRank(Byte rank){
		this.rank=rank;
	}

	public char[] getConfig(){
		return this.config;
	}

	public void setConfig(char[] config){
		this.config=config;
	}

	public Boolean getEnabled(){
		return this.enabled;
	}

	public void setEnabled(Boolean enabled){
		this.enabled=enabled;
	}

	public Boolean getCod(){
		return this.cod;
	}

	public void setCod(Boolean cod){
		this.cod=cod;
	}

	public Boolean getOnline(){
		return this.online;
	}

	public void setOnline(Boolean online){
		this.online=online;
	}





	public String toString(){
		return ""
		+this.getId()+"\t"
		+this.getCode()+"\t"
		+this.getName()+"\t"
		+this.getFee()+"\t"
		+new String(this.getDescription())+"\t"
		+this.getRank()+"\t"
		+new String(this.getConfig())+"\t"
		+this.getEnabled()+"\t"
		+this.getCod()+"\t"
		+this.getOnline()+"\t"
		;
	}


}
