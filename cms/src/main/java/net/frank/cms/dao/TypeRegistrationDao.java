package net.frank.cms.dao;

import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;

public interface TypeRegistrationDao {
	public void insertResource(Resource resource);
	public void insertType(Type type);
}
