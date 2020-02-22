package net.frank.framework.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.dao.Account2GroupDao;

/**
 * @author zhaofeng
 */
public class Account2GroupDaoHibernate extends BaseDaoHibernate implements
		Account2GroupDao {
	@Override
	public List<Account2Group> listGroupByAccount(final Account account) {
		List<Account2Group> executeFind = getHibernateTemplate().execute(
				(session) ->{
					String hql = "from net.frank.framework.bo.Account2Group as r where r.account$5.id = :id and r.resource.active=true";
					Query q = session.createQuery(hql);
					q.setParameter("id", account.getResource().getId());
					return q.list();
				});
		return executeFind;
	}
}
