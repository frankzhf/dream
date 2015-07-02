package net.frank.cms.web.core.forms;

import net.frank.framework.bo.SystemHistory;

import org.apache.struts.action.ActionForm;

public class HistoryForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6662413986500545559L;
	private SystemHistory systemHistory = new SystemHistory();

	public SystemHistory getSystemHistory() {
		return systemHistory;
	}

	public void setSystemHistory(SystemHistory systemHistory) {
		this.systemHistory = systemHistory;
	}
	
	
	
}
