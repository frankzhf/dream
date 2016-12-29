package net.frank.cms.ext.selector.unit.service.impl;

import java.util.List;

import net.frank.framework.BaseTestCase;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.DialogTreeService;
import net.frank.framework.service.QueryService;

public final class TestUnitSelectorTreeService extends BaseTestCase {
	
	//private static final String DefaultUnitRoot = "/unit";
	
	private DialogTreeService unitSelectorTreeService;
	private QueryService queryService; 
	private boolean aa;
	@Override
	public void setUp() {
		super.setUp();
		unitSelectorTreeService = (DialogTreeService)getBean("unitSelectorTreeService");
		queryService = (QueryService)getBean("queryService");
	}
	
	@Override
	public String[] getSpringConfig() {
		return new String[] { "/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-ext-selector-unit.xml"};
	}
	
	/***
	public void testGetUnitRoot(){
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		Resource resUnitRoot = unitSelectorTreeService.getRoot(null, rootSession);
		logger.info("Current Unit Root is " + queryService.getResourcePath(resUnitRoot));
	}
	
	public void testUnitChildren(){
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		Resource szOdc = queryService.getResourceAsPath("/unit/SZ-ODC");
		List<Resource> children = unitSelectorTreeService.getChildren(szOdc, rootSession);
		for(int i=0;i<children.size();i++){
			Resource child = children.get(i);
			logger.info("Current Unit Root's children ["+i+"] is " + queryService.getResourcePath(child));
		}
	}
	***/
	
	public void testUnitSelectedLink(){
		
		logger.info("boolean Default value is " + aa );
		
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		Resource _3001 = queryService.getResourceAsPath("/unit/.3410/children/3001");
		String selectedLink = unitSelectorTreeService.getSelectedLinks(_3001, rootSession);
		logger.info("Unit [3001] 's selected link are " + selectedLink );
		Resource _3002a = queryService.getResourceAsPath("/unit/.3410/children/.34103002/children/3002A");
		selectedLink = unitSelectorTreeService.getSelectedLinks(_3002a, rootSession);
		logger.info("Unit [3002a] 's selected link are " + selectedLink );
	}

}
