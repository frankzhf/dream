package net.frank.cms.ext.selector.unit.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import net.frank.cms.ext.selector.unit.dao.UnitSelectorDao;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.hibernate.BaseDaoHibernate;

public class UnitSelectorDaoHibernate extends BaseDaoHibernate implements
		UnitSelectorDao {

	@Override
	public Unit retrieveUnitByContext(final Resource context) {
		List<Unit> executeFind = getHibernateTemplate().execute(new HibernateCallback<List<Unit>>() {
			@SuppressWarnings("unchecked")
			public List<Unit> doInHibernate(Session session)
					throws HibernateException {
				String hql = "from net.frank.framework.bo.Unit as r where r.context$3.id=:contextId";
				Query q = session.createQuery(hql);
				q.setParameter("contextId", context.getId());
				return q.list();
			}
		});
		if(executeFind!=null && executeFind.size()>0)
			return executeFind.iterator().next();
		return null;
	}

}
