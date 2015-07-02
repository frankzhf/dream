package net.frank.cms.web.tinymce.actions;

import net.frank.cms.common.CmsCommonConstants;

public class ArticleTreeAction extends AbstractTinymceTreeAction {
	@Override
	public Long getTypeId() {
		return CmsCommonConstants.TYPE.ARTICLE;
	}
}	
