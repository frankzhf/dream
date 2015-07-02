package net.frank.cms.web.tinymce.actions;

import net.frank.cms.common.CmsCommonConstants;

public class ImageTreeAction extends AbstractTinymceTreeAction {
	
	@Override
	public Long getTypeId() {
		return CmsCommonConstants.TYPE.IMAGE;
	}
}
