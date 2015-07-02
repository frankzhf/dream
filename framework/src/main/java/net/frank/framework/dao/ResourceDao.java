package net.frank.framework.dao;

import java.util.List;

import net.frank.framework.bo.Resource;

public interface ResourceDao {
	
	public Resource retrieveResource(Long parentId, String alias);
	
	public List<Resource> retrieveChildren(Long parentId);
	
	public List<Resource> retrieveResourceByType(Long typeId);
}
