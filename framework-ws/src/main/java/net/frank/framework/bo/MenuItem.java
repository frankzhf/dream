package net.frank.framework.bo;

public final class MenuItem extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6657667919300866928L;
	private String name;
	private String title;
	private String target;
	private String path;
	private String visitImpl;
	private Resource children$3=new Resource();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getVisitImpl() {
		return visitImpl;
	}
	public void setVisitImpl(String visitImpl) {
		this.visitImpl = visitImpl;
	}
	public Resource getChildren$3() {
		return children$3;
	}
	public void setChildren$3(Resource children$3) {
		this.children$3 = children$3;
	}
}
