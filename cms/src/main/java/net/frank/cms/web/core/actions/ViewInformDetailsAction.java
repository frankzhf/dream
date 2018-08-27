package net.frank.cms.web.core.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewInformDetailsAction extends BaseAction{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		Resource paramResource = _form.getResource();
		Long id= paramResource.getId();
		if(id==null || id == 0L){
			Long parentId = paramResource.getParentId();
			id = parentId;
		}
		QueryService queryService = (QueryService)getBean(ServiceNames.QUERY_SERVICE);
		//CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		Resource resource = new Resource();
		resource.setId(id);
		resource = queryService.getResource(resource.getId());
		if (!permissionService.checkReadPermission(resource, getClientSession())) {
			request.setAttribute(
					CmsCommonConstants.CHECK_PERMISSION.REQUEST_ATTRIBLE_KEY,
					CmsCommonConstants.CHECK_PERMISSION.FAILURE);
		}else{
			List<Resource> list = null;
			BaseEntity content = null;
			if(CmsCommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
				log.debug("Content is Resource ->" + resource.getId());
				list = queryService.retrieveResourceByParent(resource.getId());
				list = permissionService.filterList(list, getClientSession());
			}else{
				content = queryService.getBo(resource.getId());
				log.debug("Content Class ->" + content.getClass().getName());
			}
			permissionService.fillForm(resource, _form);
			_form.setResource(resource);
			_form.setListResource(list);
			request.setAttribute("resource", resource);
			request.setAttribute("mode", CmsCommonConstants.PAGE_MODE.VIEW);
			request.setAttribute("content", content);
			request.setAttribute("listResource", list);
			log.debug("Result [_form.resource] -> " + _form.getResource());
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}