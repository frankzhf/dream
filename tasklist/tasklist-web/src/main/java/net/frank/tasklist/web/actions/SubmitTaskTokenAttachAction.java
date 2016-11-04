package net.frank.tasklist.web.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Attach;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.tasklist.CommonConstants;
import net.frank.tasklist.web.forms.ProcessTokenForm;

public class SubmitTaskTokenAttachAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProcessTokenForm _form = (ProcessTokenForm) form;
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource resource = _form.getResource();
		resource.setChildren(null);
		resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resource.setOwnResourceId(getClientSession().getAccount().getResource()
				.getId());
		resource.setActive(Boolean.TRUE);
		resource.setAlias(new Date().getTime() + "#Attach");
		Attach attach = (Attach) _form.getContent(CommonConstants.TYPE.ATTACH
				+ CommonConstants.EMPTY_STRING);
		attach.setResource(resource);
		attach.setFileName(_form.getUpdateFile("content").getFileName());
		attach.setContent(_form.getUpdateFile("content").getFileData());
		resource.setObject(attach);
		cmsService.createResource(resource, getClientSession());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
