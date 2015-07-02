package net.frank.knowledge.service;

import org.apache.struts.upload.FormFile;

import net.frank.framework.security.Session;

public interface KnowledgeService {
	public int createArticle(String articleName, Long parentId, Session cs);

	public int renameArticle(Long resourceId, String newArticleName, Session cs);

	public int saveArticleContent(Long resourceId,String content, Session cs);
	
	public int deleteArticle(Long resourceId,Session cs);
	
	public int uploadImage(Long resourceId,FormFile uploadImage,Session cs);
	
	public int deleteImage(Long resourceId,Session cs);
}
