package net.frank.repository;

import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;

public class TestInitType extends TestInitCase {
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-service.xml",
				"classpath:applicationContext-dao.xml"};
	}
	
	
	public void testInitType(){
		Resource resType = queryService.getResourceAsPath("/opt/.repositoryApp/type");
		Resource appAccountRes = queryService.getResourceAsPath("/home/repository-adm");
		Resource groupRes = queryService.getResourceAsPath("/group/admin");
		createType("FILE","net.frank.repository.bo.File",resType,appAccountRes,groupRes);
		createType("SHAREDREQUEST","net.frank.repository.bo.SharedRequest",resType,appAccountRes,groupRes);
		createType("COMMENT","net.frank.repository.bo.Comment",resType,appAccountRes,groupRes);
	}
	
	public Type createType(String alias,String className,Resource parent,Resource account,Resource group){
		Resource typeRes = queryService.getResourceAsPath("/resType/TYPE");
		Resource res = createResource(alias,parent,true,typeRes,account,group);
		Type type = new Type();
		type.setResource(res);
		type.setTypeKey(alias);
		type.setEntityClassName(className);
		baseDao.saveObject(type);
		res.setObject(type);
		return type;
	}
}
