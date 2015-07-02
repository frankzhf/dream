package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;

public final class Attach extends BusinessObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2370032985813800226L;
	private String fileName;
	private byte[] content;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public byte[] getContent() {
		return content;
	}
	
	
}
