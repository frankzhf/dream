package net.frank.cms.web.common.ajaxs;

import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.ClientSession;

public class CmsAjax extends BaseAjax {
	public Resource retrieveChildren(Long resourceId){
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource rt = new Resource();
		rt.setId(resourceId);
		rt = cmsService.getResource(rt, cs);
		return rt;
	}
}
