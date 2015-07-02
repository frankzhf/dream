package net.frank.repository.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.CommonConstants;
import net.frank.framework.app.ApplicationTemplate;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.CmsService;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.web.forms.RepositoryForm;

public class ListFileAction extends BaseAction {

	private static final String PATH_SELF = "/group/Self";
	private static final String PATH_REPOSITORY = "repository";
	private static final String PATH_PENDING = "pending";
	private static final String PATH_ARCHIVE = "archive";
	private static final String DEFAULT_APP = "defaultApp";

	private static Resource groupSelfRes = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) SpringContextUtil
				.getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		ApplicationTemplate application = (ApplicationTemplate) SpringContextHolder
				.getApplicationContext().getBean(DEFAULT_APP);
		RepositoryForm _form = (RepositoryForm) form;
		Resource folder = _form.getFolder();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		folder = cmsService.getResource(folder, getClientSession());
		_form.setFolder(folder);
		request.setAttribute("folder", folder);
		// process Current Unit
		if (groupSelfRes == null) {
			groupSelfRes = cmsService.getResource(PATH_SELF,
					application.getSuperUserClientSession());
		}
		if (!groupSelfRes.getId().equals(folder.getOwnGroupResourceId())) {
			Unit currUnit = repositoryQueryService.getUnitForResource(folder);
			if (currUnit != null) {
				Resource currentUnitContext = currUnit.getContext$3();
				Resource currRepositoryRes = cmsService
						.getResource(currentUnitContext, PATH_REPOSITORY,
								getClientSession());
				Resource currPendingRes = cmsService.getResource(
						currRepositoryRes, PATH_PENDING, getClientSession());
				if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(currPendingRes
						.getCode())) {
					request.setAttribute("isPublisher", Boolean.TRUE);
					request.setAttribute("publisherFolder", currPendingRes);
				}
				Resource currArchiveRes = cmsService.getResource(
						currRepositoryRes, PATH_ARCHIVE, getClientSession());
				if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(currArchiveRes
						.getCode())) {
					request.setAttribute("isAdmin", Boolean.TRUE);
					request.setAttribute("archiveFolder", currArchiveRes);
				}
			}
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}