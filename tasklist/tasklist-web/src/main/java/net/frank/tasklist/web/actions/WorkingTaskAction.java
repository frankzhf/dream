package net.frank.tasklist.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

public class WorkingTaskAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm) form;
		Resource resource = _form.getResource();
		request.setAttribute("resource", resource);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
