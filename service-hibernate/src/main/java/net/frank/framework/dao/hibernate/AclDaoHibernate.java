package net.frank.framework.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import net.frank.framework.bo.Acl;
import net.frank.framework.dao.AclDao;

/**
 * @author zhaofeng
 */
public class AclDaoHibernate extends BaseDaoHibernate implements AclDao{

	@Override
	public List<Acl> listAcl(final Long resourceId) {
		List<Acl> executeFind = getHibernateTemplate().execute(
				(session)->{
					String hql = "from net.frank.framework.bo.Acl as r where r.resourceId = :resourceId";
					Query q = session.createQuery(hql);
					q.setParameter("resourceId", resourceId);
					return q.list();
				});
		return executeFind;
	}

	@Override
	public Acl getAcl(Long aclId) {
		return (Acl)getHibernateTemplate().get(Acl.class,aclId);
	}

	@Override
	public List<Acl> listAclByResourceIdAndOwnId(final Long resourceId, final Long oweId) {
		List<Acl> executeFind = getHibernateTemplate().execute((session)->{
			String hql = "from net.frank.framework.bo.Acl as r where r.resourceId = :resourceId and r.ownId = :ownId";
			Query q = session.createQuery(hql);
			q.setParameter("resourceId", resourceId);
			q.setParameter("ownId", oweId);
			return q.list();
		});
		return executeFind;
	}

	@Override
	public List<Acl> listAclByOwnId(final Long oweId) {
		List<Acl> executeFind = getHibernateTemplate().execute(
				(session)->{
					String hql = "from net.frank.framework.bo.Acl as r where r.ownId = :ownId";
					Query q = session.createQuery(hql);
					q.setParameter("ownId", oweId);
					return q.list();
				});
		return executeFind;
	}

}
