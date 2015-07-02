package net.frank.framework.pdfbox.model;

import java.io.Serializable;

public class PdfboxRegion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5627239265775016188L;
	private String name;
	private Integer pointX;
	private Integer pointY;
	private Integer width;
	private Integer height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPointX() {
		return pointX;
	}
	public void setPointX(Integer pointX) {
		this.pointX = pointX;
	}
	public Integer getPointY() {
		return pointY;
	}
	public void setPointY(Integer pointY) {
		this.pointY = pointY;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
}
