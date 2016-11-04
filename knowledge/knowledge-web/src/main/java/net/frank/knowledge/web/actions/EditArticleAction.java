package net.frank.knowledge.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

import net.frank.cms.common.layout.JQueryEasyuiLayoutAction;
import net.frank.cms.common.layout.Layout;
import net.frank.cms.common.layout.Section;
import net.frank.framework.bo.Article;
import net.frank.knowledge.web.forms.KnowledgeForm;

public class EditArticleAction extends JQueryEasyuiLayoutAction {

	@Override
	public void processLayout(Layout layout, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		KnowledgeForm knowledgeForm = (KnowledgeForm) form;
		Article currentArticle = knowledgeForm.getArticle();
		Section center = new Section();
		center.setLink(request.getContextPath()
				+ "/knowledge/editArticleCenter.do?article.resource.id="
				+ currentArticle.getResource().getId());
		center.setTitle("knowledge.edit.article.content.title");
		layout.setCenter(center);

		Section east = new Section();
		east.setTitle("knowledge.edit.article.resource.title");
		east.setSplit(true);
		east.setLink(request.getContextPath()
				+ "/knowledge/listResource.do?article.resource.id="
				+ currentArticle.getResource().getId());
		east.setWidth(220);
		layout.setEast(east);
	}
}
