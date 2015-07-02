package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.web.forms.RepositoryForm;

public class ShareFileAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm)form;
		Resource _resource = _form.getFile();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		_resource = cmsService.getResource(_resource, getClientSession());
		request.setAttribute("shareFile", _resource);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
