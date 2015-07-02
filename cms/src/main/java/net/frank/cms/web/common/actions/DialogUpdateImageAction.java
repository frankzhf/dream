package net.frank.cms.web.common.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.UpdateImageForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class DialogUpdateImageAction extends BaseAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UpdateImageForm updateImageForm = (UpdateImageForm) form;
		QueryService queryService = (QueryService)getBean(ServiceNames.QUERY_SERVICE);
		if(updateImageForm.getResource().getId()!= null){
			log.debug("resouceId:" + updateImageForm.getResource().getId());
			Long id = updateImageForm.getResource().getId();
			Resource resource = queryService.getResource(id);
			updateImageForm.setResource(resource);
			request.setAttribute("resource", resource);
			//Image image = (Image)queryService.getBo(resource.getId());
			//updateImageForm.setImage(image);
		}
		request.setAttribute("submitted", Boolean.FALSE);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}