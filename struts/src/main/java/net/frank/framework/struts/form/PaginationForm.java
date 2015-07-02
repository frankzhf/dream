package net.frank.framework.struts.form;

import org.apache.struts.action.ActionForm;

import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.dao.paginator.PaginatorData;

public class PaginationForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5933924354099304538L;
	
	private PaginatorData paginatorData;

	public PaginatorData getPaginatorData() {
		if (paginatorData == null) {
			paginatorData = (PaginatorData) SpringContextHolder.getApplicationContext()
					.getBean(PaginatorData.SPRING_BEAN_ID);
		}
		return paginatorData;
	}

	public void setPaginatorData(PaginatorData paginatorData) {
		this.paginatorData = paginatorData;
	}

}
