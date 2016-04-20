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
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.bo.TaskToken;
import net.frank.tasklist.web.forms.ProcessTokenForm;

public class ProcessTaskTokenAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProcessTokenForm _form = (ProcessTokenForm) form;
		QueryService queryService = (QueryService) getBean("queryService");
		Long resourceId = _form.getResourceId();
		TaskToken taskToken = (TaskToken) queryService.getBo(resourceId);
		Resource taskResource = taskToken.getTask$50002();
		Task task = (Task) queryService.getBo(taskResource.getId());
		request.setAttribute("task", task);
		request.setAttribute("taskToken", taskToken);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
