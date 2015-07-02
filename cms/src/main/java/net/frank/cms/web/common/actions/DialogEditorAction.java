package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.DialogForm;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class DialogEditorAction extends BaseAction {
	
	private static final Long IGNORE_ID = new Long(0);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DialogForm dialogForm = (DialogForm) form;
		Long resourceId = dialogForm.getResourceId();
		String elementId = dialogForm.getElementId();
		String content = CmsCommonConstants.EMPTY_STRING;
		if (resourceId != null && !IGNORE_ID.equals(resourceId)) {
			QueryService queryService = (QueryService) getService(
					request, ServiceNames.QUERY_SERVICE);
			Resource resource = queryService.getResource(resourceId);
			BaseEntity baseEnitity = queryService
					.getBo(resource.getId());
			String _elementId = elementId.substring(elementId.indexOf(".clobString(")+12,elementId.length()-1);
			log.debug("_elementId -> "+_elementId);
			content = baseEnitity.getClobString(_elementId);
		}
		request.setAttribute("content", content);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
