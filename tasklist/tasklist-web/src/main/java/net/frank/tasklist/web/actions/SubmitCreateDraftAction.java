package net.frank.tasklist.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.ResourceService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;
import net.frank.tasklist.bo.Task;
import net.frank.tasklist.service.ServiceNames;
import net.frank.tasklist.service.TasklistService;

public class SubmitCreateDraftAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TasklistService tasklistService = (TasklistService) getBean(ServiceNames.TASKLIST_SERVICE);
		ResourceService resourceService = (ResourceService) getBean(ServiceNames.RESOURCE_SERVICE);
		CmsForm _form = (CmsForm) form;
		Resource resource = _form.getResource();
		Task task = (Task) _form.getContentMap().get(resource.getTypeId());
		task.setResource(resource);
		log.debug("Task Summary:" + task.getTaskSummary());
		log.debug("Description :" + new String(task.getDescription()));
		log.debug("Unit :" + task.getUnit$14().getId());
		if (resource.getId() == null) {
			tasklistService.createDraft(task, getClientSession());
		} else {
			StringBuffer sb = new StringBuffer(256);
			sb.append(task.getTaskSummary()).append(" - Draft");
			resource.setAlias(sb.toString());
			task.setResource(resource);
			if (task.getUnit$14().getId() == null) {
				task.setUnit$14(null);
			}
			if (task.getContext$3().getId() == null) {
				task.setContext$3(null);
			}
			if (task.getRefTask$50002().getId() == null) {
				task.setRefTask$50002(null);
			}
			if (task.getParentTask$50002().getId() == null) {
				task.setParentTask$50002(null);
			}
			resourceService.saveOrUpdateBo(task, getClientSession());
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
