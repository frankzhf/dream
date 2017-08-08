package net.frank.dduo.smart.core.entity;

import java.io.Serializable;

public class Device implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8203613145856537880L;
	private String gatewayId;
	private String name;
	
	public String getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Device [gatewayId=" + gatewayId + ", name=" + name + "]";
	}
}
