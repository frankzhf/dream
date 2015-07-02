package net.frank.framework.dao.hibernate;

import java.util.List;

import net.frank.framework.bo.Type;
import net.frank.framework.dao.TypeDao;

public class TypeDaoHibernate extends BaseDaoHibernate implements TypeDao {
	@Override
	public List<Type> retriveTypeList() {
		return (List<Type>)getHibernateTemplate().loadAll(Type.class);
	}
}
