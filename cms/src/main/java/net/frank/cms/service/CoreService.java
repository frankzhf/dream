package net.frank.cms.service;

import java.util.List;

import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface CoreService {
	public void move(Resource from, Resource to, boolean isClone,
			boolean recursive, Session cs);

	public void changeSystemPreperties(Resource resource, Byte ownPermission,
			Byte groupPermission, Byte otherPermission, Long ownId,
			Long groupId, boolean permissionFlag, boolean ownFlag,
			boolean groupFlag, boolean recursive, Session cs);

	public void activationAccount(List<Resource> accountResourceList,
			Resource defaultGroupRes, Session cs);

	public int addAcl(Long resourceId, Long ownId, Byte permission);

	public int updateAcl(Long aclId, Long resourceId, Long ownId,
			Byte permission);

	public int deleteAcl(Long aclId);
}
