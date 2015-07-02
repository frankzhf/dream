package net.frank.repository;

import net.frank.framework.TestInitDbCase;

public class TestInitDb extends TestInitDbCase {

	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:init-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-service.xml",
				"classpath:applicationContext-dao.xml"};
	}
	
	public void testCreateSchema() {
		dropDatabaseSchema2(configuration, sessionFactory);
		createDatabaseSchema2(configuration, sessionFactory);
	}

}
