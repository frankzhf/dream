package net.frank.framework.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import net.frank.framework.bo.Resource;
import net.frank.framework.dao.ResourceDao;

/**
 * @author zhaofeng
 */
public class ResourceDaoHibernate extends BaseDaoHibernate implements
		ResourceDao {

	@Override
	public Resource retrieveResource(final Long parentId, final String alias) {
		List<Resource> executeFind = getHibernateTemplate().execute((session)->{
			String hql = "from net.frank.framework.bo.Resource as r where r.parentId=:parentId and r.alias=:alias";
			Query q = session.createQuery(hql);
			q.setParameter("parentId", parentId);
			q.setParameter("alias", alias);
			return q.list();
		});
		if(executeFind!=null && executeFind.size()>0) {
			return executeFind.iterator().next();
		}
		return null;
	}

	@Override
	public List<Resource> retrieveChildren(final Long parentId) {
		List<Resource> executeFind = getHibernateTemplate().execute((session)->{
			String hql = "from net.frank.framework.bo.Resource as r where r.parentId = :parentId order by r.createdDt";
			Query q = session.createQuery(hql);
			q.setParameter("parentId", parentId);
			return q.list();
		});
		return executeFind;
	}

	@Override
	public List<Resource> retrieveResourceByType(final Long typeId) {
		List<Resource> executeFind = getHibernateTemplate().execute((session)->{
			String hql = "from net.frank.framework.bo.Resource as r where r.typeId = :typeId";
			Query q = session.createQuery(hql);
			q.setParameter("typeId", typeId);
			return q.list();
		});
		return executeFind;
	}

}
