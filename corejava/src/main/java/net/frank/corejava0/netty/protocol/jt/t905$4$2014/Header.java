package net.frank.corejava0.netty.protocol.jt.t905$4$2014;

public class Header {
	private int msgLength;
	private int msgSn;
	private short msgId;
	private int msgGnsscenterid;
	private byte[] versionFlag = new byte[3];
	private byte encryptFlag;
	private byte[] encryptKey = new byte[4];
	
	public Header(byte[] headerByteArray) {
		
	}
	
	public int getMsgLength() {
		return msgLength;
	}
	public int getMsgSn() {
		return msgSn;
	}
	public short getMsgId() {
		return msgId;
	}
	public int getMsgGnsscenterid() {
		return msgGnsscenterid;
	}
	public byte[] getVersionFlag() {
		return versionFlag;
	}
	public byte getEncryptFlag() {
		return encryptFlag;
	}
	public byte[] getEncryptKey() {
		return encryptKey;
	}
	
	
	
}
