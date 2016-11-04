package net.frank.cms.web.core.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.vo.SessionView;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.security.SessionTableHolder;

public class ListSessionAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<ClientSession> list =SessionTableHolder.getClientSessionList();
		List<SessionView> sessionViewList = new ArrayList<SessionView>();
		for(Iterator<ClientSession> it=list.iterator();it.hasNext();){
			ClientSession curr = it.next();
			SessionView sv = new SessionView();
			sv.setClientIp(curr.getClientIP());
			sv.setLoginName(curr.getLoginName());
			sv.setPlatform(curr.getPlatform());
			sv.setApplication(curr.getApplication());
			sv.setPrevRequestTime(curr.getPrevRequestTime() ==null ? curr.getLoginTime() : curr.getPrevRequestTime());
			sessionViewList.add(sv);
		}
		request.setAttribute("sessionViewList", sessionViewList);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
