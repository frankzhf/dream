package net.frank.framework.service.impl;

import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.TestService;

public final class TestServiceImpl implements TestService {
	
	protected BaseDao baseDao;
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void clearAll(Class<?> claz) {
		baseDao.clearObjects(claz);
	}
	
	public void clearAll2(Class<?> claz){
		baseDao.clearObjects2(claz);
	}

	@Override
	public void saveOrUpdate(Object o) {
		baseDao.saveObject(o);
	}

}
