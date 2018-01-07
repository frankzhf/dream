package net.frank.corejava0.netty.protocol.jt.t905$4$2014;

public class Message {
	
	private Header header;
	
	private Body body;
	
	private byte[] crc16 = new byte[2];

	public Message(byte[] msgByteArray) {
		
	}
	
	public Header getHeader() {
		return header;
	}

	public Body getBody() {
		return body;
	}

	public byte[] getCrc16() {
		return crc16;
	}
	
	
	
}
