package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;

public final class Article extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2205118125477389726L;
	private String title;
	private String keyWord; 
	private char[] content;
	private Resource context$3=new Resource();
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public void setContent(char[] content) {
		this.content = content;
	}
	public char[] getContent() {
		return content;
	}
	public Resource getContext$3() {
		return context$3;
	}
	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
	
}
