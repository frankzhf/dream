package net.frank.springweb.initial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;

public final class TestInitTempleate extends TestInitCase {
	protected ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "/applicationContext-datasource.xml",
					"/applicationContext-base.xml",
					"/applicationContext-dao.xml",
					"/applicationContext-service.xml" });
	
	@Override
	public void setUp() {
		super.setUp();
	}
	
	public void testInit() {
		Resource templateRoot = queryService.getResource(
				CommonConstants.RESOURCE_ID.ROOT,
				CommonConstants.RESOURCE_ALIAS.CONTEXT_TEMPLATES_ROOT);
		Resource accountTemplate = createResource("account", templateRoot,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		Resource res = createResource(".group", accountTemplate, false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		logger.debug(res);
		res = createResource(".privilege", accountTemplate, false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("myTask", accountTemplate, false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("ownTask", accountTemplate, false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("draft", accountTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("myDocument", accountTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("recycleBin", accountTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		logger.debug(res);
		
		
		/***
		Resource taskTemplate = createResource("task", templateRoot,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("children", taskTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("token", taskTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		
		
		Resource taskTokenTemplate = createResource("taskToken", templateRoot,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("attach", taskTokenTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("screenshot", taskTokenTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("comment", taskTokenTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		**/

		Resource unitTemplate = createResource("unit", templateRoot,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("task", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("article", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		Resource resH = createResource("repository", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		Resource resHH = createResource("published", resH,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		
		res = createResource("Common Software", resHH,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("Java", resHH,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("DotNet", resHH,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("pending", resH,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("children", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("group", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("grant", unitTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		
		
		/***
		Resource articleTemplate = createResource("article", templateRoot,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("attaches", articleTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("media", articleTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("comments", articleTemplate,false,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		***/
		
		Resource applicationTemplate = createResource("application", templateRoot,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("layout", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("menu", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("group", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("grant", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("dictionary", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
		res = createResource("contextTemplate", applicationTemplate,true,
				getType("RESOURCE"), getRootAccount(), getAdminGroup());
	}
}
