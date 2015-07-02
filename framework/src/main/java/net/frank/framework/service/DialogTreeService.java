package net.frank.framework.service;

import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface DialogTreeService extends TreeService {
	public String getSelectedLinks(Resource selectedNode,Session session);
}
