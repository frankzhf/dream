package net.frank.tasklist.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;

public class ViewTaskHistoryAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource resource = _form.getResource();
		TaskToken taskToken = (TaskToken) queryService.getBo(resource.getId());
		Resource taskResource = taskToken.getTask$50002();
		Task task = (Task) queryService.getBo(taskResource.getId());
		request.setAttribute("task", task);

		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
