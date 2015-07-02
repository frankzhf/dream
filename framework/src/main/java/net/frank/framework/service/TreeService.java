package net.frank.framework.service;

import java.util.List;

import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface TreeService {
	public Resource getRoot(Resource currentNode, Session session);
	
	public List<Resource> getChildren(Resource currentNode, Session session);
}
