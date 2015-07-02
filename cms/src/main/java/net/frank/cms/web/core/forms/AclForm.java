package net.frank.cms.web.core.forms;

import net.frank.framework.bo.Acl;

import org.apache.struts.action.ActionForm;

public class AclForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3415537601333473277L;
	private Acl acl = new Acl();

	public Acl getAcl() {
		return acl;
	}

	public void setAcl(Acl acl) {
		this.acl = acl;
	}
	
}
