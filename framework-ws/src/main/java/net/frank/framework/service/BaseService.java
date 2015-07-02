package net.frank.framework.service;

public interface BaseService {
	
	public void log(String action,String desc);
	
	public Object getObject(Object obj);
	
	public Object saveObject(Object obj);
	
	public Object removeObject(Object obj);
	
	public Object merge(Object obj);
}
