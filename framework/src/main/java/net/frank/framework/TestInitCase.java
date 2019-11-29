package net.frank.framework;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.EncryptUtils;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class TestInitCase extends BaseTestCase {
	
	private static Map<Long, Resource> typeMap = null;

	protected QueryService queryService;

	protected ResourceService resourceService;

	protected BaseDao baseDao;

	protected net.frank.framework.security.Session cs;

	protected Configuration configuration;
	protected SessionFactory sessionFactory;
	protected Session session;

	@Override
	public void setUp() {
		super.setUp();
		sessionFactory = (SessionFactory) getBean("sessionFactory");
		session = SessionFactoryUtils.getSession(sessionFactory, true);
		session.setFlushMode(FlushMode.COMMIT);
		TransactionSynchronizationManager.bindResource(sessionFactory,
				new SessionHolder(session));
		configuration = (Configuration) getBean("hibernateConfiguration");
		queryService = (QueryService) getBean("queryService");
		resourceService = (ResourceService) getBean("resourceService");
		baseDao = (BaseDao) getBean("baseDao");
		AccountDao accountDao = (AccountDao) getBean("accountDao");
		final Account current = accountDao.retrieveAccountByUid("root");
		if(current != null){
			Privilege p = new Privilege();
			Resource folderRoot = new Resource();
			folderRoot.setId(1L);
			p.setAccount$5(current.getResource());
			p.setDomain$3(folderRoot);
			Resource currGrpRes = queryService.getResourceAsPath("/group/Admin");
			final Group currGrp = (Group) queryService.getBo(currGrpRes.getId());
	
			final List<Privilege> pArray = new ArrayList<Privilege>();
			pArray.add(p);
	
			cs = new net.frank.framework.security.Session() {
	
				@Override
				public String getLocalCd() {
					return null;
				}
	
				@Override
				public void setLocalCd(String localCd) {
	
				}
	
				@Override
				public Integer getLoginType() {
					return LOGIN_TYPE_DEFAULT;
				}
	
				@Override
				public Integer getStatus() {
					return STATUS_LOGINED;
				}
	
				@Override
				public void setStatus(Integer status) {
	
				}
	
				@Override
				public String getLoginName() {
					return "root";
				}
	
				@Override
				public Account getAccount() {
					return current;
				}
	
				@Override
				public Group getCurrentGroup() {
					return currGrp;
				}
	
				@Override
				public List<Resource> getGroups() {
					return null;
				}
	
				@Override
				public List<Privilege> getPrivileges() {
					return pArray;
				}
	
				@Override
				public Map<Long, Type> getUserTypeMap() {
					return null;
				}
	
				@Override
				public void setAccount(Account account) {
	
				}
	
				@Override
				public void setCurrentGroup(Group currentGroup) {
	
				}
	
				@Override
				public void setAttributes(Map<String, Object> attributes) {
	
				}
	
				@Override
				public Map<String, Object> getAttributes() {
					return null;
				}
	
				@Override
				public void setAttribute(String key, Object value) {
	
				}
	
				@Override
				public Object getAttribute(String key) {
					return null;
				}
			};
		}
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
		String path = queryService.getResourcePath(res);
		resMap.put(path, res);
		return res;
	};

	public Account createAccount(String loginName, String password,
			String umask, Resource parent) {
		Resource res = createResource(loginName, parent, true,
				getType(CommonConstants.TYPE.ACCOUNT), null, null);
		Resource homeRes = createResource("." + loginName, parent, true,
				getType(CommonConstants.TYPE.RESOURCE), null, null);
		Resource groupRes = createResource(".group",
				resMap.get("/home/." + loginName), true,
				getType(CommonConstants.TYPE.RESOURCE), null, null);
		Resource privilegRes = createResource(".privilege",
				resMap.get("/home/." + loginName), true,
				getType(CommonConstants.TYPE.RESOURCE), null, null);
		
		logger.debug("group:" + groupRes);
		logger.debug("privilegRes:" + privilegRes);
		
		Account account = new Account();
		account.setResource(res);
		account.setLoginName(loginName);
		account.setPassword(EncryptUtils.encodeDES(password));
		account.setUmask(umask);
		account.setHome$3(homeRes);
		account.setStaff$16(null);
		baseDao.saveObject(account);
		res.setObject(account);
		return account;
	}

	public Group createGroup(String groupName, Resource parent) {
		Resource res = createResource(groupName, parent, true,
				getType(CommonConstants.TYPE.GROUP), null, null);
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
				getType(CommonConstants.TYPE.ACCOUNT_2_GROUP), null, null);
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
				parent, true, getType(CommonConstants.TYPE.PRIVILEGE), null,
				null);
		Privilege privilege = new Privilege();
		privilege.setAccount$5(account);
		privilege.setDomain$3(folder);
		privilege.setResource(res);
		baseDao.saveObject(privilege);
		res.setObject(privilege);
		return privilege;
	}

	public Application createApp(String appName, Resource parent,
			String typePaths, net.frank.framework.security.Session session,
			Resource superUser) {
		Resource res = createResource(appName, parent, true,
				typeMap.get(CommonConstants.TYPE.APPLICATION), null, null);
		Resource contextSrc = queryService
				.getResourceAsPath("/contextTemplate/application");
		resourceService.cloneResourceWithRecursive(contextSrc, parent, session,
				null, "." + appName);
		Application app = new Application();
		app.setAppName(appName);
		app.setContext$3(queryService.getResourceAsPath("/opt/." + appName));
		app.setSuperAccount$5(superUser);
		app.setResource(res);
		app.setTypePaths(typePaths.toCharArray());
		app.setParent$20(null);
		baseDao.saveObject(app);
		res.setObject(app);
		return app;
	}

	public MenuItem createMenu(String name, String title, Resource parent) {
		Resource res = createResource(name, parent, true,
				typeMap.get(CommonConstants.TYPE.MENUITEM), null, null);
		Resource childrenRes = createResource("." + name, parent, false,
				getType(CommonConstants.TYPE.RESOURCE), null, null);
		MenuItem menuItem = new MenuItem();
		menuItem.setName(name);
		menuItem.setTitle(title);
		menuItem.setResource(res);
		menuItem.setChildren$3(childrenRes);
		baseDao.saveObject(menuItem);
		res.setObject(menuItem);
		return menuItem;
	}

	public MenuItem createMenuItem(String name, String title, String path,
			String target, Resource parent) {
		Resource res = createResource(name, parent, true,
				typeMap.get(CommonConstants.TYPE.MENUITEM), null, null);
		MenuItem menuItem = new MenuItem();
		menuItem.setName(name);
		menuItem.setTitle(title);
		menuItem.setTarget(target);
		menuItem.setPath(path);
		menuItem.setChildren$3(null);
		menuItem.setResource(res);
		baseDao.saveObject(menuItem);
		res.setObject(menuItem);
		return menuItem;
	}
	
	public Limit createLimit(String name, Long limitValue, Long currentValue,Resource parent,
			Resource account,Resource group){
		Resource res = createResource(name, parent, true,
				typeMap.get(CommonConstants.TYPE.LIMIT), account, group);
		Limit limit = new Limit();
		limit.setResource(res);
		limit.setLimitName(name);
		limit.setLimitValue(limitValue);
		limit.setCurrentValue(currentValue);
		baseDao.saveObject(limit);
		res.setObject(limit);
		return limit;
	}

	public Resource getType(Long key) {
		if (typeMap == null) {
			typeMap = new HashMap<Long, Resource>();
			Resource typeRootResource = queryService
					.getResourceAsPath("/resType");
			List<Resource> children = queryService
					.retrieveResourceByParent(typeRootResource.getId());
			for (int i = 0; i < children.size(); i++) {
				Resource res = children.get(i);
				typeMap.put(res.getId(), res);
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

	public Resource getHome() {
		return queryService.getResourceAsPath("/home");
	}
}
