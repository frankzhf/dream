package net.frank.springweb.initial;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import net.frank.commons.util.PasswordUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.QueryService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.Dialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class TestInitCase extends TestCase {

	protected ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "/applicationContext-datasource.xml",
					"/applicationContext-base.xml",
					"/applicationContext-dao.xml",
					"/applicationContext-service.xml" });

	protected Map<String, Resource> resMap = new HashMap<String, Resource>();

	private static Map<String, Resource> typeMap;

	private static final Byte ACCOUNT_PERMISSION = 7;

	private static final Byte GROUP_PERMISSION = 7;

	private static final Byte OTHERS_PERMISSION = 4;

	protected Log logger = LogFactory.getLog(getClass());

	protected static final String INIT_PASSWORD = PasswordUtil
			.MD5encode("p@ssw0rd");

	protected Configuration configuration;
	protected SessionFactory sessionFactory;
	//protected Session session;
	//protected TestService testService;
	protected BaseDao baseDao;
	protected QueryService queryService;

	@Override
	public void setUp() {
		sessionFactory = (SessionFactory) this.context
				.getBean("sessionFactory");
		//session = SessionFactoryUtils.getSession(sessionFactory, true);
		//TransactionSynchronizationManager.bindResource(sessionFactory,
		//		new SessionHolder(session));
		configuration = (Configuration) context
				.getBean("hibernateConfiguration");
		//session.setFlushMode(FlushMode.NEVER);
		baseDao = (BaseDao)context.getBean("baseDao");
		//testService = (TestService) context.getBean("testService");
		queryService = (QueryService) context.getBean("queryService");
	}

	protected void executeSchemaScript(Connection con, String[] sql)
			throws SQLException {
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
							logger.warn("Unsuccessful schema statement: "
									+ sql[i], ex);
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

	public void dropDatabaseSchema(final Configuration configuration,
			SessionFactory sessionFactory) throws DataAccessException {
		logger.debug("Dropping database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection con = session.connection();
				Dialect dialect = Dialect.getDialect(configuration
						.getProperties());
				String[] sql = configuration.generateDropSchemaScript(dialect);
				executeSchemaScript(con, sql);
				return null;
			}
		});
	}

	public void createDatabaseSchema(final Configuration configuration,
			SessionFactory sessionFactory) throws DataAccessException {
		logger.debug("Creating database schema for Hibernate SessionFactory");
		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				sessionFactory);
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Connection con = session.connection();
				final Dialect dialect = Dialect.getDialect(configuration
						.getProperties());
				String[] sql = configuration
						.generateSchemaCreationScript(dialect);
				executeSchemaScript(con, sql);
				return null;
			}
		});
	}

	public Resource createResource(String alias, Resource parent,
			boolean isSystem) {
		return createResource(alias, parent, isSystem, null, null, null);
	}

	public Resource createResource(String alias, Resource parent,
			boolean isSystem, Resource type, Resource account, Resource group) {
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
		resMap.put(alias, res);
		return res;
	};

	public Account createAccount(String loginName, String password,
			String umask, Resource parent) {
		Resource res = createResource(loginName, parent, true,
				resMap.get("ACCOUNT"), null, null);
		Resource homeRes = createResource("." + loginName, parent, true,
				resMap.get("RESOURCE"), null, null);
		Resource groupRes = createResource(".group", resMap.get(".root"),
				true, resMap.get("RESOURCE"), null, null);
		Resource privilegRes = createResource(".privilege",
				resMap.get(".root"), true, resMap.get("RESOURCE"), null, null);
		Account account = new Account();
		account.setResource(res);
		account.setLoginName(loginName);
		account.setPassword(PasswordUtil.MD5encode(password));
		account.setUmask(umask);
		account.setHome$3(homeRes);
		account.setStaff$16(null);
		baseDao.saveObject(account);
		res.setObject(account);
		return account;
	}

	public Group createGroup(String groupName, Resource parent) {
		Resource res = createResource(groupName, parent, true,
				resMap.get("GROUP"), null, null);
		Group group = new Group();
		group.setResource(res);
		group.setGroupName(groupName);
		baseDao.saveObject(group);
		res.setObject(group);
		return group;
	}

	public Account2Group createA2g(Resource account, Resource group,
			Resource parent) {
		Resource res = createResource(
				account.getAlias() + "@" + group.getAlias(), parent, true,
				resMap.get("ACCOUNT2GROUP"), null, null);
		Account2Group a2g = new Account2Group();
		a2g.setAccount$5(account);
		a2g.setGroup$6(group);
		a2g.setResource(res);
		baseDao.saveObject(a2g);
		res.setObject(a2g);
		return a2g;
	}

	public Privilege createA2p(Resource account, Resource folder,
			Resource parent) {
		Resource res = createResource(account.getAlias() + "@"
				+ (folder.getAlias().equals("/") ? "All" : folder.getAlias()),
				parent, true, resMap.get("PRIVILEGE"), null, null);
		Privilege privilege = new Privilege();
		privilege.setAccount$5(account);
		privilege.setDomain$3(folder);
		privilege.setResource(res);
		baseDao.saveObject(privilege);
		res.setObject(privilege);
		return privilege;
	}

	public Resource getType(String key) {
		if (typeMap == null) {
			typeMap = new HashMap<String, Resource>();
			Resource typeRootResource = queryService
					.getResourceAsPath("/resType");
			List<Resource> children = queryService
					.retrieveResourceByParent(typeRootResource.getId());
			for (int i = 0; i < children.size(); i++) {
				Resource res = children.get(i);
				typeMap.put(res.getAlias(), res);
			}
		}
		return typeMap.get(key);
	}

	public Resource getRootAccount() {
		return queryService.getResourceAsPath("/home/root");
	}

	public Resource getAdminGroup() {
		return queryService.getResourceAsPath("/group/admin");
	}
	
	public Resource getHome(){
		return queryService.getResourceAsPath("/home/");
	}
}
