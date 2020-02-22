package net.frank.framework;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import net.frank.framework.bo.Resource;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class TestInitDbCase extends BaseTestCase {

	protected Configuration configuration;
	protected SessionFactory sessionFactory;
	protected Session session;

	protected QueryService queryService;
	protected ResourceService resourceService;
	protected BaseDao baseDao;

	@Override
	public void setUp() {
		super.setUp();
		sessionFactory = (SessionFactory) getBean("sessionFactory");
		session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.COMMIT);
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
		configuration = (Configuration) getBean("hibernateConfiguration");

		queryService = (QueryService) getBean("queryService");
		resourceService = (ResourceService) getBean("resourceService");
		baseDao = (BaseDao) getBean("baseDao");

	}


	public void dropDatabaseSchema(){
		logger.debug("Drop database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute((session)-> {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
			SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
			export.drop(true, true);
			return null;
		});
	}

	public void createDatabaseSchema()
			throws DataAccessException {
		logger.debug("Creating database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute((session)-> {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
			SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
			export.create(true, true);
			return null;
		});
	}

	@Deprecated
	public void createDatabaseSchema2(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public void dropDatabaseSchema2(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		throw new UnsupportedOperationException();
	}

	public Resource createResource(String alias, Resource parent, boolean isSystem) {
		return createResource(alias, parent, isSystem, null, null, null);
	}

	public Resource createResource(String alias, Resource parent, boolean isSystem, Resource type, Resource account,
			Resource group) {
		Resource res = new Resource();
		res.setAlias(alias);
		res.setSystemNode(isSystem);
		res.setActive(true);
		res.setCreatedDt(new Date());
		res.setLastUpdatedDt(new Date());
		res.setParentId(parent == null ? null : parent.getId());
		res.setTypeId(type == null ? null : type.getId());
		res.setOwnResourceId(account == null ? null : account.getId());
		res.setOwnGroupResourceId(group == null ? null : group.getId());
		res.setLastAccountResourceId(null);
		res.setCurrentAccountPermission(ACCOUNT_PERMISSION);
		res.setCurrentGroupPermission(GROUP_PERMISSION);
		res.setOthersPermission(OTHERS_PERMISSION);
		baseDao.saveObject(res);
		String path = queryService.getResourcePath(res);
		resMap.put(path, res);
		return res;
	}

	public Resource getHome() {
		return queryService.getResourceAsPath("/home");
	}
}
