package net.frank.knowledge.web.forms;

import net.frank.framework.bo.Article;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class KnowledgeForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7235445224515480523L;

	private Article article;
	
	private FormFile uploadFile;

	public Article getArticle() {
		if(article==null){
			article = new Article();
		}
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public FormFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
