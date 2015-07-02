package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.AclForm;
import net.frank.framework.struts.action.BaseAction;

public class DialogAclAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AclForm _form = (AclForm)form;
		if(_form.getAcl()!=null && _form.getAcl().getId() != null){
			request.setAttribute("forwordParam", "?acl.id="+_form.getAcl().getId() +"&" +Math.random());
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
