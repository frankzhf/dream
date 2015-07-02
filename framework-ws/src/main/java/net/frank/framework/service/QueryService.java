package net.frank.framework.service;

import java.util.List;
import java.util.Stack;

import net.frank.framework.bo.Acl;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.SystemHistory;
import net.frank.framework.bo.Type;
import net.frank.framework.bo.Resource;

public interface QueryService {
	//base
	public List<Type> retrieveListType();
	public Resource getResource(Long resourceId);
	
	public Resource getResourceWithRecursive(Resource resource);
	public Resource getResourceWithRecursive(Resource resource,boolean includeObject);
	public Resource getResourceWithRecursive(Resource resource,boolean includeObject,
			ResourceFilter resourceFilter);
	
	
	public BusinessObject getBo(Resource resource);
	public BusinessObject getBo(Long resourceId);
	public Resource getResource(Long resourceParentId,String alias);
	public Resource getResourceAsPath(String path);
	public Resource getResourceAsPath(Resource current,String path);
	
	public List<Resource> retrieveResourceByParent(Long resourceParentId);
	public List<Resource> retrieveResourceByType(Long typeId);
	
	//extend
	public Stack<Resource> getNodeStack(Long resourceId);
	public Stack<Resource> getNodeStack(Long resourceId, Stack<Resource> returnValue);
	public String getResourcePath(Resource resource);
	public String getNodePath(Resource resource);
	
	public List<Acl> listAcl(Long resourceId);
	public Acl getAcl(Long aclId);
	public List<SystemHistory> listSystemHistory(Long resourceId);
	public SystemHistory getSystemHistory(Long id);
}