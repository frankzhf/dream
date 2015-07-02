package net.frank.framework.struts.form;

import net.frank.framework.bo.Resource;

import org.apache.struts.action.ActionForm;

public class FlowForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9112353644457251553L;
	private Resource piRoot = new Resource();
	
	public void setPiRoot(Resource piRoot) {
		this.piRoot = piRoot;
	}
	public Resource getPiRoot() {
		return piRoot;
	}
	
}
