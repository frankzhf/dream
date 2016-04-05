package net.frank.repository.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import net.frank.cms.service.AdminService;
import net.frank.cms.service.TypeRegistrationService;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.Comment;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.organization.UnitPhase;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.repository.CommonConstants;
import net.frank.repository.organization.AddUnitPhase;

public class InitialRepositoryServiceImpl implements InitialService {
	
	private transient Logger log = Logger.getLogger(getClass());
	
	private static final String DEFAULT_READ_UNIT_GROUP_PATH = "/unit/.7576/group/Staff";
	
	private static final String USER_SPACE_FOLDER_MY_DOCUMENT = "myDocument";
	private static final String USER_SPACE_FOLDER_RECYCLE_BIN = "recycleBin";
	
	private static final String UNIT_CONTEXT_REPOSITORY_FOLDER = "repository";
	private static final String UNIT_CONTEXT_PUBLISHED_FOLDER = "published";
	private static final String UNIT_CONTEXT_PENDING_FOLDER = "pending";
	private static final String UNIT_CONTEXT_ARCHIVE_FOLDER = "archive";
	private static final String UNIT_CONTEXT_COMMON_FOLDER = "Common Software";
	private static final String UNIT_CONTEXT_JAVA_FOLDER = "Java";
	private static final String UNIT_CONTEXT_DOTNET_FOLDER = "DotNet";
	
	private QueryService queryService;
	
	private ResourceService resourceService;
	
	private QingMaker qingMaker;
	
	private BaseDao baseDao;
	
	private AdminService adminService;
	
	private TypeRegistrationService typeRegistrationTarget;
	
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
	
	public void setAdminService(AdminService adminService){
		this.adminService = adminService;
	}
	
	public void setTypeRegistrationTarget(TypeRegistrationService typeRegistrationTarget){
		this.typeRegistrationTarget = typeRegistrationTarget;
	}
	
	@Override
	public boolean checkAppInitial() {
		Resource currApp = queryService.getResourceAsPath("/opt/repositoryApp");
		if(currApp == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkUserWorkspace(Session session) {
		Account account = session.getAccount(); 
		Resource resAccountContent = account.getHome$3();
		Resource resRepository = queryService.getResource(resAccountContent.getId(), 
				CommonConstants.CONTEXT.ACCOUNT.REPOSITORY);
		if(resRepository==null)
			return true;
		else
			return false;
	}
	/*
	 * (non-Javadoc)
	 * @see net.frank.framework.app.InitialService#initialApp()
	 * 
	 */
	@Override
	public void initialApp() {
		log.info("Init Repository Start.");
		Resource groupAdminRes = qingMaker.getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		
		adminService.addAccount("repository-adm", "p@ssw0rd", rootSession);
		Resource appAdmin = queryService.getResourceAsPath("/home/repository-adm");
		Resource appGroupRes = queryService.getResourceAsPath("/home/.repository-adm/.group");
		
		qingMaker.createA2g(appAdmin, groupAdminRes, appGroupRes);
		qingMaker.createA2g(appAdmin, groupSelfRes, appGroupRes);
		Application currApp = qingMaker.createApp("repositoryApp", queryService.getResourceAsPath("/opt"), "/resType;/opt/.repositoryApp/type", rootSession, appAdmin);
		
		typeRegistrationTarget.registrationType("net.frank.repository.bo.File", "", "FILE", currApp, rootSession);
		typeRegistrationTarget.registrationType("net.frank.repository.bo.SharedRequest", "", "SHAREDREQUEST", currApp, rootSession);
		
		Resource resCmsApp = queryService.getResourceAsPath("/opt/cmsApp");
		Application cmsApp = (Application)queryService.getBo(resCmsApp);
		
		cmsApp.setTypePaths(new String(cmsApp.getTypePaths()).concat(";/opt/.repositoryApp/type").toCharArray());
		resourceService.saveObject(cmsApp);
		
		//registration common add Unit phase
		Resource resPhaseUnitRoot = queryService.getResourceAsPath("/phase/unit");
		if(resPhaseUnitRoot!=null){
			qingMaker.createComment("repsoitoryAddUnitPhase", "net.frank.repository.organization.AddUnitPhase", resPhaseUnitRoot, groupAdminRes, appGroupRes);
		}
		
		
		Resource repositoryApp = queryService.getResourceAsPath("/opt/repositoryApp");
		repositoryApp.setOwnResourceId(appAdmin.getId());
		repositoryApp.setOwnGroupResourceId(groupAdminRes.getId());
		resourceService.saveObject(repositoryApp);
		
		final Long ownGroupId = groupAdminRes.getId();
		final Long ownId = appAdmin.getId();
		
		//menu && menu item
		Resource _menu = queryService.getResourceAsPath("/opt/.repositoryApp/menu");
		MenuItem coreMenu = qingMaker.createMenu("admin","common.menu.admin",_menu);
		MenuItem selfMenu = qingMaker.createMenu("self","common.header.self", _menu);
		MenuItem repositoryMenu = qingMaker.createMenu("repositories","common.header.my.repositories", _menu);
		
		qingMaker.createMenuItem("browser","menu.item.browser","/core/cmsBrower.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("permission","menu.item.permission","/core/cmsPermission.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("move","menu.item.move","/core/cmsMove.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("activation","menu.item.activation","/core/activationAccount.do","body", coreMenu.getChildren$3());
		
		qingMaker.createMenuItem("viewMe","menu.item.self.view.me","/self/myInfo.do","body", selfMenu.getChildren$3());
		qingMaker.createMenuItem("myOrg","menu.item.self.org","/admin/myOrg.do","body", selfMenu.getChildren$3());
		
		qingMaker.createMenuItem("myFiles","memu.item.my.files","/repository/myFiles.do","body", repositoryMenu.getChildren$3());
		qingMaker.createMenuItem("myRecycleBin","memu.item.my.recycle.bin","/repository/myRecycleBin.do","body", repositoryMenu.getChildren$3());
		qingMaker.createMenuItem("myProjects","memu.item.my.projects","/repository/myProjects.do","body", repositoryMenu.getChildren$3());
		
		
		//setup menu && menu item're ACL
		Resource _admin = queryService.getResourceAsPath("/group/Admin");
		Resource _aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/admin");
		Acl acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.admin/browser");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.admin/permission");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.admin/move");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.admin/activation");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/self");
		Resource _self = queryService.getResourceAsPath("/group/Self");
		acl = new Acl();
		
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.self/viewMe");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.self/myOrg");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(queryService.getResourceAsPath(DEFAULT_READ_UNIT_GROUP_PATH).getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/repositories");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.repositories/myFiles");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.repositories/myRecycleBin");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource readUnitGroup = queryService.getResourceAsPath(DEFAULT_READ_UNIT_GROUP_PATH);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.repositories/myProjects");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(readUnitGroup.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _src = queryService.getResourceAsPath("/opt/.repositoryApp");
		_src = queryService.getResourceWithRecursive(_src);
		resourceService.saveResourceWithRecursive(_src, rootSession, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
				resoruce.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
				resoruce.setOthersPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(ownGroupId);
				return true;
			}
		});
		
		appAdmin.setOwnResourceId(appAdmin.getId());
		appAdmin.setOwnGroupResourceId(groupSelfRes.getId());
		appAdmin.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		appAdmin.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
		appAdmin.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(appAdmin);
		
		//init account template
		/*
		 * add template for account
		 * ${account_context}
		 * 			|--.config
		 * 					|--PERSON_REPOSITORY_SZIE[Limit](create)
		 * 			|--repository(create)
		 * 					|--myDocument(create)
		 * 					|--recycleBin(create)
		 * 
		 * 
		 */
		Resource accountRootRes = qingMaker.getRootAccount();
		Resource accountTemplateConfigFolderRes = queryService.getResourceAsPath("/contextTemplate/account/.config");
		qingMaker.createLimit("PERSON_REPOSITORY_SZIE",536870912L, 0L, accountTemplateConfigFolderRes, accountRootRes, groupAdminRes);
		
		Resource accountTemplateFolderRes = queryService.getResourceAsPath("/contextTemplate/account");
		Resource accountTemplateRepositoryRes = qingMaker.createResource(CommonConstants.CONTEXT.ACCOUNT.REPOSITORY, accountTemplateFolderRes, true, CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(USER_SPACE_FOLDER_MY_DOCUMENT,accountTemplateRepositoryRes,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(USER_SPACE_FOLDER_RECYCLE_BIN,accountTemplateRepositoryRes,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		
		/***
		 * 
		 * add template for unit
		 * ${unit_context}
		 * 			|--repository (create)
		 * 					|--published(create)
		 * 					|		|--Common Software(create)
		 * 					|		|--Java(create)
		 * 					|		|--DotNet(create)
		 * 					|--pending(create)
		 * 					|--archive(create)
		 */
		
		Resource unitTemplateFolderRes = queryService.getResourceAsPath("/contextTemplate/unit");
		Resource resRepository = qingMaker.createResource(UNIT_CONTEXT_REPOSITORY_FOLDER,unitTemplateFolderRes,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		Resource resPublished = qingMaker.createResource(UNIT_CONTEXT_PUBLISHED_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(UNIT_CONTEXT_PENDING_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(UNIT_CONTEXT_ARCHIVE_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		
		qingMaker.createResource(UNIT_CONTEXT_COMMON_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(UNIT_CONTEXT_JAVA_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		qingMaker.createResource(UNIT_CONTEXT_DOTNET_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
				accountRootRes, groupAdminRes);
		
		//Update exists Unit context
		
		Resource resUnitFolder = queryService.getResourceAsPath(CommonConstants.RESOURCE_ALIAS.ROOT + CommonConstants.RESOURCE_ALIAS.UNIT_ROOT);
		List<Resource> children = queryService.retrieveResourceByParent(resUnitFolder.getId());
		for(Iterator<Resource> it=children.iterator();it.hasNext();){
			Resource child = it.next();
			if(CommonConstants.TYPE.UNIT.equals(child.getTypeId())){
				Unit currentUnit = (Unit)queryService.getBo(child);
				Resource unitContext = currentUnit.getContext$3();
				initExistsUnit(currentUnit,unitContext,rootSession);
			}
		}
		log.info("Init Repository End.");
	}
	/***
	 * Fix repository for account
	 * ${account_context}
	 * 			|--.config
	 * 					|--PERSON_REPOSITORY_SZIE[Limit](create)
	 * 			|--repository(create)
	 * 					|--myDocument(create)
	 * 					|--recycleBin(create)
	 */
	@Override
	public void initialUserWorkspace(Session session) {
		String loginName = session.getLoginName();
		StringBuffer yourHomeContextPath = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		yourHomeContextPath.append(CommonConstants.PATH.HOME).append(CommonConstants.PATH_SYMBOL).append(CommonConstants.POINT).append(loginName);
		log.debug("your home context path : " + yourHomeContextPath.toString());
		Resource parent = queryService.getResourceAsPath(yourHomeContextPath.toString());
		Resource resSelfGroup = queryService.getResourceAsPath("/group/Self");
		Resource resRootAccount = qingMaker.getRootAccount();
		Resource resAdminGroup = qingMaker.getAdminGroup();
		if(parent!=null){
			Resource resAccountConfigFolder = queryService.getResourceAsPath(parent,CommonConstants.CONTEXT.ACCOUNT.CONFIG);
			qingMaker.createLimit("PERSON_REPOSITORY_SZIE",536870912L, 0L, resAccountConfigFolder, resRootAccount, resAdminGroup);
			Resource repositoryFolder = qingMaker.createResource(CommonConstants.CONTEXT.ACCOUNT.REPOSITORY, parent, true, CommonConstants.TYPE.RESOURCE,
					session.getAccount().getResource(), resSelfGroup);
			qingMaker.createResource(USER_SPACE_FOLDER_MY_DOCUMENT, repositoryFolder, true, CommonConstants.TYPE.RESOURCE,
					session.getAccount().getResource(), resSelfGroup);
			qingMaker.createResource(USER_SPACE_FOLDER_RECYCLE_BIN, repositoryFolder, true, CommonConstants.TYPE.RESOURCE,
					session.getAccount().getResource(), resSelfGroup);		
			Resource _repositoryFolder = queryService.getResourceWithRecursive(repositoryFolder);
			Session rootSession = RootSessionHolder.getDefaultRootSession();
			resourceService.saveResourceWithRecursive(_repositoryFolder, rootSession, new ResourceFilter(){
				@Override
				public boolean filter(Resource resource) {
					resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
					resource.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
					resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
					return true;
				}
			});
		}
	}
	
	private void initExistsUnit(Unit currentUnit,Resource unitContext,Session session){
		log.info("Init Exists Unit Start : " + currentUnit.getUnitName() + "(" + currentUnit.getUnitCode() + ")");
		Resource resRepository = queryService.getResource(unitContext.getId(), CommonConstants.CONTEXT.UNIT.REPOSITORY);
		if(resRepository == null){
			Resource unitAdminAccount = queryService.getResourceAsPath(CommonConstants.PATH.HOME
					+ "/Unit-admin-" + currentUnit.getUnitCode());
			Resource unitGroup = currentUnit.getGroup$6();
			
			
			resRepository = qingMaker.createResource(CommonConstants.CONTEXT.UNIT.REPOSITORY,
					unitContext,false,CommonConstants.TYPE.RESOURCE,unitAdminAccount,unitGroup);
			
			Resource resPublished = qingMaker.createResource(UNIT_CONTEXT_PUBLISHED_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			qingMaker.createResource(UNIT_CONTEXT_PENDING_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			qingMaker.createResource(UNIT_CONTEXT_ARCHIVE_FOLDER,resRepository,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			qingMaker.createResource(UNIT_CONTEXT_COMMON_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			qingMaker.createResource(UNIT_CONTEXT_JAVA_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			qingMaker.createResource(UNIT_CONTEXT_DOTNET_FOLDER,resPublished,true,CommonConstants.TYPE.RESOURCE,
					unitAdminAccount, unitGroup);
			
			UnitPhase addUnitPhase = new AddUnitPhase();
			addUnitPhase.exec(currentUnit, unitContext, session);
			Resource childrenFolder = queryService.getResource(unitContext.getId(), CommonConstants.CONTEXT.UNIT.CHILDREN);
			List<Resource> children = queryService.retrieveResourceByParent(childrenFolder.getId());
			for(Iterator<Resource> it=children.iterator();it.hasNext();){
				Resource child = it.next();
				if(CommonConstants.TYPE.UNIT.equals(child.getTypeId())){
					Unit childUnit = (Unit)queryService.getBo(child);
					Resource childUnitContext = childUnit.getContext$3();
					initExistsUnit(childUnit,childUnitContext,session);
				}
			}
		}
		log.info("Init Exists Unit End : " + currentUnit.getUnitName() + "(" + currentUnit.getUnitCode() + ")");
	}
}
