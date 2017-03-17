package net.frank.titian.define;

import java.io.Serializable;

public class AntResult implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6646701312603010270L;

	public int status;
	
	public String content;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "HttpResult [status=" + status + ", content=" + content + "]";
	}
	
	
	
}
