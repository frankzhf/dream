package net.frank.repository.service;

import java.util.List;

import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;

public interface RepositoryQueryService {
	public List<Long> listAllUnit();
	public Unit getUnitForResource(Resource resource);
	public Resource getUnitPublisher(Unit unit);
	//public Resource getUnitAdmin(Unit unit);
	public Resource getPendingFolder(Unit unit);
	public Resource getPublishedFolder(Unit unit);
	public Resource getArchiveFolder(Unit unit);
	
	public List<Acl> listAcl(Long resourceId);
	public List<Acl> listAcl(Long resourceId,Long staffId);
	public List<Acl> listAclByOwn(Long accountResourceId);
}
