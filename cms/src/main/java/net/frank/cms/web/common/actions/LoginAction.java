package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import net.frank.aa.service.AaService;
import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.LoginForm;
import net.frank.commons.util.StringUtil;
import net.frank.framework.security.Session;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

public class LoginAction extends BaseAction {
	
	private static final String LOGIN_ERROR_ACCOUNT_NOT_EXISTS = "aa.status.not.exists";

	private static final String LOGIN_ERROR_ACCOUNT_INCORRERT_PW = "aa.status.incorrert.pw";

	private static final String AA_SERVICE_BEAN_ID = "aaService";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		LoginForm loginForm = (LoginForm) form;
		String username = loginForm.getUserName();
		String password = loginForm.getPassword();
		AaService aaService = (AaService) getBean(AA_SERVICE_BEAN_ID);
		Session cs = new ClientSession(username, request.getRemoteAddr());
		if(StringUtil.isNotEmpty(loginForm.getPlatform())){
			((ClientSession)cs).setPlatform(loginForm.getPlatform());
		}
		if(StringUtil.isNotEmpty(loginForm.getApplication())){
			((ClientSession)cs).setApplication(loginForm.getApplication());
		}
		cs = aaService.login(cs, username, password, null);
		HttpSession httpSession = null;
		if(request.getSession(false) == null){
			httpSession = request.getSession(false);
		}else{
			httpSession = request.getSession(true);
		}
		httpSession.setAttribute("CLIENT_SESSION", cs);
		if (Session.STATUS_LOGINED.equals(cs.getStatus())) {
			AuthenticatorHolder.setClientSession((ClientSession) cs);
			return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
		} else {
			if (Session.STATUS_NOT_EXISTS.equals(cs.getStatus())) {
				actionMessages.add(CmsCommonConstants.EMPTY_STRING,
						new ActionMessage(LOGIN_ERROR_ACCOUNT_NOT_EXISTS));
			} else if (Session.STATUS_INCORRERT_PW.equals(cs.getStatus())) {
				actionMessages.add(CmsCommonConstants.EMPTY_STRING,
						new ActionMessage(LOGIN_ERROR_ACCOUNT_INCORRERT_PW));
			}
			addErrors(request, actionMessages);
			loginForm.setUserName(CmsCommonConstants.EMPTY_STRING);
			loginForm.setPassword(CmsCommonConstants.EMPTY_STRING);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}
	}
	/**
	private boolean isAdmin(Session session) {
		session.setAttribute(Session.ATTRIBUTE_KEY.IS_ADMIN, Boolean.FALSE);
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		for (Iterator<Resource> it = session.getGroups().iterator(); it
				.hasNext();) {
			Resource curr = it.next();
			if (ADMIN_GROUP_PATH.equals(queryService.getResourcePath(curr))) {
				session.setAttribute(Session.ATTRIBUTE_KEY.IS_ADMIN, Boolean.TRUE);
				return true;
			}
		}
		return false;
	}
	**/
}
