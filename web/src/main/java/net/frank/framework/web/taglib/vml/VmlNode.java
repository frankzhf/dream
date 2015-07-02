package net.frank.framework.web.taglib.vml;

import java.util.Collection;

public class VmlNode {
	private String id;			//id
	private String text;		//
	private String image;		//
	private String textColor;	//
	private String title;		//
	private String strokeColor;	//
//	private String flag;
	private String action;			//
	private long left;			//
	private long top;			//
	private long width;			//
	private long height;			//
	private long imageWidth;
	private long imageHeight;
	private long strokeWeight;	//
	private VmlNode parent;		//
	private Collection<VmlNode> children;//

	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Collection<VmlNode> getChildren() {
		return children;
	}
	public void setChildren(Collection<VmlNode> children) {
		this.children = children;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage (String image, long width, long height){
		this.image = image;
		if(width > 0)
			this.imageWidth = width;
		if(height > 0)
			this.imageHeight = height;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(long imageHeight) {
		this.imageHeight = imageHeight;
	}
	public long getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(long imageWidth) {
		this.imageWidth = imageWidth;
	}
	public long getLeft() {
		return left;
	}
	public void setLeft(long left) {
		this.left = left;
	}
	public VmlNode getParent() {
		return parent;
	}
	public void setParent(VmlNode parent) {
		this.parent = parent;
	}
	public String getStrokeColor() {
		return strokeColor;
	}
	public void setStrokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
	}
	public long getStrokeWeight() {
		return strokeWeight;
	}
	public void setStrokeWeight(long strokeWeight) {
		this.strokeWeight = strokeWeight;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getTop() {
		return top;
	}
	public void setTop(long top) {
		this.top = top;
	}
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
}
