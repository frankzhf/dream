package net.frank.framework.service;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface ResourceService extends BaseService {

	public Resource newResource(String alias, Resource parent, Long typeId,
			boolean isSystem, Resource own, Resource ownGroup,
			Byte ownPermission, Byte groupPermission, Byte othersPermission);

	public Resource saveOrUpdateResource(Resource resource, Session session);

	public BusinessObject saveOrUpdateBo(BusinessObject bo, Session session);

	public BusinessObject deleteBo(BusinessObject bo, Session session);

	public Resource deleteResource(Resource resource, Session session);

	public void saveHistory(BusinessObject bo, Session session);

	public void saveResourceHistory(Resource resource, Session session);

	public void saveResourceWithRecursive(Resource src, Session session,
			boolean includeObject, ResourceFilter resourceFilter);

	public void saveResourceWithRecursive(Resource src, Session session,
			ResourceFilter resourceFilter);

	public void saveResourceWithRecursive(Resource src, Session session);

	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session, ResourceFilter resourceFilter, String alias);

	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session, ResourceFilter resourceFilter);

	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session);

	public void addAcl(Long resourceId, Long ownId, Byte permission);

	public void updateAcl(Long aclId, Long resourceId, Long ownId,
			Byte permission);

	public void deleteAcl(Long aclId);
}
