package net.frank.knowledge.service.impl;

import org.apache.log4j.Logger;

import net.frank.cms.service.AdminService;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.knowledge.CommonConstants;

public class InitialKnowledgeServiceImpl implements InitialService {
	private transient Logger log = Logger.getLogger(getClass());
	
	private QingMaker qingMaker;
	
	private QueryService queryService;
	
	private AdminService adminTarget;
	
	private ResourceService resourceService;
	
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
	
	@Override
	public boolean checkAppInitial() {
		Resource currApp = queryService.getResourceAsPath("/opt/knowledgeApp");
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
			Resource knowlodgeRes = queryService.getResource(resHome.getId(),
					CommonConstants.USER_WORKSPACE_ROOT_ALIAS);
			if(knowlodgeRes == null){
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
		log.info("Start Init Knowledge");
		Resource groupRes = qingMaker.getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		adminTarget.addAccount("knowledge-adm", "p@ssw0rd", rootSession);
		
		Resource appAdmin = queryService.getResourceAsPath("/home/knowledge-adm");
		Resource appGroupRes = queryService.getResourceAsPath("/home/.knowledge-adm/.group");
		
		qingMaker.createA2g(appAdmin, groupRes, appGroupRes);
		qingMaker.createA2g(appAdmin, groupSelfRes, appGroupRes);	
		
		//Application currApp = 
		qingMaker.createApp("knowledgeApp",
				queryService.getResourceAsPath("/opt"),"/resType", rootSession, appAdmin);
		
		Resource resRootAccount = qingMaker.getRootAccount();
		
		//add template for account
		/*
		 * 
		 * ${account_context}
		 * 			|--knowledge(create)
		 * 					|--draft(create)
		 * 					|--published(create)
		 * 
		 */
		Resource resTemplateAccount = queryService.getResourceAsPath("/contextTemplate/account");
		Resource resUserKnowledgeRoot = qingMaker.createResource(CommonConstants.USER_WORKSPACE_ROOT_ALIAS, resTemplateAccount,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_DRAFT, resUserKnowledgeRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_PUBLISHED, resUserKnowledgeRoot,true,
				CommonConstants.TYPE.RESOURCE, resRootAccount, groupRes);
		
		Resource _menu = queryService.getResourceAsPath("/opt/.knowledgeApp/menu");
		MenuItem coreMenu = qingMaker.createMenu("admin","common.menu.admin",_menu);
		MenuItem selfMenu = qingMaker.createMenu("self","common.header.self", _menu);
		MenuItem knowledgeMenu = qingMaker.createMenu("knowledge","common.header.my.knowledge", _menu);
		
		qingMaker.createMenuItem("browser","menu.item.browser","/core/cmsBrower.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("permission","menu.item.permission","/core/cmsPermission.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("move","menu.item.move","/core/cmsMove.do","body", coreMenu.getChildren$3());
		qingMaker.createMenuItem("activation","menu.item.activation","/core/activationAccount.do","body", coreMenu.getChildren$3());
		
		qingMaker.createMenuItem("viewMe","menu.item.self.view.me","/self/myInfo.do","body", selfMenu.getChildren$3());
		qingMaker.createMenuItem("myOrg","menu.item.self.org","/admin/myOrg.do","body", selfMenu.getChildren$3());
		
		qingMaker.createMenuItem("myDrafts","memu.item.my.drafts","/knowledge/myDrafts.do","body", knowledgeMenu.getChildren$3());
		qingMaker.createMenuItem("listCurrentWeek","memu.item.current.week","/knowledge/listCurrentWeek.do","body", knowledgeMenu.getChildren$3());
		qingMaker.createMenuItem("listCurrentMonth","menu.item.current.month","/knowledge/listCurrentMonth.do","body", knowledgeMenu.getChildren$3());
		qingMaker.createMenuItem("listAll","menu.item.more","/knowledge/listAll.do","body", knowledgeMenu.getChildren$3());
		
		Resource _admin = queryService.getResourceAsPath("/group/Admin");
		Resource _aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/admin");
		Acl acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.admin/browser");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.admin/permission");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.admin/move");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.admin/activation");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_admin.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _self = queryService.getResourceAsPath("/group/Self");
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/self");
		acl = new Acl();
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.self/viewMe");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/knowledge");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.knowledge/myDrafts");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.knowledge/listCurrentWeek");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.knowledge/listCurrentMonth");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.knowledge/listAll");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_self.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _3410_User = queryService.getResourceAsPath("/unit/.3410/group/Staff");
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.knowledgeApp/menu/.self/myOrg");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		Resource _src = queryService.getResourceAsPath("/opt/.knowledgeApp");
		
		final Long ownId = appAdmin.getId();
		final Long ownGroupId = groupRes.getId();
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
		
		final Long selfGroupId = groupSelfRes.getId();
		_src = queryService.getResourceAsPath("/home/.knowledge-adm");
		_src = queryService.getResourceWithRecursive(_src);
		
		resourceService.saveResourceWithRecursive(_src, rootSession, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
				resoruce.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOthersPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(selfGroupId);
				return true;
			}
		});
		
		appAdmin.setOwnResourceId(appAdmin.getId());
		appAdmin.setOwnGroupResourceId(groupSelfRes.getId());
		appAdmin.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		appAdmin.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
		appAdmin.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resourceService.saveObject(appAdmin);
		log.info("End Init Knowledge");
	}

	@Override
	public void initialUserWorkspace(Session session) {
		//add structure for current account
		/*
		 * ${account_context}
		 * 			|--knowledge(create)
		 * 					|--draft(create)
		 * 					|--published(create)
		 * 
		 */
		Resource selfRes = queryService.getResourceAsPath(CommonConstants.PATH.SELF_GROUP);
		Resource resHome  = session.getAccount().getHome$3();
		Resource resUserKnowledgeRoot = qingMaker.createResource(CommonConstants.USER_WORKSPACE_ROOT_ALIAS, resHome,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_DRAFT, resUserKnowledgeRoot,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		qingMaker.createResource(CommonConstants.USER_WORKSPACE_PUBLISHED, resUserKnowledgeRoot,true,
				CommonConstants.TYPE.RESOURCE, session.getAccount().getResource(), selfRes);
		
	}
}