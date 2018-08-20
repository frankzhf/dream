package net.frank.framework.service;

import java.util.List;

import net.frank.framework.BaseTestCase;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.QueryService;
//import net.sf.ehcache.CacheManager;

public class TestQueryService extends BaseTestCase {
	
	private QueryService queryService;
	//private CacheManager ehCacheManager;
	public void setUp() {
		super.setUp();
		queryService = (QueryService) getBean("queryService");
		//ehCacheManager =(CacheManager) getBean("ehCacheManager");
	}
	
	public void testRetrieveListType(){
		List<Type> result = queryService.retrieveListType();
		//logger.debug("ehCache named is '"+CacheService.TYPE_CACHE_NAME+"' count is:"+ehCacheManager.getCache(CacheService.TYPE_CACHE_NAME).getSize());
		result = queryService.retrieveListType();
		logger.debug("Records count is:"+result.size());
	}

	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-test.xml"};
	}
}
