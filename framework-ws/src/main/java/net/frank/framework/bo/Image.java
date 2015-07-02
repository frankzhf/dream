package net.frank.framework.bo;

public final class Image extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -668547321358775947L;
	private String imageName;
	private byte[] content;
	private String imageFormat;
	private Resource context$3=new Resource();
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageFormat() {
		return imageFormat;
	}
	public void setImageFormat(String imageFormat) {
		this.imageFormat = imageFormat;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public byte[] getContent() {
		return content;
	}
	public Resource getContext$3() {
		return context$3;
	}
	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
}