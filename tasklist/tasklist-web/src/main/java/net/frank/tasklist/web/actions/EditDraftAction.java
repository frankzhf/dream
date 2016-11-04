package net.frank.tasklist.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;
import net.frank.tasklist.bo.Task;

public class EditDraftAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		CmsForm _form = (CmsForm)form;
		Resource resource = _form.getResource();
		QueryService queryService = (QueryService)getBean("queryService");
		Task task = (Task)queryService.getBo(resource.getId());
		request.setAttribute("resource", task.getResource());
		request.setAttribute("mode", "edit");
		request.setAttribute("content", task);
		request.setAttribute("listResource", null);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
