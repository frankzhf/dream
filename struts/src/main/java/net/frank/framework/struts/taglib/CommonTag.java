package net.frank.framework.struts.taglib;

import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.web.security.ClientSession;

import org.apache.struts.Globals;

public abstract class CommonTag extends TagSupport implements Constants {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360180401839260444L;

	protected Resource menuRepository;

	protected String bundle = null;

	protected String localeKey = Globals.LOCALE_KEY;

	public void setMenuRepository(Resource menuRepository) {
		this.menuRepository = menuRepository;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}

	public void release() {
		super.release();
		this.bundle = null;
		this.localeKey = null;
		this.menuRepository = null;
	}

	protected Boolean checkRunPermission(Resource menuItem, ClientSession cs) {
		PermissionService permissionService = (PermissionService) SpringContextHolder
				.getApplicationContext().getBean(
						ServiceNames.PERMISSION_SERVICE);
		return permissionService.checkRunPermission(menuItem, cs);
	}
}
