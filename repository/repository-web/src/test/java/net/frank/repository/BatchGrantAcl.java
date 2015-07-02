package net.frank.repository;

import java.util.List;

import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;

public class BatchGrantAcl extends TestInitCase {
	private static final String REPOSITORY_PATH = "/unit/.3410/children/.34103002/children/.34103002X/repository/published/Common Software";
	@Override
	public String[] getSpringConfig() {
		return new String[] {
			"classpath:applicationContext-datasource.xml",
			"classpath:applicationContext-base.xml",
			"classpath:applicationContext-dao.xml",
			"classpath:applicationContext-service.xml",
			"classpath:applicationContext-repository.xml"};
	}
	
	public void testInitProject(){
		Resource currentRoot = queryService.getResourceAsPath(REPOSITORY_PATH);
		if(CommonConstants.TYPE.RESOURCE.equals(currentRoot.getTypeId())){
			List<Acl> listAcl = queryService.listAcl(currentRoot.getId());
			List<Resource> children = queryService.retrieveResourceByParent(currentRoot.getId());
			for(int i=0;i<children.size();i++){
				Resource child = children.get(i);
				if(CommonConstants.TYPE.RESOURCE.equals(child.getTypeId())){
					processFolder(child,listAcl);
				}
			}
		}
		
	}
	
	private void processFolder(Resource child,List<Acl> listAcl){
		for(int i=0;i<listAcl.size();i++){
			Acl acl = listAcl.get(i);
			Acl newAcl = new Acl();
			newAcl.setOwnId(acl.getOwnId());
			newAcl.setPermission(acl.getPermission());
			newAcl.setResourceId(child.getId());
			baseDao.saveObject(newAcl);
		}
		List<Resource> children = queryService.retrieveResourceByParent(child.getId());
		for(int i=0;i<children.size();i++){
			Resource child0 = children.get(i);
			if(CommonConstants.TYPE.RESOURCE.equals(child0.getTypeId())){
				processFolder(child0,listAcl);
			}
		}
	}
}
