package net.frank.framework.bo;

public abstract class Dictionary extends BusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8211365201535008663L;

	private String codeId;
	
	private String codeDesc;
	
	private Resource children$3=new Resource();

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public Resource getChildren$3() {
		return children$3;
	}

	public void setChildren$3(Resource children$3) {
		this.children$3 = children$3;
	}
	
	
}
