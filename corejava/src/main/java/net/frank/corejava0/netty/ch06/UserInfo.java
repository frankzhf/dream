package net.frank.corejava0.netty.ch06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable {
	
	private String userName;
	
	private int userId;
	
	public UserInfo buildUserName(String userName) {
		this.userName = userName;
		return this;
	}
	
	public UserInfo buildUserId(int userId) {
		this.userId = userId;
		return this;
	}
	
	public final String getUserName() {
		return userName;
	}
	
	public final int getUserId() {
		return userId;
	}
	
	public  byte[] codeC() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userId);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	
	public  byte[] codeC(ByteBuffer buffer) {
		buffer.clear();
		byte[] value = this.userName.getBytes();
		buffer.putInt(value.length);
		buffer.put(value);
		buffer.putInt(this.userId);
		buffer.flip();
		value = null;
		byte[] result = new byte[buffer.remaining()];
		buffer.get(result);
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		UserInfo info = new UserInfo();
		info.buildUserId(100).buildUserName("Welcome to Netty");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(info);
		os.flush();
		os.close();
		byte[] b= bos.toByteArray();
		System.out.println("The jdk serializable length is : "+ b.length);
		bos.close();
		System.out.println("----------------------------------------------------");
		System.out.println("The byete array serializable length is : " + info.codeC().length);
		
		
	}
}
