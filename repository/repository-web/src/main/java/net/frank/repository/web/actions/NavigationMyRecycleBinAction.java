package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.repository.CommonConstants;
import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;

public class NavigationMyRecycleBinAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		ClientSession cs = getClientSession();
		cs.getAccount().getLoginName();
		sb.append(CommonConstants.PATH.HOME)
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.POINT)
				.append(cs.getAccount().getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.CONTEXT.ACCOUNT.RECYCLE_BIN);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource myRecycleBinRes = cmsService.getResource(sb.toString(), cs);
		request.setAttribute("myRecycleBin", myRecycleBinRes);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
