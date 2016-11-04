package net.frank.knowledge.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

import net.frank.cms.common.layout.JQueryEasyuiLayoutAction;
import net.frank.cms.common.layout.Layout;
import net.frank.cms.common.layout.Section;
import net.frank.framework.bo.Article;
import net.frank.knowledge.web.forms.KnowledgeForm;

public class EditArticleCenterAction extends JQueryEasyuiLayoutAction {

	@Override
	public void processLayout(Layout layout, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		KnowledgeForm knowledgeForm = (KnowledgeForm) form;
		Article currentArticle = knowledgeForm.getArticle();
		Section center = new Section();
		center.setLink(request.getContextPath()
				+ "/knowledge/editArticleContent.do?article.resource.id="
				+ currentArticle.getResource().getId());
		layout.setCenter(center);
		Section south = new Section();
		south.setLink(request.getContextPath()
				+ "/knowledge/controlSaveArticle.do?article.resource.id="
				+ currentArticle.getResource().getId());
		south.setHeight(35);
		layout.setSouth(south);
	}

}
