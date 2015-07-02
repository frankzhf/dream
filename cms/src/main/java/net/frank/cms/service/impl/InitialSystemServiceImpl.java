package net.frank.cms.service.impl;

import net.frank.commons.CommonConstants;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;

public class InitialSystemServiceImpl implements InitialService {
	
	private static final String ADMIN_GROUP = "Admin";
	
	private static final String ADMIN_ACCOUNT = "root";
	
	private QueryService queryService;
	
	private ResourceService resourceService;
	
	private QingMaker qingMaker;
	
	private BaseDao baseDao;
	
	public void setQueryService(QueryService queryService){
		this.queryService = queryService;
	}
	
	public void setResourceService(ResourceService resourceService){
		this.resourceService = resourceService;
	}
	
	public void setQingMaker(QingMaker qingMaker){
		this.qingMaker = qingMaker;
	}
	
	public void setBaseDao(BaseDao baseDao){
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean checkAppInitial() {
		return false;
	}

	@Override
	public boolean checkUserWorkspace(Session session) {
		return false;
	}

	@Override
	public void initialApp() {
		Session session = RootSessionHolder.getDefaultRootSession();
		Resource root = qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.ROOT,null,true);
		Resource typeRoot = qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.TYPE_ROOT,root,true);
		Type resourceType = qingMaker.createType("RESOURCE","net.frank.framework.bo.Resource",typeRoot);
		root.setTypeId(resourceType.getResource().getId());
		baseDao.saveObject(root);
		typeRoot.setTypeId(resourceType.getResource().getId());
		baseDao.saveObject(typeRoot);
		
		qingMaker.createType("TYPE","net.frank.framework.bo.Type",typeRoot);
		qingMaker.createType("ACCOUNT","net.frank.framework.bo.Account",typeRoot);
		qingMaker.createType("GROUP","net.frank.framework.bo.Group",typeRoot);
		qingMaker.createType("ACCOUNT2GROUP","net.frank.framework.bo.Account2Group",typeRoot);
		qingMaker.createType("PRIVILEGE","net.frank.framework.bo.Privilege",typeRoot);
		qingMaker.createType("ARTICLE","net.frank.framework.bo.Article",typeRoot);
		qingMaker.createType("ATTACH","net.frank.framework.bo.Attach",typeRoot);
		qingMaker.createType("IMAGE","net.frank.framework.bo.Image",typeRoot);
		qingMaker.createType("APPLICATION","net.frank.framework.bo.Application",typeRoot);
		qingMaker.createType("MENUITEM","net.frank.framework.bo.MenuItem",typeRoot);
		qingMaker.createType("UNIT","net.frank.framework.bo.Unit",typeRoot);
		qingMaker.createType("PERSON","net.frank.framework.bo.Person",typeRoot);
		qingMaker.createType("STAFF","net.frank.framework.bo.Staff",typeRoot);
		qingMaker.createType("LIMIT","net.frank.framework.bo.Limit",typeRoot);
		qingMaker.createType("COMMENT","net.frank.framework.bo.Comment",typeRoot);
		
		Resource homeRes = qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.HOME_ROOT,
				root,true,CommonConstants.TYPE.RESOURCE,null,null);
		final Account rootAccount = qingMaker.createAccount(ADMIN_ACCOUNT,"p@ssw0rd","774",homeRes);
		
		Resource groupRes = qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.GROUPS_ROOT,
				root,true,CommonConstants.TYPE.RESOURCE,null,null);
		final Group adminGroup = qingMaker.createGroup(ADMIN_GROUP,groupRes);
		qingMaker.createGroup("User",groupRes);
		qingMaker.createGroup("Self",groupRes);
		qingMaker.createGroup("Guest",groupRes);
		
		qingMaker.createA2g(rootAccount.getResource(),
				adminGroup.getResource(),queryService.
				getResourceAsPath("/home/.root/.group"));
		qingMaker.createA2p(rootAccount.getResource(),root,queryService.
				getResourceAsPath("/home/.root/.privilege"));
		
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.OPT_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.DICTIONARIES_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.UNIT_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.RECYCLE_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.STAFF_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.PERSON_ROOT,root,true,CommonConstants.TYPE.RESOURCE,null,null);
		
		Resource varRes = qingMaker.createResource(CommonConstants.RESOURCE_ALIAS.VAR_ROOT,
				root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createLimit("SystemNextValue", null, 45L, varRes, rootAccount.getResource(), adminGroup.getResource());
		qingMaker.createLimit("TypeRegistratorNextValue", null, 50000L, varRes, rootAccount.getResource(), adminGroup.getResource());
		qingMaker.createLimit("DirectoryNextValue", null, 100000L, varRes, rootAccount.getResource(), adminGroup.getResource());
		qingMaker.createLimit("TemplateNextValue", null, 300000L, varRes, rootAccount.getResource(), adminGroup.getResource());
		
		Resource phaseHome = qingMaker.createResource("phase",root,true,CommonConstants.TYPE.RESOURCE,null,null);
		qingMaker.createResource("unit",phaseHome,true,CommonConstants.TYPE.RESOURCE,null,null);
		
		//qingMaker.createComment("repository", "net.frank.repository.organization.AddUnitPhase", phaseUnitHome, rootAccount.getResource(), adminGroup.getResource());
		
		Resource _root = queryService.getResourceWithRecursive(root);
		resourceService.saveResourceWithRecursive(_root, session,false,new ResourceFilter() {
			@Override
			public boolean filter(Resource resource) {
				resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
				resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
				resource.setOthersPermission(CommonConstants.PERMISSION.READ);
				resource.setOwnResourceId(rootAccount.getResource().getId());
				resource.setOwnGroupResourceId(adminGroup.getResource().getId());
				resource.setLastAccountResourceId(rootAccount.getResource().getId());
				return true;
			}
		});
		
		Resource _res = queryService.getResourceAsPath("/resType/ACCOUNT");
		_res.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		_res.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		_res.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(_res);
		
		_res = queryService.getResourceAsPath("/resType/GROUP");
		_res.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		_res.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		_res.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(_res);
		
		_res = queryService.getResourceAsPath("/resType/ACCOUNT2GROUP");
		_res.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		_res.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		_res.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(_res);
		
		_res = queryService.getResourceAsPath("/resType/PRIVILEGE");
		_res.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		_res.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
		_res.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(_res);
	}

	@Override
	public void initialUserWorkspace(Session session) {
		
	}

}
