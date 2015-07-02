package net.frank.repository.web.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSession;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.web.security.ClientSession;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;

public class ShareFileToProjectAction extends BaseAction {
	
	private static final String PATH_REPOSITORY = "repository";
	private static final String PATH_PENDING = "pending";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService)
				getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		CmsService cmsService = (CmsService) 
				getBean(ServiceNames.CMS_SERVICE);
		PermissionService permissionService = (PermissionService)getBean(ServiceNames.PERMISSION_SERVICE);
				
		List<Long> unitResourceIdList = repositoryQueryService.listAllUnit();
		List<Resource> unitResourceList = new ArrayList<Resource>();
		Session su = new RootSession();
		ClientSession cs = getClientSession();
		for(Iterator<Long> it=unitResourceIdList.iterator();it.hasNext();){
			Long unitResourceId = it.next();
			Resource cuuUnitRes = new Resource();
			cuuUnitRes.setId(unitResourceId);
			cuuUnitRes = cmsService.getResource(cuuUnitRes, cs);
			if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(cuuUnitRes.getCode())){
				Unit currUnit = (Unit)cuuUnitRes.getObject();
				Resource currUnitContext = currUnit.getContext$3();
				Resource currRepositoryRes = cmsService.getResource(currUnitContext, PATH_REPOSITORY, su);
				Resource currPendingRes = cmsService.getResource(currRepositoryRes, PATH_PENDING, su);
				if(permissionService.checkWritePermission(currPendingRes, cs)){
					unitResourceList.add(cuuUnitRes);
				}
			}
		}
		request.setAttribute("projectList", unitResourceList);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
