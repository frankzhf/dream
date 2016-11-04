package net.frank.tasklist.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import net.frank.cms.service.AdminService;
import net.frank.cms.service.TypeRegistrationService;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.tasklist.CommonConstants;

public class InitialTasklistServiceImpl implements InitialService {
	private transient Logger log = Logger.getLogger(getClass());
	
	private QingMaker qingMaker;
	
	private AdminService adminTarget;
	
	private QueryService queryService;
	
	private ResourceService resourceService;
	
	private TypeRegistrationService typeRegistrationTarget;
	
	public void setQingMaker(QingMaker qingMaker){
		this.qingMaker = qingMaker;
	}
	
	public void setQueryService(QueryService queryService){
		this.queryService = queryService;
	}
	
	public void setResourceService(ResourceService resourceService){
		this.resourceService = resourceService;
	}
	
	public void setAdminTarget(AdminService adminTarget){
		this.adminTarget = adminTarget;
	}
	
	public void setTypeRegistrationTarget(TypeRegistrationService typeRegistrationTarget){
		this.typeRegistrationTarget = typeRegistrationTarget;
	}
	@Override
	public boolean checkAppInitial() {
		Resource currApp = queryService.getResourceAsPath("/opt/tasklistApp");
		if(currApp == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkUserWorkspace(Session session) {
		if(session != null &&
				session.getAccount()!=null && 
				session.getAccount().getHome$3()!= null){
			Resource resHome  = session.getAccount().getHome$3();
			Resource tasklistRes = queryService.getResource(resHome.getId(), CommonConstants.USER_WORKSPACE_ROOT_ALIAS);
			if(tasklistRes==null){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

	@Override
	public void initialApp() {
		log.info("Start Init TaskList");
		Resource groupRes = qingMaker.getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		
		adminTarget.addAccount("tasklist-adm", "p@ssw0rd", rootSession);
		Resource appAdmin = queryService.getResourceAsPath("/home/tasklist-adm");
		Resource appGroupRes = queryService.getResourceAsPath("/home/.tasklist-adm/.group");
		
		qingMaker.createA2g(appAdmin, groupRes, appGroupRes);
		qingMaker.createA2g(appAdmin, groupSelfRes, appGroupRes);
		Application currApp = qingMaker.createApp("tasklistApp", queryService.getResourceAsPath("/opt"),"/resType;/opt/.tasklistApp/type", rootSession, appAdmin);
		
		Resource resCmsApp = queryService.getResourceAsPath("/opt/cmsApp");
		Application cmsApp = (Application)queryService.getBo(resCmsApp);
		
		cmsApp.setTypePaths(new String(cmsApp.getTypePaths()).concat(";/opt/.tasklistApp/type").toCharArray());
		resourceService.saveObject(cmsApp);
		
		//registration type
		typeRegistrationTarget.registrationType("net.frank.tasklist.bo.Task", "", "TASK", currApp, rootSession);
		typeRegistrationTarget.registrationType("net.frank.tasklist.bo.TaskToken", "", "TASKTOKEN", currApp, rootSession);
		
		//Init template
		Resource templateRoot = queryService.getResource(
				CommonConstants.RESOURCE_ID.ROOT,
				CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT);
		
		Resource resRootAccount = qingMaker.getRootAccount();
		//Init template for Task
		/*
		 * add template for Task
		 * ${templateContextRoot}
		 * 		|--task(create)
		 * 			|--children(create)
		 * 			|--token(create)
		 */
		Resource taskTemplate = qingMaker.createResource("task", templateRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.CONTEXT.TASK.CHILDREN, taskTemplate,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.CONTEXT.TASK.TOKEN, taskTemplate,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		
		//Init template for TaskToken
		/*
		 * add template for TaskToken
		 * ${templateContextRoot}
		 * 		|--taskToken(create)
		 * 			|--attach(create)
		 * 			|--screenshot(create)
		 * 			|--comment(create)
		 */
		Resource taskTokenTemplate = qingMaker.createResource("taskToken", templateRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.CONTEXT.TASKTOKEN.ATTACH, taskTokenTemplate,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.CONTEXT.TASKTOKEN.SCREENSHOT, taskTokenTemplate,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.CONTEXT.TASKTOKEN.COMMENT, taskTokenTemplate,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		
		//add sub template for account
		/*
		 * add template for account
		 * ${account_context}
		 * 			|--tasklist(create)
		 * 					|--draft(create)
		 * 					|--myTask(create)
		 * 					|--pendingTask(create)
		 * 
		 */
		Resource resTemplateAccount = queryService.getResourceAsPath("/contextTemplate/account");
		Resource resUserTasklistRoot = qingMaker.createResource(CommonConstants.USER_WORKSPACE_ROOT_ALIAS, resTemplateAccount,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_MY_TASK, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_PENDING_TASK, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_DRAFT, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		
		//add sub template for unit
		/*
		 * add template for unit
		 * ${unit_context}
		 * 			|--tasklist(create)
		 * 					|--task(create)
		 * 
		 */
		Resource resTemplateUnit = queryService.getResourceAsPath("/contextTemplate/unit");
		qingMaker.createResource(CommonConstants.CONTEXT.UNIT.TASKLIST, resTemplateUnit,false,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		
		
		final Long ownGroupId = groupRes.getId();
		final Long ownId = appAdmin.getId();
		
		Resource _menu = queryService.getResourceAsPath("/opt/.tasklistApp/menu");
		MenuItem coreMenu = qingMaker.createMenu("admin","common.menu.admin",_menu);
		MenuItem selfMenu = qingMaker.createMenu("self","common.header.self", _menu);
		MenuItem tasklistMenu = qingMaker.createMenu("tasklist","common.header.tasklist", _menu);
		
		qingMaker.createMenuItem("browser","menu.item.browser","/core/cmsBrower.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("permission","menu.item.permission","/core/cmsPermission.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("move","menu.item.move","/core/cmsMove.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("activation","menu.item.activation","/core/activationAccount.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("listSession","menu.item.list.session","/core/listSession.do","body", coreMenu.getChildren$3());
		
		qingMaker.createMenuItem("viewMe","menu.item.self.view.me","/self/myInfo.do","body", selfMenu.getChildren$3());
		qingMaker.createMenuItem("myOrg","menu.item.self.org","/admin/myOrg.do","body", selfMenu.getChildren$3());
		
		qingMaker.createMenuItem("dashboard","memu.item.dashboard","/tasklist/dashboard.do","body", tasklistMenu.getChildren$3());
		qingMaker.createMenuItem("createDraft","menu.item.create.draft","/tasklist/createDraft.do","body", tasklistMenu.getChildren$3());
		
		Resource _aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/admin");
		Acl acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.admin/browser");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.admin/permission");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.admin/move");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.admin/activation");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.admin/listSession");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		//Resource _self = queryService.getResourceAsPath("/group/Self");
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/self");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupSelfRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.self/viewMe");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(groupSelfRes.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _3410_User = queryService.getResourceAsPath("/unit/.3410/group/Staff");
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.self/myOrg");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/tasklist");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.tasklist/dashboard");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.tasklistApp/menu/.tasklist/createDraft");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _src = queryService.getResourceAsPath("/opt/.tasklistApp");
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
		log.info("End Init Tasklist");
	}
	/***
	 * 
	 * account.home$3
	 * 			|---tasklist
	 * 					|--- draft
	 * 					|--- myTask
	 * 					|--- pendingTask
	 * permission 700
	 * accountResId ${self}
	 * groupResId self
	 */
	@Override
	public void initialUserWorkspace(Session session) {
		Resource selfRes = queryService.getResourceAsPath(CommonConstants.PATH.SELF_GROUP);
		Resource resHome  = session.getAccount().getHome$3();
		Resource resUserTasklistRoot = qingMaker.createResource(CommonConstants.USER_WORKSPACE_ROOT_ALIAS, resHome,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_MY_TASK, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_PENDING_TASK, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_DRAFT, resUserTasklistRoot,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
	}
	
	private void initExistsUnit(Unit currentUnit,Resource unitContext,Session session){
		log.info("Init Exists Unit Start : " + currentUnit.getUnitName() + "(" + currentUnit.getUnitCode() + ")");
		Resource resTasklist = queryService.getResource(unitContext.getId(), CommonConstants.CONTEXT.UNIT.TASKLIST);
		if(resTasklist == null){
			Resource unitAdminAccount = queryService.getResourceAsPath(CommonConstants.PATH.HOME
					+ "/Unit-admin-" + currentUnit.getUnitCode());
			Resource unitGroup = currentUnit.getGroup$6();
			qingMaker.createResource(CommonConstants.CONTEXT.UNIT.TASKLIST,
					unitContext,false,CommonConstants.TYPE.RESOURCE,unitAdminAccount,unitGroup);
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
