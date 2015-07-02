package net.frank.cms.common.layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.struts.action.BaseAction;

public abstract class JQueryEasyuiLayoutAction extends BaseAction{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Layout layout = new Layout();
		processLayout(layout,form,request,response);
		request.setAttribute("layout", layout);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}	
	public abstract void processLayout(Layout layout,ActionForm form,
			HttpServletRequest request, HttpServletResponse response);
	
}
