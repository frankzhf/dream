package net.frank.cms.common.layout;

public class Section implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7991022843163502014L;
	private String title;
	private String link;
	private int height;
	private int width;
	private boolean split=false;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public boolean isSplit() {
		return split;
	}
	public void setSplit(boolean split) {
		this.split = split;
	}
	
}
