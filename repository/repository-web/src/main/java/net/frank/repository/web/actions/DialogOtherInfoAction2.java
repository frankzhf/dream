package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSession;
import net.frank.framework.service.CmsService;
import net.frank.repository.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.web.forms.RepositoryForm;

public class DialogOtherInfoAction2  extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm) form;
		Resource srResouce = _form.getFile();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) 
				getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		srResouce = cmsService.getResource(srResouce, getClientSession());
		request.setAttribute("sharedRequest", srResouce);
		Unit unit = repositoryQueryService.getUnitForResource(srResouce);
		Resource contextRes = unit.getContext$3();
		Resource repositoryRes = cmsService.getResource(contextRes,"repository", getClientSession());
		Resource publishedRes = cmsService.getResource(repositoryRes,"published", getClientSession());
		RootSession su = new RootSession();
		request.setAttribute("su", su);
		request.setAttribute("root", publishedRes);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
