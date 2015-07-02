package net.frank.framework.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import net.frank.framework.bo.Acl;
import net.frank.framework.dao.AclDao;

public class AclDaoHibernate extends BaseDaoHibernate implements AclDao{

	@Override
	public List<Acl> listAcl(final Long resourceId) {
		List<Acl> executeFind = getHibernateTemplate().execute(new HibernateCallback<List<Acl>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Acl> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from net.frank.framework.bo.Acl as r where r.resourceId = :resourceId";
				Query q = session.createQuery(hql);
				q.setParameter("resourceId", resourceId);
				return q.list();
			}
		});
		return executeFind;
	}

	@Override
	public Acl getAcl(Long aclId) {
		return (Acl)getHibernateTemplate().get(Acl.class,aclId);
	}

	@Override
	public List<Acl> listAclByResourceIdAndOwnId(final Long resourceId, final Long oweId) {
		List<Acl> executeFind = getHibernateTemplate().execute(new HibernateCallback<List<Acl>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Acl> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from net.frank.framework.bo.Acl as r where r.resourceId = :resourceId and r.ownId = :ownId";
				Query q = session.createQuery(hql);
				q.setParameter("resourceId", resourceId);
				q.setParameter("ownId", oweId);
				return q.list();
			}
		});
		return executeFind;
	}

	@Override
	public List<Acl> listAclByOwnId(final Long oweId) {
		List<Acl> executeFind = getHibernateTemplate().execute(new HibernateCallback<List<Acl>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Acl> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from net.frank.framework.bo.Acl as r where r.ownId = :ownId";
				Query q = session.createQuery(hql);
				q.setParameter("ownId", oweId);
				return q.list();
			}
		});
		return executeFind;
	}

}
