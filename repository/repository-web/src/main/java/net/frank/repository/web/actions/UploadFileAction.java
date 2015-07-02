package net.frank.repository.web.actions;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.MultipartRequestHandler;

import net.frank.repository.CommonConstants;
import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.repository.service.FileRepositoryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.repository.web.forms.RepositoryForm;

public class UploadFileAction extends BaseAction {

	private static final String UPLOAD_SUCCESS = "repository.file.list.message.upload.file.success";
	private static final String UPLOAD_EXISTS = "repository.file.list.error.upload.file.exists";
	private static final String PERMISSION_NOT_ENOUGH = "repository.file.list.error.permission.not.enough";
	private static final String UPLOAD_LIMIT_MAX = "repository.file.list.error.upload.file.limit.max";
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		FileRepositoryService fileRepositoryService = (FileRepositoryService) getBean("fileRepositoryService");
		RepositoryForm _form = (RepositoryForm) form;
		Resource folder = _form.getFolder();
		folder = cmsService.getResource(folder, getClientSession());
		Boolean maxLengthExceeded = (Boolean) request
				.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);
		ActionMessages actionMessages = new ActionMessages();
		if(maxLengthExceeded!=null && maxLengthExceeded){
			actionMessages
				.add(CommonConstants.EMPTY_STRING,
					new ActionMessage(
							UPLOAD_LIMIT_MAX));
			addErrors(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}
		InputStream is = _form.getUploadFile().getInputStream();
		int statusCode = fileRepositoryService.createFile(folder, _form
				.getUploadFile().getFileName(), _form.getUploadFile()
				.getFileSize(), is, getClientSession());
		if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(statusCode)) {
			actionMessages.add(CommonConstants.EMPTY_STRING, new ActionMessage(
					UPLOAD_SUCCESS));
			addMessages(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
		} else {
			if (CommonConstants.CMS_CODE.MESSAGE_EXISTS.equals(statusCode)) {
				actionMessages.add(CommonConstants.EMPTY_STRING,
						new ActionMessage(UPLOAD_EXISTS));
			}
			if (CommonConstants.CMS_CODE.MESSAGE_WRITE.equals(statusCode)) {
				actionMessages.add(CommonConstants.EMPTY_STRING,
						new ActionMessage(PERMISSION_NOT_ENOUGH));
			}
			if (CommonConstants.CMS_CODE.MESSAGE_UNKNOW.equals(statusCode)) {
				actionMessages.add(CommonConstants.EMPTY_STRING,
						new ActionMessage(
								CommonConstants.CMS_MESSAGE.MESSAGE_UNKNOW));
			}
			if (CommonConstants.CMS_CODE.MESSAGE_LIMIT_MAX_CAPACITY
					.equals(statusCode)) {
				actionMessages
						.add(CommonConstants.EMPTY_STRING,
								new ActionMessage(
										CommonConstants.CMS_MESSAGE.MESSAGE_LIMIT_MAX_CAPACITY));
			}
			addErrors(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}

	}
}
