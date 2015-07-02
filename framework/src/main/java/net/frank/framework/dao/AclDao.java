package net.frank.framework.dao;

import java.util.List;

import net.frank.framework.bo.Acl;

public interface AclDao {
	public List<Acl> listAcl(Long resourceId);
	public List<Acl> listAclByResourceIdAndOwnId(Long resourceId,Long oweId);
	public List<Acl> listAclByOwnId(Long oweId);	
	public Acl getAcl(Long aclId);
}