package net.frank.repository.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Acl;
import net.frank.framework.security.RootSession;
import net.frank.framework.security.Session;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;

public class MyReceivedAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ClientSession cs = getClientSession();
		Account currentAccount = cs.getAccount();
		Long aclOwnResourceId = currentAccount.getResource().getId();
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		List<Acl> aclList = repositoryQueryService
				.listAclByOwn(aclOwnResourceId);
		request.setAttribute("aclList", aclList);
		Session su = new RootSession();
		request.setAttribute("su", su);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
