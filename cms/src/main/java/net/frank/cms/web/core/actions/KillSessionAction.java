package net.frank.cms.web.core.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.ListSessionForm;
import net.frank.cms.web.core.forms.vo.SessionView;
import net.frank.framework.security.Session;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.security.SessionTableHolder;

public class KillSessionAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ListSessionForm _form = (ListSessionForm) form;
		List<SessionView> sessionViewList = _form.getSessionViewList();
		for(int i=0;i<sessionViewList.size();i++){
			SessionView curr = sessionViewList.get(i);
			if(curr.getSelected()){
				ClientSession deleteCs =SessionTableHolder.getClientSession(curr.getLoginName(), curr.getClientIp());
				if(deleteCs !=null){
					log.debug("remove clientSession :" + curr) ;
					HttpSession httpSession= deleteCs.getWebSession();
					deleteCs.setStatus(Session.STATUS_INITIAL);
					httpSession.removeAttribute("CLIENT_SESSION");
				}
			}
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
