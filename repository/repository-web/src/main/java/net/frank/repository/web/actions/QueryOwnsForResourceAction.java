package net.frank.repository.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.RootSession;
import net.frank.framework.security.Session;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.web.forms.RepositoryForm;

public class QueryOwnsForResourceAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm) form;
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		Resource file = _form.getFile();
		Resource own = _form.getStaff();
		List<Acl> aclList = null;
		if(own==null || own.getId()==null){
			aclList = repositoryQueryService.listAcl(file.getId());
		}else{
			aclList = repositoryQueryService.listAcl(file.getId(),own.getId());
		}
		request.setAttribute("aclList", aclList);
		request.setAttribute("fileResourceId", file.getId());
		Session su = new RootSession();
		request.setAttribute("su", su);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
