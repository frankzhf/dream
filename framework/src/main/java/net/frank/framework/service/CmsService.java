package net.frank.framework.service;

import java.sql.SQLException;

import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface CmsService {
	
	public Resource getResource(String path,Session cs);
	
	public Resource getResource(Resource resource,Session cs);
	
	public Resource getResource(Resource parent,String alias,Session cs);
	
	public Resource createResource(Resource resource,Session cs);
	
	public Resource updateResource(Resource resource,Session cs);
	
	public Resource deleteResource(Resource resource,Session cs);
	
	public Resource deleteResource2(Resource resource,Session cs)throws SQLException;
	
}
