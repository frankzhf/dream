package net.frank.framework.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.dao.Account2GroupDao;

public class Account2GroupDaoHibernate extends BaseDaoHibernate implements
		Account2GroupDao {
	@Override
	public List<Account2Group> listGroupByAccount(final Account account) {
		List<Account2Group> executeFind = getHibernateTemplate().execute(
			new HibernateCallback<List<Account2Group>>() {
				@SuppressWarnings("unchecked")
				public List<Account2Group> doInHibernate(Session session)
						throws HibernateException, SQLException {
					String hql = "from net.frank.framework.bo.Account2Group as r where r.account$5.id = :id and r.resource.active=true";
					Query q = session.createQuery(hql);
					q.setParameter("id", account.getResource().getId());
					return q.list();
				}
			});
		return executeFind;
	}
}
