package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.RootSession;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.web.forms.RepositoryForm;

public class PendingForUnitAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm) form;
		Resource folder = _form.getFolder();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		folder = cmsService.getResource(folder, getClientSession());
		_form.setFolder(folder);
		request.setAttribute("folder", folder);
		Session su = new RootSession();
		request.setAttribute("su", su);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
