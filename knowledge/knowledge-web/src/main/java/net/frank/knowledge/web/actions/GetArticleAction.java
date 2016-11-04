package net.frank.knowledge.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Article;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.knowledge.web.forms.KnowledgeForm;

public class GetArticleAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KnowledgeForm knowledgeForm = (KnowledgeForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Article article = knowledgeForm.getArticle();
		article = (Article) queryService.getBo(article.getResource().getId());
		request.setAttribute("article", article);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
