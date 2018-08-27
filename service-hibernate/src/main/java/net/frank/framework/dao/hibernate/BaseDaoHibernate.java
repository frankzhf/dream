package net.frank.framework.dao.hibernate;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.dao.DAOException;

public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public Object getObject(Object o) throws DAOException {
		Long id = null;
		try {
			Method meth = o.getClass().getMethod("getId", new Class[0]);
			id = (Long) meth.invoke(o, new Object[0]);
			o = getHibernateTemplate().get(o.getClass(), id);
		} catch (Exception e) {
			throw new DAOException("exception loading '"
					+ o.getClass().getName() + "' with id '" + id + "'");
		}
		return o;
		
	}
	
	public Object getObject(Class<?> claz, String key, Object value) {
		StringBuffer buff = new StringBuffer();
		buff.append(" from ").append(claz.getName());
		buff.append(" where ");
		buff.append(key).append("=?");
		return getHibernateTemplate().find(buff.toString(), value);
	}
	
	@Override
	public Object saveObject(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
		return o;
	}
	
	@Override
	public void removeObject(Object o) throws DAOException {
		if (log.isDebugEnabled()) {
			log.debug("loading object to delete....");
		}
		o = getObject(o);
		if (o != null) {
			getHibernateTemplate().delete(o);
		}
	}

	public List<?> getObjects(Class<?> claz) {
		return getHibernateTemplate().loadAll(claz);
	}

	public List<?> getObjectts(Class<?> claz, String[] keys, Object[] values) {
		StringBuffer buff = new StringBuffer();
		buff.append(" from ").append(claz.getName());
		buff.append(" where ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			buff.append(key).append("=?");
			if (i < keys.length - 1) {
				buff.append(" and ");
			}
		}
		buff.append(" order by id");
		return getHibernateTemplate().find(buff.toString(), values);
	}
	
	@Override
	public void clearObjects(Class<?> claz) {
		final StringBuffer buff = new StringBuffer();
		buff.append("delete from ").append(claz.getName());
		
		
		getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(buff.toString());
				q.executeUpdate();
				return null;
			}});
	}

	public void clearObjects2(Class<?> claz) {
		List<?> objectts = getHibernateTemplate().find("from " + claz.getName());
		getHibernateTemplate().deleteAll(objectts);
	}
	
	public void deleteObject(Class<?> claz,Long[] ids){
		final StringBuffer buff = new StringBuffer();
		buff.append("delete from ").append(claz.getName()).append(" where id in (");
		for(int i = 0;i < ids.length;i++){
			buff.append(ids[i]).append(",");
		}
		buff.deleteCharAt(buff.length()-1);
		buff.append(")");
		getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(buff.toString());
				q.executeUpdate();
				return null;
		}});
	}

	@Override
	public BusinessObject getBusinessObject(final String className,final Long resourceId) {
		@SuppressWarnings("unchecked")
		List<BusinessObject> executeFind = (List<BusinessObject>)getHibernateTemplate().
				execute(new HibernateCallback<List<BusinessObject>>() {
			public List<BusinessObject> doInHibernate(Session session)
					throws HibernateException {
				StringBuffer sb = new StringBuffer("from ");
				sb.append(className);
				sb.append(" as r where r.resource.id = :id");
				Query q = session.createQuery(sb.toString());
				q.setParameter("id", resourceId);
				return q.list();
			}
		});
		if(executeFind!=null && !executeFind.isEmpty()){
			return executeFind.iterator().next();
		}
		return null;
	}

	@Override
	public Object merge(Object obj) {
		return getHibernateTemplate().merge(obj);
	}

	@Override
	public void flush() {
		getHibernateTemplate().flush();
	}
}
