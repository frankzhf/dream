package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.AuthenticatorHolder;

public class DashboardAction extends BaseAction {
	
	private static final String WELCOME_MESSAGE = "common.message.welcome";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
				new ActionMessage(WELCOME_MESSAGE, AuthenticatorHolder.getClientSession().getLoginName()));
		addMessages(request, actionMessages);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
