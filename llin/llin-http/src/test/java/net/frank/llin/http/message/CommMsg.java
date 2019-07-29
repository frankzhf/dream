package net.frank.llin.http.message;

import java.io.Serializable;

public class CommMsg implements Serializable {
	
	public interface MsgType{
		byte SESSEION = 0;
		byte WHOAMI = 1;
		byte UPDATE_CLIENT = 2;
		byte CALL = 3;
		byte JOIN = 4;
		byte END = 5;
		
		byte EXCEPTION = -127;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7837640197530944121L;

	private byte type;
	
	private String json;

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "CommMsg [type=" + type + ", json=" + json + "]";
	}
	
}
