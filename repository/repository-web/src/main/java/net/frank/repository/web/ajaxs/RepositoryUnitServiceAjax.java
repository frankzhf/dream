package net.frank.repository.web.ajaxs;

import java.sql.SQLException;

import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.ClientSession;
import net.frank.repository.service.ServiceNames;
import net.frank.repository.service.UnitFileRepositoryService;

public class RepositoryUnitServiceAjax extends BaseAjax {

	public int rejectShare(Long resourceId) throws SQLException {
		UnitFileRepositoryService unitFileRepositoryService = (UnitFileRepositoryService) getBean(ServiceNames.REPOSITORY_UNIT_SERVICE);
		ClientSession cs = getClientSession();
		return unitFileRepositoryService.rejectShare(resourceId, cs);
	}

	public int valiationApprovalShare(Long resourceId, Long targetResourceId) {
		UnitFileRepositoryService unitFileRepositoryService = (UnitFileRepositoryService) getBean(ServiceNames.REPOSITORY_UNIT_SERVICE);
		ClientSession cs = getClientSession();
		return unitFileRepositoryService.validateApproveShare(resourceId,
				targetResourceId, cs);
	}

	public int approvalShare(Long resourceId, Long targetResourceId) {
		UnitFileRepositoryService unitFileRepositoryService = (UnitFileRepositoryService) getBean(ServiceNames.REPOSITORY_UNIT_SERVICE);
		ClientSession cs = getClientSession();
		return unitFileRepositoryService.approveShare(resourceId,
				targetResourceId, cs);
	}

	public int createFolder(Long parentId, String folderName) {
		UnitFileRepositoryService unitFileRepositoryService = (UnitFileRepositoryService) getBean(ServiceNames.REPOSITORY_UNIT_SERVICE);
		ClientSession cs = getClientSession();
		return unitFileRepositoryService.createFolder(parentId, folderName, cs);
	}

	public int deleteFile(Long resourceId, String desc) {
		UnitFileRepositoryService unitFileRepositoryService = (UnitFileRepositoryService) getBean(ServiceNames.REPOSITORY_UNIT_SERVICE);
		ClientSession cs = getClientSession();
		return unitFileRepositoryService.deleteFile(resourceId, desc, cs);
	}
}
