package net.frank.framework;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import net.frank.commons.util.DesEncryptUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
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

	protected void executeSchemaScript(Connection con, String[] sql) throws SQLException {
		if (sql != null && sql.length > 0) {
			boolean oldAutoCommit = con.getAutoCommit();
			if (!oldAutoCommit) {
				con.setAutoCommit(true);
			}
			try {
				Statement stmt = con.createStatement();
				try {
					for (int i = 0; i < sql.length; i++) {
						logger.debug("Executing schema statement: " + sql[i]);
						try {
							stmt.executeUpdate(sql[i]);
						} catch (SQLException ex) {
							logger.warn("Unsuccessful schema statement: " + sql[i], ex);
						}
					}
				} finally {
					JdbcUtils.closeStatement(stmt);
				}
			} finally {
				if (!oldAutoCommit) {
					con.setAutoCommit(false);
				}
			}
		}
	}

	public void dropDatabaseSchema(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		logger.debug("Dropping database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException {
				Connection con;
				try {
					con = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
					Dialect dialect = Dialect.getDialect(configuration.getProperties());
					String[] sql = configuration.generateDropSchemaScript(dialect);
					executeSchemaScript(con, sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	public void createDatabaseSchema(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		logger.debug("Creating database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException {
				Connection con;
				try {
					con = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
					final Dialect dialect = Dialect.getDialect(configuration.getProperties());
					String[] sql = configuration.generateSchemaCreationScript(dialect);
					executeSchemaScript(con, sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	protected void executeSchemaScript2(Connection con, String[] sql) throws SQLException {
		if (sql != null && sql.length > 0) {
			boolean oldAutoCommit = con.getAutoCommit();
			if (!oldAutoCommit) {
				con.setAutoCommit(true);
			}
			try {
				Statement stmt = con.createStatement();
				try {
					for (int i = 0; i < sql.length; i++) {
						if (!(sql[i].toUpperCase().indexOf("CREATE TABLE TB_RESOURCE") > -1
								|| sql[i].toUpperCase().indexOf("DROP TABLE IF EXISTS TB_RESOURCE") > -1)) {
							logger.debug("Executing schema statement: " + sql[i]);
							try {
								stmt.executeUpdate(sql[i]);
							} catch (SQLException ex) {
								logger.warn("Unsuccessful schema statement: " + sql[i], ex);
							}
						}
					}
				} finally {
					JdbcUtils.closeStatement(stmt);
				}
			} finally {
				if (!oldAutoCommit) {
					con.setAutoCommit(false);
				}
			}
		}
	}

	public void createDatabaseSchema2(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		logger.debug("Creating database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException {
				Connection con;
				try {
					con = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
					final Dialect dialect = Dialect.getDialect(configuration.getProperties());
					String[] sql = configuration.generateSchemaCreationScript(dialect);
					executeSchemaScript2(con, sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	public void dropDatabaseSchema2(final Configuration configuration, final SessionFactory sessionFactory)
			throws DataAccessException {
		logger.debug("Dropping database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException {
				Connection con;
				try {
					con = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
					Dialect dialect = Dialect.getDialect(configuration.getProperties());
					String[] sql = configuration.generateDropSchemaScript(dialect);
					executeSchemaScript2(con, sql);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
		});
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
	};

	public Account createAccount(String loginName, String password, String umask, Resource parent) {
		Resource res = createResource(loginName, parent, true, resMap.get("/resType/ACCOUNT"), null, null);
		Resource homeRes = createResource("." + loginName, parent, true, resMap.get("/resType/RESOURCE"), null, null);
		Resource groupRes = createResource(".group", resMap.get("/home/." + loginName), true,
				resMap.get("/resType/RESOURCE"), null, null);
		Resource privilegRes = createResource(".privilege", resMap.get("/home/." + loginName), true,
				resMap.get("/resType/RESOURCE"), null, null);
		logger.debug("Variable [groupRes] -> " + groupRes);
		logger.debug("Variable privilegRes] -> " + privilegRes);
		Account account = new Account();
		account.setResource(res);
		account.setLoginName(loginName);
		account.setPassword(DesEncryptUtil.encodeDES(password));
		account.setUmask(umask);
		account.setHome$3(homeRes);
		account.setStaff$16(null);
		baseDao.saveObject(account);
		res.setObject(account);
		return account;
	}

	public Group createGroup(String groupName, Resource parent) {
		Resource res = createResource(groupName, parent, true, resMap.get("/resType/GROUP"), null, null);
		Group group = new Group();
		group.setResource(res);
		group.setGroupName(groupName);
		baseDao.saveObject(group);
		res.setObject(group);
		return group;
	}

	public Account2Group createA2g(Resource account, Resource group, Resource parent) {
		Resource res = createResource(account.getAlias() + "@" + group.getAlias(), parent, true,
				resMap.get("/resType/ACCOUNT2GROUP"), null, null);
		Account2Group a2g = new Account2Group();
		a2g.setAccount$5(account);
		a2g.setGroup$6(group);
		a2g.setResource(res);
		baseDao.saveObject(a2g);
		res.setObject(a2g);
		return a2g;
	}

	public Privilege createA2p(Resource account, Resource folder, Resource parent) {
		Resource res = createResource(
				account.getAlias() + "@" + (folder.getAlias().equals("/") ? "All" : folder.getAlias()), parent, true,
				resMap.get("/resType/PRIVILEGE"), null, null);
		Privilege privilege = new Privilege();
		privilege.setAccount$5(account);
		privilege.setDomain$3(folder);
		privilege.setResource(res);
		baseDao.saveObject(privilege);
		res.setObject(privilege);
		return privilege;
	}

	public Resource getRootAccount() {
		return queryService.getResourceAsPath("/home/root");
	}

	public Resource getAdminGroup() {
		return queryService.getResourceAsPath("/group/admin");
	}

	public Resource getHome() {
		return queryService.getResourceAsPath("/home");
	}
}
