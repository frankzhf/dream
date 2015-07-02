package net.frank.cms.ext.selector.unit.dao;

import net.frank.framework.BaseTestCase;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.DialogTreeService;
import net.frank.framework.service.QueryService;

public class TestUnitSelectorDaoHibernate extends BaseTestCase {
	
	private UnitSelectorDao unitSelectorDao;
	private QueryService queryService; 
	
	@Override
	public void setUp() {
		super.setUp();
		unitSelectorDao = (UnitSelectorDao)getBean("unitSelectorDao");
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
	
	
	public void testRetrieveUnitByContext(){
		///unit/.3410
		
		Resource _3410_context = queryService.getResourceAsPath("/unit/.3410");
		Unit currentUnit = unitSelectorDao.retrieveUnitByContext(_3410_context);
		logger.info("3410's unit path is " + queryService.getResourcePath(currentUnit.getResource()));
		
		Resource _34103001_context = queryService.getResourceAsPath("/unit/.3410/children/.34103001");
		currentUnit = unitSelectorDao.retrieveUnitByContext(_34103001_context);
		logger.info("3001's unit path is " + queryService.getResourcePath(currentUnit.getResource()));
		
		Resource _34103002_context = queryService.getResourceAsPath("/unit/.3410/children/.34103002");
		currentUnit = unitSelectorDao.retrieveUnitByContext(_34103002_context);
		logger.info("3002's unit path is " + queryService.getResourcePath(currentUnit.getResource()));
		
		Resource _34103002a_context = queryService.getResourceAsPath("/unit/.3410/children/.34103002/children/.34103002A");
		currentUnit = unitSelectorDao.retrieveUnitByContext(_34103002a_context);
		logger.info("3002a's unit path is " + queryService.getResourcePath(currentUnit.getResource()));
		
	}
	
}
