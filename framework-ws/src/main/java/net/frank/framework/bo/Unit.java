package net.frank.framework.bo;

public final class Unit extends BusinessObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3073477164847068433L;
	
	private static final String ICON_PATH = "/global/images/xloadtree2b/department_icon.jpg";

	private String unitName;
	
	private String unitCode;
	
	private String description;
	
	private String taskSeqName;
	
	private Resource manager$16=new Resource();
	
	private Resource own$5=new Resource();
	
	private Resource group$6=new Resource();
	
	private Resource context$3=new Resource();

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public String getUnitCode(){
		return unitCode;
	}
	
	public void setUnitCode(String unitCode){
		this.unitCode = unitCode;
	}

	public String getDescription() {
		return description;
	}
	
	public void setTaskSeqName(String taskSeqName) {
		this.taskSeqName = taskSeqName;
	}

	public String getTaskSeqName() {
		return taskSeqName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Resource getManager$16() {
		return manager$16;
	}

	public void setManager$16(Resource manager$16) {
		this.manager$16 = manager$16;
	}
	
	public Resource getOwn$5() {
		return own$5;
	}

	public void setOwn$5(Resource own$5) {
		this.own$5 = own$5;
	}

	public void setGroup$6(Resource group$6) {
		this.group$6 = group$6;
	}

	public Resource getGroup$6() {
		return group$6;
	}

	public Resource getContext$3() {
		return context$3;
	}

	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
	
	@Override
	public String getNodeIcon() {
		return ICON_PATH;
	}
	
	@Override
	public String getNodeOpenIcon() {
		return ICON_PATH;
	}
}
