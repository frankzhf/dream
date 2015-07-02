package net.frank.cms.initial;

import net.frank.commons.CommonConstants;
import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.Resource;

public final class TestInitTempleate extends TestInitCase {
	
	@Override
	public String[] getSpringConfig() {
		return new String[] { "/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml" };
	}
	
	@Override
	public void setUp() {
		super.setUp();
	}
	
	public void testInit() {
		Resource templateRoot = queryService.getResource(
				CommonConstants.RESOURCE_ID.ROOT,
				CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT);
		
		Resource accountTemplate = createResource("account", templateRoot,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		Resource res = createResource(".group", accountTemplate, false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource(".privilege", accountTemplate, false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		Resource confRes = createResource(".config", accountTemplate, false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		Limit limit = createLimit("PERSON_REPOSITORY_SZIE", 536870912L, 0L, confRes,
				getRootAccount(), getAdminGroup());
		logger.debug(limit);
		Resource respostiory = createResource("repository", accountTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("myDocument", respostiory,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		Resource resK = createResource("knowledge", accountTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("myDrafts", resK,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("published", resK,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("recycleBin", respostiory,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		logger.debug(res);
		
		Resource unitTemplate = createResource("unit", templateRoot,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		Resource resH = createResource("repository", unitTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		Resource resHH = createResource("published", resH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("Common Software", resHH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("Java", resHH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("DotNet", resHH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("pending", resH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("archive", resH,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		Resource resKK = createResource("knowledge",unitTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("published", resKK,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("pending", resKK,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("archive", resKK,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("children", unitTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("group", unitTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("grant", unitTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		Resource taskTemplate = createResource("task", templateRoot,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("children", taskTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("token", taskTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		
		Resource taskTokenTemplate = createResource("taskToken", templateRoot,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("attach", taskTokenTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("screenshot", taskTokenTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("comment", taskTokenTemplate,false,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		
		Resource applicationTemplate = createResource("application", templateRoot,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("menu", applicationTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("group", applicationTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("grant", applicationTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("contextTemplate", applicationTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("type", applicationTemplate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		
		Resource articleTempleate = createResource("article", templateRoot,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("image", articleTempleate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
		res = createResource("media", articleTempleate,true,
				getType(CommonConstants.TYPE.RESOURCE), getRootAccount(), getAdminGroup());
	}
}
