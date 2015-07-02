package net.frank.cms.web.admin.forms;

import net.frank.framework.struts.form.CmsForm;

public class GrantUnitGroupForm extends CmsForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -527291934155141612L;
	
	public GrantUnitGroupForm() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		super();
	}
	
	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
	
}
