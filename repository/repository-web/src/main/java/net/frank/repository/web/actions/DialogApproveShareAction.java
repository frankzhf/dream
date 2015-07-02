package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.web.forms.RepositoryForm;

public class DialogApproveShareAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm) form;
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) 
				getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		Resource srResource = _form.getFile();
		Unit unit = repositoryQueryService.getUnitForResource(srResource);
		request.setAttribute("sharedRequest", srResource);
		request.setAttribute("forwordParam", "?unit.id=" +unit.getResource().getId() +"&file.id="+srResource.getId());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
