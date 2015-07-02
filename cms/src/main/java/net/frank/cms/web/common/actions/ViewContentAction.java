package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewContentAction extends BaseAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm rForm = (CmsForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Long resourceId = rForm.getResource().getId();
		log.debug("Current Resource's Id:"+resourceId);
		Resource resource  = queryService.getResource(resourceId);
		BusinessObject content = queryService.getBo(resource.getId());
		content.setResource(resource);
		rForm.setResource(resource);
		request.setAttribute("resource", resource);
		request.setAttribute("content", content);
		String name = content.getClass().getName().substring(content.getClass().getName().lastIndexOf(CommonConstants.POINT)+1);
		request.setAttribute("templateName", name+".html");
		request.setAttribute("resourceName", name);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
