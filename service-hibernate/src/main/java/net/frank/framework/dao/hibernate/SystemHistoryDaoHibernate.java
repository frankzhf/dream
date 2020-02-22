package net.frank.framework.dao.hibernate;

import java.util.List;
import org.hibernate.Query;

import net.frank.framework.bo.SystemHistory;
import net.frank.framework.dao.SystemHistoryDao;

public class SystemHistoryDaoHibernate extends BaseDaoHibernate implements
		SystemHistoryDao {

	@Override
	public List<SystemHistory> listHistory(final Long resourceId) {
		return getHibernateTemplate().execute((session)-> {
			String hql = "from net.frank.framework.bo.SystemHistory as r where r.resourceId = :resourceId";
			Query q = session.createQuery(hql);
			q.setParameter("resourceId", resourceId);
			return q.list();
		});
	}

	@Override
	public SystemHistory getSystemHistory(Long id) {
		return (SystemHistory)getHibernateTemplate().get(SystemHistory.class,id);
	}

}
