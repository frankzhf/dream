package net.frank.framework.app;

import java.util.Map;

import net.frank.framework.bo.Application;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.security.Session;

import org.springframework.beans.factory.InitializingBean;

public interface ApplicationTemplate extends InitializingBean{
	
	public Session getSuperUserClientSession();
	
	public Resource getApplicationContext();
	
	public Resource getMenuRepository();
	
	public Resource getGroupRepository();
	
	public Application getApplication();
	
	public Map<Long,Type> getTypeMap();
	
	public void reload();
}
