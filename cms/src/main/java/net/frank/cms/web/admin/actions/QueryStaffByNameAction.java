package net.frank.cms.web.admin.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.admin.forms.GrantUnitGroupForm;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class QueryStaffByNameAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GrantUnitGroupForm _form = (GrantUnitGroupForm) form;
		Resource param = _form.getResource();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource group = cmsService.getResource(param, getClientSession());
		Resource groupFolder = new Resource();
		groupFolder.setId(group.getParentId());
		groupFolder = cmsService.getResource(groupFolder, getClientSession());
		Resource unitContextRes = new Resource();
		unitContextRes.setId(groupFolder.getParentId());
		unitContextRes = cmsService.getResource(unitContextRes,
				getClientSession());
		Resource grantFolder = cmsService.getResource(unitContextRes,
				CommonConstants.CONTEXT.UNIT.GRANT, getClientSession());
		request.setAttribute("group", group);
		request.setAttribute("grantFolder", grantFolder);
		request.setAttribute("staffName", _form.getStaffName());
		Session su = RootSessionHolder.getDefaultRootSession();
		request.setAttribute("su", su);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
