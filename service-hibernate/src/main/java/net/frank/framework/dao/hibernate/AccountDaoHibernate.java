package net.frank.framework.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import net.frank.framework.bo.Account;
import net.frank.framework.dao.AccountDao;

public class AccountDaoHibernate extends BaseDaoHibernate implements AccountDao {
	@Override
	public Account getBusinessObject(final Long resourceId) {
		List<Account> executeFind = getHibernateTemplate().execute(
				new HibernateCallback<List<Account>>() {
					@SuppressWarnings("unchecked")
					public List<Account> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from net.frank.framework.bo.Account as r where r.resource.id = :id and r.resource.active = true";
						Query q = session.createQuery(hql);
						q.setParameter("id", resourceId);
						return q.list();
					}
				});
		if (executeFind != null && !executeFind.isEmpty()) {
			return executeFind.iterator().next();
		}
		return null;
	}
	
	@Override
	public Account retrieveAccountByUid(final String loginName) {
		List<Account> executeFind = (List<Account>) getHibernateTemplate()
				.execute(new HibernateCallback<List<Account>>() {
					@SuppressWarnings("unchecked")
					public List<Account> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from net.frank.framework.bo.Account as r where r.loginName = :loginName and r.resource.active = true";
						Query q = session.createQuery(hql);
						q.setParameter("loginName", loginName);
						return q.list();
					}
				});
		if (executeFind != null && !executeFind.isEmpty()) {
			return executeFind.iterator().next();
		}
		return null;
	}

	@Override
	public Account retrieveAccountByStaff(final Long staffResourceId) {
		List<Account> executeFind = (List<Account>) getHibernateTemplate()
				.execute(new HibernateCallback<List<Account>>() {
					@SuppressWarnings("unchecked")
					public List<Account> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from net.frank.framework.bo.Account as r where r.staff$16.id = :staffResourceId";
						Query q = session.createQuery(hql);
						q.setParameter("staffResourceId", staffResourceId);
						return q.list();
					}
				});
		if (executeFind != null && !executeFind.isEmpty()) {
			return executeFind.iterator().next();
		}
		return null;
	}
}
