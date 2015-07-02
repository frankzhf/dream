package net.frank.knowledge.web.ajaxs;

import net.frank.knowledge.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.ClientSession;
import net.frank.knowledge.service.KnowledgeService;
import net.frank.knowledge.service.ServiceNames;

public class KnowledgeServiceAjax extends BaseAjax {
	public int createArticle(String articleName) {
		KnowledgeService knowledgeService = (KnowledgeService) getBean(ServiceNames.KNOWLEDGE_SERVICE);
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		ClientSession cs = getClientSession();
		Resource parent = queryService.getResourceAsPath(cs.getAccount()
				.getHome$3(), CommonConstants.Context.ACCOUNT.DRAFTS);
		int rt = knowledgeService
				.createArticle(articleName, parent.getId(), cs);
		return rt;
	}
	
	public int saveArticleContent(Long resourceId,String content){
		KnowledgeService knowledgeService = (KnowledgeService) getBean(ServiceNames.KNOWLEDGE_SERVICE);
		ClientSession cs = getClientSession();
		int rt = knowledgeService
				.saveArticleContent(resourceId, content, cs);
		return rt;
	}
	
	public int deleteImage(Long resourceId){
		KnowledgeService knowledgeService = (KnowledgeService) getBean(ServiceNames.KNOWLEDGE_SERVICE);
		ClientSession cs = getClientSession();
		int rt = knowledgeService.deleteImage(resourceId, cs);
		return rt;
	}
	
}