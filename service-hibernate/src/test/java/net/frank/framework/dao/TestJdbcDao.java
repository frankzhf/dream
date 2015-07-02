package net.frank.framework.dao;

import net.frank.framework.BaseTestCase;

public class TestJdbcDao extends BaseTestCase {
	private BaseJdbcDao baseJdbcDao;
	
	public void setUp() {
		super.setUp();
		baseJdbcDao = (BaseJdbcDao) getBean("baseJdbcDao");
	}
	
	public void testSeq(){
		Long nextValue = baseJdbcDao.getSeqNext("SEQ_TEST_01");
		System.out.println(nextValue);
		
		nextValue = baseJdbcDao.getSeqNext("SEQ_TEST_01");
		System.out.println(nextValue);
		
		
		nextValue = baseJdbcDao.getSeqNext("SEQ_TEST_02");
		System.out.println(nextValue);
		
		nextValue = baseJdbcDao.getSeqNext("SEQ_TEST_02");
		System.out.println(nextValue);
		
	}

	@Override
	public String[] getSpringConfig() {
		return null;
	}
	
}
