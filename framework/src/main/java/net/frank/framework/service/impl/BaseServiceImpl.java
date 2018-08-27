package net.frank.framework.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.BaseService;

public abstract class BaseServiceImpl implements BaseService {

	protected transient Logger log = LoggerFactory.getLogger(getClass());

	private BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public BaseDao getBaseDao(){
		return baseDao;
	}

	@Override
	public void log(String action, String desc) {

	}

	@Override
	public Object getObject(Object obj) {
		Object _obj = getBaseDao().getObject(obj);
		return _obj;
	}

	@Override
	public Object saveObject(Object obj) {
		getBaseDao().saveObject(obj);
		return obj;
	}

	@Override
	public Object removeObject(Object obj) {
		getBaseDao().removeObject(obj);
		return obj;
	}

	@Override
	public Object merge(Object obj) {
		return getBaseDao().merge(obj);
	}
	
	

}
