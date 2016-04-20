package net.frank.framework.thin.dao;

import net.frank.framework.dao.impl.BaseJdbcDaoImpl;
import net.frank.framework.thin.SimpleQueryPage;

public abstract class SimpleQueryDao extends BaseJdbcDaoImpl {
	
	
	public SimpleQueryPage query(SimpleQueryPage simpleQueryPage){
		
		return simpleQueryPage;
	}
	
}
