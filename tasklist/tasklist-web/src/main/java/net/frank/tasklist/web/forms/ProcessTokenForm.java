package net.frank.tasklist.web.forms;

import net.frank.framework.struts.form.CmsForm;

public class ProcessTokenForm extends CmsForm {
	
	private static final long serialVersionUID = 8828665536783599174L;
	private Long resourceId;

	public ProcessTokenForm() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		super();
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	
}
