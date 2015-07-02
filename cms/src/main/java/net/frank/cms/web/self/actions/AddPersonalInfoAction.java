package net.frank.cms.web.self.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.SelfService;
import net.frank.framework.struts.action.BaseAction;

public class AddPersonalInfoAction extends BaseAction {
	
	private static final String SELF_SERVICE_BEAN_ID = "selfService";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SelfService selfService = (SelfService) getBean(SELF_SERVICE_BEAN_ID);
		selfService.addPersonalInfo(getClientSession());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
