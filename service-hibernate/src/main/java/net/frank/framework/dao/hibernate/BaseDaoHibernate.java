package net.frank.framework.dao.hibernate;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.dao.DAOException;

/**
 * @author zhaofeng
 */
public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public Object getObject(Object o) throws DAOException {
		Long id = null;
		try {
			Method method = o.getClass().getMethod("getId", new Class[0]);
			id = (Long) method.invoke(o, new Object[0]);
			o = getHibernateTemplate().get(o.getClass(), id);
		} catch (Exception e) {
			throw new DAOException("exception loading '"
					+ o.getClass().getName() + "' with id '" + id + "'");
		}
		return o;
		
	}
	
	public Object getObject(Class<?> clazz, String key, Object value) {
		StringBuilder buff = new StringBuilder();
		buff.append(" from ").append(clazz.getName());
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

	public <T>  List<T> getObjects(Class<T> claz) {
		return getHibernateTemplate().loadAll(claz);
	}

	public <T> List<T> getObjectts(Class<T> clazz, String[] keys, Object[] values) {
		StringBuffer buff = new StringBuffer();
		buff.append(" from ").append(clazz.getName());
		buff.append(" where ");
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			buff.append(key).append("=?");
			if (i < keys.length - 1) {
				buff.append(" and ");
			}
		}
		buff.append(" order by id");
		return (List<T>)getHibernateTemplate().find(buff.toString(), values);
	}
	
	@Override
	public void clearObjects(Class<?> claz) {
		final StringBuffer buff = new StringBuffer();
		buff.append("delete from ").append(claz.getName());
		getHibernateTemplate().execute((session)->{
			Query q = session.createQuery(buff.toString());
			q.executeUpdate();
			return null;
		});
	}

	@Override
	public void clearObjects2(Class<?> claz) {
		List<?> objects = getHibernateTemplate().find("from " + claz.getName());
		getHibernateTemplate().deleteAll(objects);
	}
	
	public void deleteObject(Class<?> claz,Long[] ids){
		final StringBuffer buff = new StringBuffer();
		buff.append("delete from ").append(claz.getName()).append(" where id in (");
		for(Long id : ids){
			buff.append(id).append(",");
		}
		buff.deleteCharAt(buff.length()-1);
		buff.append(")");
		getHibernateTemplate().execute((session)-> {
			Query q = session.createQuery(buff.toString());
			q.executeUpdate();
			return null;
		});
	}

	@Override
	public BusinessObject getBusinessObject(final String className,final Long resourceId) {
		@SuppressWarnings("unchecked")
		List<BusinessObject> executeFind = (List<BusinessObject>)getHibernateTemplate().
				execute((session)-> {

			StringBuilder sb = new StringBuilder("from ");
			sb.append(className);
			sb.append(" as r where r.resource.id = :id");
			Query q = session.createQuery(sb.toString());
			q.setParameter("id", resourceId);
			return q.list();
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
