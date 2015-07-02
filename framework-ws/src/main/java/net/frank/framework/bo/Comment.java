package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;

public class Comment extends BusinessObject {
	
	private static final long serialVersionUID = 5314318592077190272L;
	
	private char[] text;
	
	public char[] getText() {
		return text;
	}
	
	public void setText(char[] text) {
		this.text = text;
	}
	
}
