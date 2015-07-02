package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.AclForm;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class ListAclAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AclForm _form = (AclForm) form;
		Long resourceId = _form.getAcl().getResourceId();
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		request.setAttribute("aclListInfo",
				queryService.listAcl(resourceId));
		request.setAttribute("acl",
				_form.getAcl());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}