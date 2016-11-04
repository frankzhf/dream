package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.struts.action.BaseAction;

public class PreparedSuperUserAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Session su = RootSessionHolder.getDefaultRootSession();
		request.setAttribute("su", su);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
