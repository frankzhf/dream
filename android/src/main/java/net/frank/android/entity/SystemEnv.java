package net.frank.android.entity;

public class SystemEnv extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1841575425371254921L;
	
	private String envName;
	
	private String envValue;


	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getEnvValue() {
		return envValue;
	}

	public void setEnvValue(String envValue) {
		this.envValue = envValue;
	}
}