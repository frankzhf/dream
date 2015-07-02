package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.aa.service.AaService;
import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class LogoutAction extends BaseAction {
	
	private static final String AA_SERVICE_BEAN_ID = "aaService";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		log.debug("Logout...BEG");
		ClientSession cs = getClientSession();
		if(cs!=null){
			AaService aaService = (AaService) getBean(AA_SERVICE_BEAN_ID);
			aaService.logout(getClientSession());
		}
		request.getSession(false).removeAttribute("CLIENT_SESSION");
		log.debug("Logout...END");
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}