package net.frank.repository.bo;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

public class SharedRequest extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5783387989754310214L;
	
	public static final String ACTION_CREATE = "C";
	
	public static final String ACTION_DELETE = "D";
	
	public static final String RESULT_REJECT = "R";
	
	public static final String RESULT_APPROV = "A";
	
	private char[] text;
	
	private String action;
	
	private String result;
	
	private Resource moveTo$3 = new Resource();
	
	private Resource file$50000 = new Resource();

	public char[] getText() {
		return text;
	}

	public void setText(char[] text) {
		this.text = text;
	}

	public Resource getFile$50000() {
		return file$50000;
	}

	public void setFile$50000(Resource file$50000) {
		this.file$50000 = file$50000;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Resource getMoveTo$3() {
		return moveTo$3;
	}

	public void setMoveTo$3(Resource moveTo$3) {
		this.moveTo$3 = moveTo$3;
	}

	
}
