package net.frank.cms.web.core.forms;

import org.apache.struts.action.ActionForm;

public class MoveForm extends ActionForm {
	
	private static final long serialVersionUID = -642091768978952607L;

	private String fromPath;
	
	private String toPath;
	
	private Boolean clone = Boolean.FALSE;
	
	private Boolean recursive = Boolean.FALSE;

	public String getFromPath() {
		return fromPath;
	}

	public void setFromPath(String fromPath) {
		this.fromPath = fromPath;
	}

	public String getToPath() {
		return toPath;
	}

	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

	public Boolean getClone() {
		return clone;
	}

	public void setClone(Boolean clone) {
		this.clone = clone;
	}

	public Boolean getRecursive() {
		return recursive;
	}

	public void setRecursive(Boolean recursive) {
		this.recursive = recursive;
	}
	
	
}
