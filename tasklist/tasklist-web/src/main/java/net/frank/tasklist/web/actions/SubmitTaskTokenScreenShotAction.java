package net.frank.tasklist.web.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.tasklist.CommonConstants;
import net.frank.tasklist.web.forms.ProcessTokenForm;

public class SubmitTaskTokenScreenShotAction extends BaseAction {
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
		resource.setAlias(new Date().getTime() + "#Screenshot");
		Image image = (Image) _form.getContent(CommonConstants.TYPE.IMAGE + "");
		image.setResource(resource);
		String fileName = _form.getUpdateFile("content").getFileName();
		image.setImageName(fileName);
		image.setContent(_form.getUpdateFile("content").getFileData());
		String imageFormat = fileName.substring(fileName.lastIndexOf("."));
		image.setImageFormat(imageFormat);
		image.setContext$3(null);
		resource.setObject(image);
		cmsService.createResource(resource, getClientSession());
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
