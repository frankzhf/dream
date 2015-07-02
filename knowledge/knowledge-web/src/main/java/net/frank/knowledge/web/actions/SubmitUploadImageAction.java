package net.frank.knowledge.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.struts.action.BaseAction;
import net.frank.knowledge.CommonConstants;
import net.frank.knowledge.service.KnowledgeService;
import net.frank.knowledge.service.ServiceNames;
import net.frank.knowledge.web.forms.KnowledgeForm;

public class SubmitUploadImageAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KnowledgeForm knowledgeForm = (KnowledgeForm) form;
		KnowledgeService knowledgeService = (KnowledgeService) getBean(ServiceNames.KNOWLEDGE_SERVICE);
		int rt = knowledgeService.uploadImage(knowledgeForm.getArticle().getResource().getId(),
				knowledgeForm.getUploadFile(), getClientSession());
		request.setAttribute("result", rt);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
