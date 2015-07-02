package net.frank.repository.service;

import net.frank.framework.security.Session;

public interface UnitFileRepositoryService {
	public int rejectShare(Long resourceId, Session cs);

	public int validateApproveShare(Long resourceId, Long targetResourceId,
			Session cs);

	public int approveShare(Long resourceId, Long targetResourceId, Session cs);

	public int createFolder(Long parentId, String folderName, Session cs);

	public int deleteFile(Long resourceId, String desc, Session cs);
}