package net.frank.cms.web.core.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.CoreService;
import net.frank.cms.web.core.forms.ActivationAccountForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class SubmitActivationAccountAction extends BaseAction {

	private static final String SUCCESS_MESSAGE = "common.operate.success";
	private static final String DEFAULT_GROUP_PATH = "/group/Self";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActivationAccountForm _form = (ActivationAccountForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
		List<Resource> resourceList = _form.getResources();
		Resource defaultGroupRes = queryService
				.getResourceAsPath(DEFAULT_GROUP_PATH);
		coreService.activationAccount(resourceList, defaultGroupRes,
				getClientSession());
		ActionMessages actionMessages = new ActionMessages();
		actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				SUCCESS_MESSAGE));
		addMessages(request, actionMessages);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
