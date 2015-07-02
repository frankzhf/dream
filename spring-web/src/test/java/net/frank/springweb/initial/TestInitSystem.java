package net.frank.springweb.initial;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Type;
import net.frank.framework.bo.Resource;

public final class TestInitSystem extends TestInitCase {
	/**
	protected ApplicationContext context=new ClassPathXmlApplicationContext(
			new String[] { "/applicationContext-datasource.xml",
					"/applicationContext-base.xml",
					"/applicationContext-dao.xml",
					"/applicationContext-test.xml",
					"/applicationContext-service.xml" });
	**/
	private Map<String,Type> typeMap = new HashMap<String,Type>();
	
	private Resource typeRes = null;
	private Resource accountRes = null;
	private Resource groupRes = null;
	
	
	private static final String ROOT = "/";
	
	private static final String ADMIN_GROUP = "Admin";
	
	private static final String ADMIN_ACCOUNT = "root";
	
	public static final Long ROOT_RESOURCE_ID =1L;
	
	
	@Override
	public void setUp() {
		super.setUp();
	}


	public void testCreateSchema() {
		dropDatabaseSchema(configuration, sessionFactory);
		createDatabaseSchema(configuration, sessionFactory);
		init();
	}
	
	private void init(){
		createResource(ROOT,null,true);
		createResource(CommonConstants.RESOURCE_ALIAS.TYPE_ROOT,resMap.get(ROOT),true);
		createType("RESOURCE","net.frank.framework.bo.Resource",resMap.get(CommonConstants.RESOURCE_ALIAS.TYPE_ROOT));
		
		Resource root = resMap.get(ROOT);
		root.setTypeId(typeMap.get("RESOURCE").getResource().getId());
		baseDao.saveObject(root);
		
		Resource res = resMap.get(CommonConstants.RESOURCE_ALIAS.TYPE_ROOT);
		res.setTypeId(typeMap.get("RESOURCE").getResource().getId());
		baseDao.saveObject(res);
		
		createType("TYPE","net.frank.framework.bo.Type",resMap.get(CommonConstants.RESOURCE_ALIAS.TYPE_ROOT));
		
		res = resMap.get("RESOURCE");
		res.setTypeId(typeMap.get("TYPE").getResource().getId());
		baseDao.saveObject(res);
		
		Resource type = resMap.get("TYPE");
		type.setTypeId(type.getId());
		baseDao.saveObject(res);
		typeRes = type;
		
		createType("ACCOUNT","net.frank.framework.bo.Account",resMap.get("resType"));
		createType("GROUP","net.frank.framework.bo.Group",resMap.get("resType"));
		createType("ACCOUNT2GROUP","net.frank.framework.bo.Account2Group",resMap.get("resType"));
		createType("PRIVILEGE","net.frank.framework.bo.Privilege",resMap.get("resType"));
		createType("ARTICLE","net.frank.framework.bo.Article",resMap.get("resType"));
		createType("ATTACH","net.frank.framework.bo.Attach",resMap.get("resType"));
		createType("IMAGE","net.frank.framework.bo.Image",resMap.get("resType"));
		createType("COMMENT","net.frank.framework.bo.Comment",resMap.get("resType"));
		createType("DICTIONARY","net.frank.framework.bo.Dictionary",resMap.get("resType"));
		createType("UNIT","net.frank.framework.bo.Unit",resMap.get("resType"));
		createType("TASK","net.frank.framework.bo.Task",resMap.get("resType"));
		createType("TASKTOKEN","net.frank.framework.bo.TaskToken",resMap.get("resType"));
		createType("FILE","net.frank.framework.bo.File",resMap.get("resType"));
		createType("PERSON","net.frank.framework.bo.Person",resMap.get("resType"));
		createType("STAFF","net.frank.framework.bo.Staff",resMap.get("resType"));
		createType("APPLICATION","net.frank.framework.bo.Application",resMap.get("resType"));
		createType("MENUITEM","net.frank.framework.bo.MenuItem",resMap.get("resType"));
		
		//createType("POWERLINE","net.frank.framework.bo.PowerLine",resMap.get("resType"));
		//createType("TOWER","net.frank.framework.bo.Tower",resMap.get("resType"));
		//createType("PATROLORDER","net.frank.framework.bo.PatrolOrder",resMap.get("resType"));
		
		createResource(CommonConstants.RESOURCE_ALIAS.HOME_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createAccount(ADMIN_ACCOUNT,"p@ssw0rd","774",resMap.get("home"));
		
		//Account zhaofeng = createAccount("zhaofeng","","774",resMap.get("Accounts"));
		//zhaofeng.setType(Account.TYPE_LDAP);
		//testService.saveOrUpdate(zhaofeng);
		
		createResource(CommonConstants.RESOURCE_ALIAS.GROUPS_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createGroup(ADMIN_GROUP,resMap.get("group"));
		createGroup("User",resMap.get("group"));
		createGroup("Self",resMap.get("group"));
		createGroup("Guest",resMap.get("group"));
		
		createA2g(resMap.get(ADMIN_ACCOUNT),resMap.get(ADMIN_GROUP),resMap.get(".group"));
		createA2p(resMap.get(ADMIN_ACCOUNT),resMap.get(ROOT),resMap.get(".privilege"));
		createResource(CommonConstants.RESOURCE_ALIAS.OPT_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource(CommonConstants.RESOURCE_ALIAS.DICTIONARIES_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource(CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource(CommonConstants.RESOURCE_ALIAS.UNIT_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource(CommonConstants.RESOURCE_ALIAS.RECYCLE_ROOT,resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource("staff",resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		createResource("person",resMap.get(ROOT),true,resMap.get("RESOURCE"),null,null);
		
		createType("SEX","net.frank.dictionary.sex.bo.Sex",resMap.get("resType"));
		createType("SUBJECT","net.frank.dictionary.subject.bo.Subject",resMap.get("resType"));
		//createType("USERDETAILS","net.frank.cms.bo.UserDetails",resMap.get("resType"));
		
		
		accountRes = resMap.get(ADMIN_ACCOUNT) ;
		groupRes = resMap.get(ADMIN_GROUP) ;
		
		for(Iterator<String> it=resMap.keySet().iterator();it.hasNext();){
			String key = it.next();
			Resource _r = resMap.get(key);
			_r.setOwnResourceId(accountRes.getId());
			_r.setOwnGroupResourceId(groupRes.getId());
			_r.setLastAccountResourceId(accountRes.getId());
			baseDao.saveObject(_r);
		}
		
		Resource sysResoure = queryService.getResourceAsPath("/resType/ACCOUNT");
		sysResoure.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(sysResoure);
		
		sysResoure = queryService.getResourceAsPath("/resType/GROUP");
		sysResoure.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(sysResoure);
		
		sysResoure = queryService.getResourceAsPath("/resType/ACCOUNT2GROUP");
		sysResoure.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(sysResoure);
		
		sysResoure = queryService.getResourceAsPath("/resType/PRIVILEGE");
		sysResoure.setOthersPermission(CommonConstants.PERMISSION.NONE);
		baseDao.saveObject(sysResoure);
	}
	
	public Type createType(String alias,String className,Resource parent){
		Resource res = createResource(alias,parent,true,typeRes,null,null);
		Type type = new Type();
		type.setResource(res);
		type.setTypeKey(alias);
		type.setEntityClassName(className);
		baseDao.saveObject(type);
		res.setObject(type);
		typeMap.put(alias, type);
		return type;
	}
}
