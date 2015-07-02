package net.frank.repository.web.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.CmsService;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.web.forms.RepositoryForm;

public class DialogMoveToAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RepositoryForm _form = (RepositoryForm) form;
		CmsService cmsService = (CmsService) 
				getBean(ServiceNames.CMS_SERVICE);
		Resource unitResource = _form.getUnit();
		unitResource = cmsService.getResource(unitResource, getClientSession());
		Unit unit = (Unit)unitResource.getObject();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("currentUnit", unit);
		request.setAttribute("paramMap", paramMap);
		request.setAttribute("file", _form.getFile());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
