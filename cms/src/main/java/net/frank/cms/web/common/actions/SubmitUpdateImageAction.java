package net.frank.cms.web.common.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.UpdateImageForm;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Resource;
import net.frank.framework.image.ImageUtil;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class SubmitUpdateImageAction extends BaseAction {

	private static final String WORK_FOLDER = "/Users/zhaofeng/Others/apps/workspace/splitImage";

	private static final Integer SCALE_IMAGE_WIDTH = 147;

	private static final Integer SCALE_IMAGE_HEIGHT = 189;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ResourceService resourceService = (ResourceService) getBean(ServiceNames.RESOURCE_SERVICE);
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		UpdateImageForm updateImageForm = (UpdateImageForm) form;
		Resource resource = updateImageForm.getResource();
		log.debug("Resource's ID:" + resource.getId());
		Image image = null;
		if (resource.getId() != null) {
			image = (Image) queryService.getBo(resource.getId());
		} else {
			Resource myHomeContextRes = getClientSession().getAccount()
					.getHome$3();
			Resource imageResource = resourceService.newResource("",
					myHomeContextRes, CommonConstants.TYPE.IMAGE, false,
					getClientSession().getAccount().getResource(),
					getClientSession().getCurrentGroup().getResource(),
					myHomeContextRes.getCurrentAccountPermission(),
					myHomeContextRes.getCurrentGroupPermission(),
					myHomeContextRes.getOthersPermission());
			image = new Image();
			image.setResource(imageResource);
		}
		resource = queryService.getResource(resource.getId());
		InputStream data = null;
		int flag = -1;
		if (updateImageForm.getUpdatedFile().getFileSize() == 0) {
			data = new ByteArrayInputStream(image.getContent());
		} else {
			FormFile updateFile = updateImageForm.getUpdatedFile();
			String imageName = updateFile.getFileName();
			image.setImageName(imageName);
			String extName = imageName.substring(imageName
					.lastIndexOf(CommonConstants.POINT));
			image.setImageFormat(extName);
			image.getResource().setAlias(imageName);
			data = updateFile.getInputStream();
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		if (updateImageForm.getChkSplit()) {
			log.debug("Point1 x:" + updateImageForm.getFirstPointX());
			log.debug("Point1 y:" + updateImageForm.getFirstPointY());
			log.debug("Point2 x:" + updateImageForm.getSecondPointX());
			log.debug("Point2 y:" + updateImageForm.getSecondPointY());
			String fileName = WORK_FOLDER + "o_" + image.getImageName();
			String _fileName = WORK_FOLDER + "p_" + image.getImageName();
			FileOutputStream fos = new FileOutputStream(fileName);
			while ((flag = data.read(buffer)) != -1) {
				fos.write(buffer);
			}
			fos.flush();
			fos.close();
			ImageUtil.scaleImage(SCALE_IMAGE_WIDTH, SCALE_IMAGE_HEIGHT,
					fileName, _fileName);
			ImageUtil.scissor(updateImageForm.getFirstPointX(),
					updateImageForm.getFirstPointY(),
					updateImageForm.getSecondPointX(),
					updateImageForm.getSecondPointY(),fileName, _fileName);
			FileInputStream fis = null;
			try{
				fis = new FileInputStream(_fileName);
				while ((flag = fis.read(buffer)) != -1) {
					baos.write(buffer, 0, flag);
				}
			}finally{
				if(fis!=null){
					fis.close();
				}
			}
		} else {
			while ((flag = data.read(buffer)) != -1) {
				baos.write(buffer, 0, flag);
			}
		}
		image.setContent(baos.toByteArray());
		resourceService.saveOrUpdateBo(image, getClientSession());
		updateImageForm.setResource(image.getResource());
		request.setAttribute("resource", image.getResource());
		request.setAttribute("submitted", Boolean.TRUE);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
