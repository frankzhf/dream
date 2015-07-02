package net.frank.springweb.initial;

//import net.frank.cms.service.AdminService;
import net.frank.commons.CommonConstants;
import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.MenuItem;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.AccountService;
import net.frank.framework.service.ResourceFilter;

public class TestInitSpringWeb extends TestInitCase {
	
	protected static Byte ACCOUNT_PERMISSION = 7;

	protected static Byte GROUP_PERMISSION = 4;

	protected static Byte OTHERS_PERMISSION = 0;
	
	private AccountService accountService;
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml"};
	}
	
	public void testInit(){
		accountService = (AccountService)getBean("accountService");
		logger.info("Start Init Spring Web");
		
		Resource groupRes = getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		accountService.addAccount("cms-adm", "p@ssw0rd", cs);
		
		Resource appGroupRes = queryService.getResourceAsPath("/home/.cms-adm/.group");
		Resource appAccountRes = queryService.getResourceAsPath("/home/cms-adm");
		
		createA2g(appAccountRes, groupRes, appGroupRes);
		createA2g(appAccountRes, groupSelfRes, appGroupRes);
		
		createApp("cmsApp", queryService.getResourceAsPath("/opt"),"/resType", cs, appAccountRes);
		
		final Long ownGroupId = groupRes.getId();
		final Long ownId = appAccountRes.getId();
		
		Resource _menu = queryService.getResourceAsPath("/opt/.cmsApp/menu");
		//MenuItem selfMenu = createMenu("self","common.header.self", _menu);
		//MenuItem repositoryMenu = createMenu("repositories","common.header.my.repositories", _menu);
		
		//Resource _adminMenu = queryService.getResourceAsPath("/opt/.repositoryApp/menu/common.header.admin");
		//createMenuItem("viewMe","menu.item.self.view.me","/self//myInfo.do","body", selfMenu.getChildren$3());
		//createMenuItem("myOrg","menu.item.self.org","/admin/myOrg.do","body", selfMenu.getChildren$3());
		
		//Resource _repositoryMenu = queryService.getResourceAsPath("/opt/.repositoryApp/menu/common.header.my.repositories");
		//createMenuItem("myFiles","memu.item.my.files","/repository/myFiles.do","body", repositoryMenu.getChildren$3());
		//createMenuItem("myRecycleBin","memu.item.my.recycle.bin","/repository/myRecycleBin.do","body", repositoryMenu.getChildren$3());
		//createMenuItem("myProjects","memu.item.my.projects","/repository/myProjects.do","body", repositoryMenu.getChildren$3());
		
		//Resource _repositoryMenu = queryService.getResourceAsPath("/opt/.repositoryApp/group");
		//Resource _group = queryService.getResourceAsPath("/opt/.repositoryApp/group");
		//createGroup("repo-user", _group);
		//createGroup("repo-admin", _group);
		
		//final Resource _appUserGroup = queryService.getResourceAsPath("/opt/.repositoryApp/group/repo-user");
		//final Resource _appAdminGroup = queryService.getResourceAsPath("/opt/.repositoryApp/group/repo-admin");
		
		
		/***
		Resource _aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/self");
		Resource _self = queryService.getResourceAsPath("/group/Self");
		Acl acl = new Acl();
		
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
		
		Resource _src = queryService.getResourceAsPath("/opt/.repositoryApp");
		_src = queryService.getResourceWithRecursive(_src);
		resourceService.saveResourceWithRecursive(_src, cs, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(ACCOUNT_PERMISSION);
				resoruce.setCurrentGroupPermission(GROUP_PERMISSION);
				resoruce.setOthersPermission(OTHERS_PERMISSION);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(ownGroupId);
				return true;
			}
		});
		
		Resource appPriRes = resMap.get("/home/.repository-adm/.privilege");
		
		createA2p(appAccountRes, queryService.getResourceAsPath("/opt/.repositoryApp"), appPriRes);
		
		final Long selfGroupId = groupSelfRes.getId();
		_src = queryService.getResourceAsPath("/home/.repository-adm");
		_src = queryService.getResourceWithRecursive(_src);
		resourceService.saveResourceWithRecursive(_src, cs, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(ACCOUNT_PERMISSION);
				resoruce.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOthersPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(selfGroupId);
				return true;
			}
			
		});
		
		appAccountRes.setOwnResourceId(appAccountRes.getId());
		appAccountRes.setOwnGroupResourceId(groupSelfRes.getId());
		appAccountRes.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		appAccountRes.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
		appAccountRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(appAccountRes);
		
		//adminService.addAccount("henry", "p@ssw0rd", cs);
		//adminService.addAccount("shiyang", "p@ssw0rd", cs);
		//adminService.addAccount("weibing", "p@ssw0rd", cs);
		//adminService.addAccount("jianhua", "p@ssw0rd", cs);
		//adminService.addAccount("zhaofeng", "p@ssw0rd", cs);
		//adminService.addAccount("yinchu", "p@ssw0rd", cs);
		//adminService.addAccount("xiaolei", "p@ssw0rd", cs);
		//adminService.addAccount("huangjian", "p@ssw0rd", cs);		
				
		//adminService.addUnit("SZ-ODC", "3410", null, cs);
		
		//change group 3410-User => Staff
		Resource _3410_User = queryService.getResourceAsPath("/unit/.3410/group/3410-User");
		Group _3410_user_object = (Group)queryService.getBo(_3410_User.getId());
		
		_3410_user_object.setGroupName("Staff");
		_3410_user_object.getResource().setAlias("Staff");
		resourceService.saveOrUpdateBo(_3410_user_object,cs);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.self/myOrg");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		_aclMenuResource = queryService.getResourceAsPath("/opt/.repositoryApp/menu/.repositories/myProjects");
		acl.setResourceId(_aclMenuResource.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.RUN);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		Resource szUnit = queryService.getResourceAsPath("/unit/SZ-ODC");
		acl.setResourceId(szUnit.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.READ);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		szUnit = queryService.getResourceAsPath("/unit/.3410");
		acl.setResourceId(szUnit.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.READ);
		resourceService.saveObject(acl);
		
		acl = new Acl();
		szUnit = queryService.getResourceAsPath("/unit/.3410/children");
		acl.setResourceId(szUnit.getId());
		acl.setOwnId(_3410_User.getId());
		acl.setPermission(CommonConstants.PERMISSION.READ);
		resourceService.saveObject(acl);
		
		//Resource _3410
		Resource szContextChildrenRes = queryService.getResourceAsPath("/unit/SZ-ODC");
		//adminService.addUnit("3001", "34103001", szContextChildrenRes, cs);
		//adminService.addUnit("3002", "34103002", szContextChildrenRes, cs);
		Resource _3002ContextChildrenRes = queryService.getResourceAsPath("/unit/.3410/children/3002");
		//adminService.addUnit("3002A", "34103002A", _3002ContextChildrenRes, cs);
		
		
		Resource groupHome = queryService.getResourceAsPath("/group");
		groupHome = queryService.getResourceWithRecursive(groupHome);
		resourceService.saveResourceWithRecursive(groupHome, cs, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(ACCOUNT_PERMISSION);
				resoruce.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
				resoruce.setOthersPermission(CommonConstants.PERMISSION.NONE);
				return true;
			}
			
		});
		***/
		logger.info("End Init Spring Web");
	}

	
}
