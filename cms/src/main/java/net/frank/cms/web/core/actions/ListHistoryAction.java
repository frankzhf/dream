package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.HistoryForm;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListHistoryAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HistoryForm _form = (HistoryForm) form;
		Long resourceId = _form.getSystemHistory().getResourceId();
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		request.setAttribute("historyInfo",
				queryService.listSystemHistory(resourceId));
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
