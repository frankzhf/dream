package net.frank.repository.web.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.frank.commons.CommonConstants;
import net.frank.repository.bo.File;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.repository.service.FileRepositoryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.servlet.BlobContentServlet;

public class FileRepositoryCententServlet extends BlobContentServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6997826982514707635L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setBufferSize(CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH);
		Long id = Long.decode(request.getParameter("resourceId"));
		FileRepositoryService fileRepositoryService = (FileRepositoryService) SpringContextUtil
				.getBean("fileRepositoryService");
		CmsService cmsService = (CmsService)SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(id);
		currentResource = cmsService.getResource(currentResource, cs);
		if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource.getCode())){
			File file = (File) currentResource.getObject();
			processResponseHeader(response, file);
			int statusCode = fileRepositoryService.getFileContent(file, response.getOutputStream(),cs);
			if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(statusCode)){
				response.getOutputStream().flush();
			}else{
				response.reset();
			}
		}
		OutputStream os = response.getOutputStream();
		os.flush();
	}

	protected void processResponseHeader(HttpServletResponse response,
			BusinessObject bo) {
		response.reset();
		processContentType(response, bo);
		String fileName = null;
		if (bo instanceof File) {
			fileName = ((File) bo).getFileName();
		} else {
			fileName = bo.getResource().getAlias();
		}
		response.addHeader(RESPONSE_HEADER_CONTENT_DISPOSITION_KEY,
				"attachment;filename=\"" + fileName + "\"");
	}
}
