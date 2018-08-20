package net.frank.framework.dao;

import net.frank.framework.bo.BusinessObject;

public interface BaseDao {
	
	public Object getObject(Object o) throws DAOException;

	public Object saveObject(Object o);

	public void removeObject(Object o) throws DAOException;

	public void clearObjects(Class<?> claz);

	public void clearObjects2(Class<?> claz);
	
	public BusinessObject getBusinessObject(String className,Long resourceId);
	
	public Object merge(Object obj);
	
	public void flush();
}
