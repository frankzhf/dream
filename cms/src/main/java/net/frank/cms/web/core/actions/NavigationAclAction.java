package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.AclForm;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class NavigationAclAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AclForm _form = (AclForm) form;
		Acl acl = _form.getAcl();
		QueryService queryService = (QueryService) getService(request,
				ServiceNames.QUERY_SERVICE);
		if(acl!=null && acl.getId()!=null){
			acl = queryService.getAcl(acl.getId());
			Resource own = queryService.getResource(acl.getOwnId());
			String selectedLinkList = queryService.getNodePath(own);
			log.debug("selectedLinkList ->" + selectedLinkList);
			request.setAttribute("acl", acl);
			request.setAttribute("selectedLinkList", selectedLinkList);
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
