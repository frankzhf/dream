package net.frank.framework.bo;

public final class Application extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2428763622124255971L;
	private String appName;
	private char[] typePaths;
	private Boolean opened = Boolean.TRUE;
	private Byte layout;
	private Resource context$3 = new Resource();
	private Resource superAccount$5 = new Resource();
	private Resource parent$12 = new Resource();
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public char[] getTypePaths() {
		return typePaths;
	}
	public void setTypePaths(char[] typePaths) {
		this.typePaths = typePaths;
	}
	public Boolean getOpened() {
		return opened;
	}
	public void setOpened(Boolean opened) {
		this.opened = opened;
	}
	public Byte getLayout() {
		return layout;
	}
	public void setLayout(Byte layout) {
		this.layout = layout;
	}
	public Resource getContext$3() {
		return context$3;
	}
	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
	public Resource getSuperAccount$5() {
		return superAccount$5;
	}
	public void setSuperAccount$5(Resource superAccount$5) {
		this.superAccount$5 = superAccount$5;
	}
	public Resource getParent$12() {
		return parent$12;
	}
	public void setParent$12(Resource parent$12) {
		this.parent$12 = parent$12;
	}
	
}
