package net.frank.framework.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Privilege;
import net.frank.framework.dao.PrivilegeDao;

/**
 * @author zhaofeng
 */
public class PrivilegeDaoHibernate extends BaseDaoHibernate implements
		PrivilegeDao {

	@Override
	public List<Privilege> getPrivileger(final Account account) {
		List<Privilege> executeFind = getHibernateTemplate().execute((session)->{
			String hql = "from net.frank.framework.bo.Privilege as r where r.account$5.id = :id and r.resource.active = true";
			Query q = session.createQuery(hql);
			q.setParameter("id", account.getResource().getId());
			return q.list();
		});
		return executeFind;
	}

}
