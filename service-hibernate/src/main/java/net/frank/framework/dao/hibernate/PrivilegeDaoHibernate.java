package net.frank.framework.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Privilege;
import net.frank.framework.dao.PrivilegeDao;

public class PrivilegeDaoHibernate extends BaseDaoHibernate implements
		PrivilegeDao {

	@Override
	public List<Privilege> getPrivileger(final Account account) {
		List<Privilege> executeFind = getHibernateTemplate().execute(
				new HibernateCallback<List<Privilege>>() {
					@SuppressWarnings("unchecked")
					public List<Privilege> doInHibernate(Session session)
							throws HibernateException{
						String hql = "from net.frank.framework.bo.Privilege as r where r.account$5.id = :id and r.resource.active = true";
						Query q = session.createQuery(hql);
						q.setParameter("id", account.getResource().getId());
						return q.list();
					}
				});
		return executeFind;
	}

}
