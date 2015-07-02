package net.frank.knowledge.service.impl;

import java.io.IOException;

import org.apache.struts.upload.FormFile;

import net.frank.knowledge.CommonConstants;
import net.frank.framework.bo.Article;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.knowledge.service.KnowledgeService;

public final class KnowledgeServiceImpl implements KnowledgeService {

	private QueryService queryService;

	private PermissionService permissionService;

	private ResourceService resourceService;

	private static final String PATH_SELF_GROUP = "/group/self";

	private static final String PATH_CONTEXT_ARTICLE = "/contextTemplate/article";

	private static Resource groupSelf;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	public int createArticle(String articleName, Long parentId, final Session cs) {
		Resource existResource = queryService
				.getResource(parentId, articleName);
		if (existResource != null) {
			return CommonConstants.CMS_CODE.MESSAGE_EXISTS;
		}
		Resource articleContext = queryService.getResourceAsPath(PATH_CONTEXT_ARTICLE);
		Resource parent = queryService.getResource(parentId);
		if (!permissionService.checkWritePermission(parent, cs)) {
			return CommonConstants.CMS_CODE.MESSAGE_WRITE;
		}
		resourceService.cloneResourceWithRecursive(articleContext, parent, cs,
				new ResourceFilter() {
					@Override
					public boolean filter(Resource resource) {
						resource.setActive(Boolean.TRUE);
						resource.setSystemNode(Boolean.FALSE);
						resource.setOwnResourceId(cs.getAccount().getResource()
								.getId());
						resource.setOwnGroupResourceId(getSelfGroup().getId());
						resource.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
						resource.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
						resource.setOthersPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
						return true;
					}
				}, CommonConstants.POINT + articleName);
		Resource currentArticleContext = queryService.getResourceAsPath(parent,CommonConstants.POINT + articleName);
		Resource resource = resourceService.newResource(
				articleName, parent, CommonConstants.TYPE.ARTICLE, Boolean.TRUE,
				cs.getAccount().getResource(), getSelfGroup(), 
				CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT, 
				CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP, 
				CommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
		Article article = new Article();
		article.setTitle(articleName);
		article.setResource(resource);
		article.setContext$3(currentArticleContext);
		resourceService.saveOrUpdateBo(article, cs);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	@Override
	public int renameArticle(Long resourceId, String newArticleName, Session cs) {
		return 0;
	}

	@Override
	public int saveArticleContent(Long resourceId, String content, Session cs) {
		Article currentArticle = (Article)queryService.getBo(resourceId);
		if(currentArticle == null){
			return CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS;
		}else{
			currentArticle.setContent(content.toCharArray());
			resourceService.saveOrUpdateBo(currentArticle, cs);
			return CommonConstants.CMS_CODE.MESSAGE_OK;
		}
	}

	@Override
	public int deleteArticle(Long resourceId, Session cs) {
		return 0;
	}

	private Resource getSelfGroup() {
		if (groupSelf == null) {
			groupSelf = queryService.getResourceAsPath(PATH_SELF_GROUP);
		}
		return groupSelf;
	}

	@Override
	public int uploadImage(Long resourceId, FormFile uploadImage, Session cs) {
		Article currentArticle = (Article)queryService.getBo(resourceId);
		Resource context = currentArticle.getContext$3();
		Resource imageFolder = queryService.getResource(context.getId(), "image");
		String imageName = uploadImage.getFileName();
		Resource existsRes = queryService.getResource(imageFolder.getId(),imageName);
		if(existsRes != null){
			return CommonConstants.CMS_CODE.MESSAGE_EXISTS;
		}else{
			Resource imageRes = resourceService.newResource(
					imageName, imageFolder, CommonConstants.TYPE.IMAGE, 
					Boolean.TRUE, cs.getAccount().getResource(), getSelfGroup(), 
					CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT, 
					CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP, 
					CommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
			Image image = new Image();
			image.setResource(imageRes);
			image.setImageName(uploadImage.getFileName());
			String fileFormat = "unknown";
			if(imageName.lastIndexOf(CommonConstants.POINT)>-1){
				fileFormat = imageName.substring(imageName.lastIndexOf(CommonConstants.POINT)+1);
			}
			image.setImageFormat(fileFormat);
			image.setContext$3(null);
			byte[] content = null;
			try{
				content = uploadImage.getFileData();
			}catch(IOException e){
				return CommonConstants.CMS_CODE.MESSAGE_UNKNOW;
			}
			image.setContent(content);
			resourceService.saveOrUpdateBo(image, cs);
			return CommonConstants.CMS_CODE.MESSAGE_OK;
		}
	}

	@Override
	public int deleteImage(Long resourceId, Session cs) {
		BusinessObject bo = queryService.getBo(resourceId);
		if(bo==null){
			return CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS;
		}
		Resource resource = bo.getResource();
		resourceService.deleteBo(bo, cs);
		resourceService.deleteResource(resource, cs);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
}