package net.frank.tasklist.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;
import net.frank.tasklist.CommonConstants;

public class CreateDraftAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		StringBuffer parentPath = new StringBuffer(256);
		parentPath.append(CommonConstants.PATH_SYMBOL).
			append(CommonConstants.RESOURCE_ALIAS.HOME_ROOT).
			append(CommonConstants.PATH_SYMBOL).
			append(CommonConstants.POINT).
			append(getClientSession().getLoginName()).
			append(CommonConstants.PATH_SYMBOL).
			append(CommonConstants.USER_WORKSPACE_ROOT_ALIAS).
			append(CommonConstants.PATH_SYMBOL).
			append(CommonConstants.USER_WORKSPACE_DRAFT);
		log.debug("Current My Draft Path:" + parentPath.toString());
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource parent = queryService.getResourceAsPath(parentPath.toString());
		Resource resource = _form.getResource();
		resource.setParentId(parent.getId());
		resource.setTypeId(CommonConstants.TYPE.TASK);
		resource.setChildren(null);
		resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resource.setOwnResourceId(getClientSession().getAccount().getResource()
				.getId());
		resource.setOwnGroupResourceId(getClientSession().getCurrentGroup()
				.getResource().getId());
		resource.setActive(Boolean.TRUE);
		BusinessObject content = null;
		content = (BusinessObject) _form.getContentMap().get(
				CommonConstants.TYPE.TASK);
		content.setResource(resource);
		_form.setListResource(null);
		request.setAttribute("resource", resource);
		request.setAttribute("mode", "edit");
		request.setAttribute("content", content);
		request.setAttribute("listResource", null);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
