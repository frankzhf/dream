package net.frank.cms.web.core.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

public class EditInformDetailsAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		QueryService queryService = (QueryService) getService(request,
				ServiceNames.QUERY_SERVICE);
		Resource resource = queryService.getResource(_form.getResource()
				.getId());
		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		if (!permissionService.checkWritePermission(resource,
				getClientSession())) {
			request.setAttribute(
					CmsCommonConstants.CHECK_PERMISSION.REQUEST_ATTRIBLE_KEY,
					CmsCommonConstants.CHECK_PERMISSION.FAILURE);
		} else {
			List<Resource> list = null;
			BaseEntity content = null;
			if (CmsCommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
				log.debug("Content is Resource ->" + resource.getId());
				list = queryService.retrieveResourceByParent(resource.getId());
			} else {
				content = queryService.getBo(resource.getId());
				log.debug("Content Class ->" + content.getClass().getName());
			}
			permissionService.fillForm(resource, _form);
			_form.setResource(resource);
			_form.setListResource(list);
			request.setAttribute("resource", resource);
			request.setAttribute("mode", CmsCommonConstants.PAGE_MODE.EDIT);
			request.setAttribute("content", content);
			request.setAttribute("listResource", list);
			log.debug("Result [_form.resource] -> " + _form.getResource());
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
