package net.frank.framework.initial;

import java.util.Date;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.EncryptUtils;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.Comment;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

public final class QingMaker {

	private QueryService queryService;

	private ResourceService resourceService;

	private BaseDao baseDao;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public Resource createResource(String alias, Resource parent,
			boolean isSystem) {
		return createResource(alias, parent, isSystem, null, null, null);
	}

	public Resource createResource(String alias, Resource parent,
			boolean isSystem, Long typeId, Resource account, Resource group) {
		Resource res = new Resource();
		res.setAlias(alias);
		res.setSystemNode(isSystem);
		res.setActive(true);
		res.setCreatedDt(new Date());
		res.setLastUpdatedDt(new Date());
		res.setParentId(parent == null ? null : parent.getId());
		res.setTypeId(typeId == null ? null : typeId);
		res.setOwnResourceId(account == null ? null : account.getId());
		res.setOwnGroupResourceId(group == null ? null : group.getId());
		res.setLastAccountResourceId(null);
		res.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		res.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		res.setOthersPermission(CommonConstants.PERMISSION.READ);
		baseDao.saveObject(res);
		return res;
	};

	public Type createType(String alias, String className, Resource parent) {
		Resource res = createResource(alias, parent, true,
				CommonConstants.TYPE.TYPE, null, null);
		Type type = new Type();
		type.setResource(res);
		type.setTypeKey(alias);
		type.setEntityClassName(className);
		baseDao.saveObject(type);
		res.setObject(type);
		return type;
	}

	public Account createAccount(String loginName, String password,
			String umask, Resource parent) {
		Resource res = createResource(loginName, parent, true,
				CommonConstants.TYPE.ACCOUNT, null, null);
		Resource homeRes = createResource("." + loginName, parent, true,
				CommonConstants.TYPE.RESOURCE, null, null);
		createResource(".group", homeRes, true, CommonConstants.TYPE.RESOURCE,
				null, null);
		createResource(".privilege", homeRes, true,
				CommonConstants.TYPE.RESOURCE, null, null);
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
				CommonConstants.TYPE.GROUP, null, null);
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
				CommonConstants.TYPE.ACCOUNT_2_GROUP, null, null);
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
				parent, true, CommonConstants.TYPE.PRIVILEGE, null, null);
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
				CommonConstants.TYPE.APPLICATION, null, null);
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
		app.setParent$12(null);
		baseDao.saveObject(app);
		res.setObject(app);
		return app;
	}

	public MenuItem createMenu(String name, String title, Resource parent) {
		Resource res = createResource(name, parent, true,
				CommonConstants.TYPE.MENUITEM, null, null);
		Resource childrenRes = createResource("." + name, parent, false,
				CommonConstants.TYPE.RESOURCE, null, null);
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
				CommonConstants.TYPE.MENUITEM, null, null);
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

	public Limit createLimit(String name, Long limitValue, Long currentValue,
			Resource parent, Resource account, Resource group) {
		Resource res = createResource(name, parent, true,
				CommonConstants.TYPE.LIMIT, account, group);
		Limit limit = new Limit();
		limit.setResource(res);
		limit.setLimitName(name);
		limit.setLimitValue(limitValue);
		limit.setCurrentValue(currentValue);
		baseDao.saveObject(limit);
		res.setObject(limit);
		return limit;
	}
	
	public Comment createComment(String name, String value,
			Resource parent, Resource account, Resource group){
		Resource res = createResource(name, parent, true,
				CommonConstants.TYPE.COMMENT, account, group);
		Comment comment = new Comment();
		comment.setResource(res);
		comment.setText(value.toCharArray());
		//comment.setReply$39(null);
		baseDao.saveObject(comment);
		res.setObject(comment);
		return comment;
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
