package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CreateBusinessObjectAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		Resource resource = _form.getResource();
		Long parentId = resource.getParentId();
		Long typeId = resource.getTypeId();
		resource.setActive(Boolean.TRUE);
		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		
		Resource parent = new Resource();
		parent.setId(parentId);
		parent = cmsService.getResource(parent, getClientSession());
		
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(parent.getCode())) {
			request.setAttribute(
					CmsCommonConstants.CHECK_PERMISSION.REQUEST_ATTRIBLE_KEY,
					CmsCommonConstants.CHECK_PERMISSION.FAILURE);
		} else {
			request.setAttribute(
					CmsCommonConstants.CHECK_PERMISSION.REQUEST_ATTRIBLE_KEY,
					CmsCommonConstants.CHECK_PERMISSION.SUCCESS);
			String umask = getClientSession().getAccount().getUmask();
			Byte currentUserPermission = Integer.decode(umask
					.substring(0, 1)).byteValue();
			Byte currentGroupPermission = Integer.decode(umask.substring(1,
					2)).byteValue();
			Byte otherPermission = Integer.decode(umask.substring(2, 3)).byteValue();
			resource.setCurrentAccountPermission(currentUserPermission);
			resource.setCurrentGroupPermission(currentGroupPermission);
			resource.setOthersPermission(otherPermission);
			permissionService.fillForm(resource, _form);
			BusinessObject content = null;
			if (CmsCommonConstants.TYPE.RESOURCE.equals(typeId)) {
				content = null;
			} else {
				content = (BusinessObject) _form.getContentMap().get(typeId);
			}
			resource.setOwnResourceId(getClientSession().getAccount()
					.getResource().getId());
			resource.setOwnGroupResourceId(getClientSession().getCurrentGroup()
					.getResource().getId());
			if (content != null) {
				content.setResource(resource);
			}
			_form.setResource(resource);
			_form.setListResource(null);
			request.setAttribute("resource", resource);
			request.setAttribute("mode", CmsCommonConstants.PAGE_MODE.EDIT);
			request.setAttribute("content", content);
			request.setAttribute("listResource", null);
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
