package net.frank.cms.web.core.ajaxs;

import net.frank.cms.service.CoreService;
import net.frank.commons.CommonConstants;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.ajax.BaseAjax;

public class AclAjax extends BaseAjax {
	public int deleteAcl(Long aclId) {
		CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
		coreService.deleteAcl(aclId);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	public int addAcl(Long resourceId, Long ownId, Byte permission) {
		CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
		coreService.addAcl(resourceId, ownId, permission);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	public int updateAcl(Long aclId, Long resourceId, Long ownId,
			Byte permission) {
		CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
		coreService.updateAcl(aclId, resourceId, ownId, permission);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
}
