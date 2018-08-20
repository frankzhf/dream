package net.frank.cms.initial;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import net.frank.cms.service.AdminService;
import net.frank.cms.service.CoreService;
import net.frank.commons.util.OsUtil;
import net.frank.framework.TestInitDbCase;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;

public final class TestInitSystem extends TestInitDbCase {
	
	private InitialService initialSystemService;
	private InitialService initialTemplateService;
	private InitialService initialCmsService;
	private AdminService adminService;
	private CoreService coreService;
	
	
	@Override
	public String[] getSpringConfig() {
		return new String[] { "/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-app.xml"};
	}
	
	@Override
	public void setUp() {
		super.setUp();
		initialSystemService = (InitialService)getBean("initialSystemService");
		initialTemplateService = (InitialService)getBean("initialTempleateService");
		initialCmsService = (InitialService)getBean("initialCmsService");
		adminService = (AdminService)getBean("adminService");
		coreService = (CoreService)getBean("coreService");
	}


	public void testCreateSchema()throws Exception {
		dropDatabaseSchema(configuration, sessionFactory);
		createDatabaseSchema(configuration, sessionFactory);
		init();
	}
	
	private void init()throws Exception{
		initialSystemService.initialApp();
		Properties p = configuration
				.getProperties();
		String dbDialect = (String)p.get("hibernate.dialect");
		String workspacePath = getCurrentWorkSpackPath();
		String sqlFile = workspacePath + File.separator + "src/main/init-sql/" + 
				dbDialect + File.separator + "init-template.sql";
		String command =  getSqlClientCommand(dbDialect, 
				"frank", "123456", "frank", sqlFile);
		Runtime runtime = Runtime.getRuntime();
		//String shCommand = "sh -c " + command;
		//logger.info(shCommand);
		String[] commandGroup =OsUtil.getOsBatchCommand(command);
		Process prc = runtime.exec(commandGroup);
		prc.waitFor();
		logger.info("Exceute SQL result :" + (prc.exitValue() ==0 ?"success":"failure"));
		initialTemplateService.initialApp();
		sqlFile = workspacePath + File.separator + "src/main/init-sql/" + 
				dbDialect + File.separator + "init-end.sql";
		command =  getSqlClientCommand(dbDialect, 
				"frank", "123456", "frank", sqlFile);
		//shCommand = "sh -c " + command;
		logger.info(command);
		commandGroup =OsUtil.getOsBatchCommand(command);
		prc = runtime.exec(commandGroup);
		prc.waitFor();
		logger.info("Exceute SQL result :" + (prc.exitValue() ==0 ?"success":"failure"));
		initialCmsService.initialApp();
		// init account and unit
		Session cs = RootSessionHolder.getDefaultRootSession();
		adminService.addAccount("henry", "p@ssw0rd", cs);
		adminService.addAccount("shiyang", "p@ssw0rd", cs);
		adminService.addAccount("weibing", "p@ssw0rd", cs);
		adminService.addAccount("jianhua", "p@ssw0rd", cs);
		adminService.addAccount("zhaofeng", "p@ssw0rd", cs);
		adminService.addAccount("yinchu", "p@ssw0rd", cs);
		adminService.addAccount("xiaolei", "p@ssw0rd", cs);
		adminService.addAccount("huangjian", "p@ssw0rd", cs);
		adminService.addAccount("yinsong", "p@ssw0rd", cs);
				
		adminService.addUnit("SZ-ODC", "3410", null, cs);
		
		Resource _3410_User = queryService.getResourceAsPath("/unit/.3410/group/3410-User");
		Group _3410_user_object = (Group)queryService.getBo(_3410_User.getId());
		
		_3410_user_object.setGroupName("Staff");
		_3410_user_object.getResource().setAlias("Staff");
		resourceService.saveOrUpdateBo(_3410_user_object,cs);
		
		Resource szContextChildrenRes = queryService.getResourceAsPath("/unit/SZ-ODC");
		adminService.addUnit("3001", "34103001", szContextChildrenRes, cs);
		adminService.addUnit("3002", "34103002", szContextChildrenRes, cs);
		Resource _3002ContextChildrenRes = queryService.getResourceAsPath("/unit/.3410/children/3002");
		adminService.addUnit("3002A", "34103002A", _3002ContextChildrenRes, cs);
		
		List<Resource> accountResourceList = new ArrayList<Resource>();
		accountResourceList.add(queryService.getResourceAsPath("/home/henry"));
		accountResourceList.add(queryService.getResourceAsPath("/home/shiyang"));
		accountResourceList.add(queryService.getResourceAsPath("/home/weibing"));
		accountResourceList.add(queryService.getResourceAsPath("/home/jianhua"));
		accountResourceList.add(queryService.getResourceAsPath("/home/zhaofeng"));
		accountResourceList.add(queryService.getResourceAsPath("/home/yinchu"));
		accountResourceList.add(queryService.getResourceAsPath("/home/xiaolei"));
		accountResourceList.add(queryService.getResourceAsPath("/home/huangjian"));
		Resource defaultGroupRes = queryService.getResourceAsPath("/group/Self");
		
		for(Iterator<Resource> it=accountResourceList.iterator();it.hasNext();){
			Resource currRes = it.next();
			currRes.setSelected(Boolean.TRUE);
		}
		coreService.activationAccount(accountResourceList, defaultGroupRes, RootSessionHolder.getDefaultRootSession());
		
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/henry").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/shiyang").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/weibing").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/jianhua").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/zhaofeng").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/yinchu").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/xiaolei").getId(), cs);
		adminService.grantStaffGroup(_3410_User.getId(), queryService.getResourceAsPath("/staff/huangjian").getId(), cs);
		
		adminService.appointManager(queryService.getResourceAsPath("/unit/SZ-ODC").getId(), queryService.getResourceAsPath("/staff/henry").getId(), cs);
		adminService.appointManager(queryService.getResourceAsPath("/unit/.3410/children/3001").getId(), queryService.getResourceAsPath("/staff/shiyang").getId(), cs);
		adminService.appointManager(queryService.getResourceAsPath("/unit/.3410/children/3002").getId(), queryService.getResourceAsPath("/staff/weibing").getId(), cs);
		adminService.appointManager(queryService.getResourceAsPath("/unit/.3410/children/.34103002/children/3002A").getId(), queryService.getResourceAsPath("/staff/jianhua").getId(), cs);
		
	}
}
