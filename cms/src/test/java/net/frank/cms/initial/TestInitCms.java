package net.frank.cms.initial;

import net.frank.framework.TestInitCase;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.ResourceFilter;

public class TestInitCms extends TestInitCase {
	
	protected static Byte ACCOUNT_PERMISSION = 7;

	protected static Byte GROUP_PERMISSION = 4;

	protected static Byte OTHERS_PERMISSION = 0;
	
	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"classpath:applicationContext-datasource.xml",
				"classpath:applicationContext-base.xml",
				"classpath:applicationContext-dao.xml",
				"classpath:applicationContext-service.xml"};
	}
	
	public void testInit(){
		logger.info("Start Init CmsApp");
		
		Resource groupRes = getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		
		Resource appGroupRes = queryService.getResourceAsPath("/home/.root/.group");
		Resource appAccountRes = getRootAccount();
		
		createA2g(appAccountRes, groupSelfRes, appGroupRes);
		createApp("cmsApp", queryService.getResourceAsPath("/opt"),"/resType", cs, appAccountRes);
		session.beginTransaction();
		Resource a2gRootSelf = queryService.getResourceAsPath("/home/.root/.group/root@Self");
		Resource cmsApp = queryService.getResourceAsPath("/opt/cmsApp");
		cmsApp.setOwnResourceId(appAccountRes.getId());
		cmsApp.setOwnGroupResourceId(groupRes.getId());
		baseDao.saveObject(cmsApp);
		
		a2gRootSelf.setOwnResourceId(appAccountRes.getId());
		a2gRootSelf.setOwnGroupResourceId(groupRes.getId());
		baseDao.saveObject(a2gRootSelf);
	
		final Long ownGroupId = groupRes.getId();
		final Long ownId = appAccountRes.getId();
		
		Resource _src = queryService.getResourceAsPath("/opt/.cmsApp");
		_src = queryService.getResourceWithRecursive(_src);
		resourceService.saveResourceWithRecursive(_src, cs, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(ACCOUNT_PERMISSION);
				resoruce.setCurrentGroupPermission(GROUP_PERMISSION);
				resoruce.setOthersPermission(OTHERS_PERMISSION);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(ownGroupId);
				return true;
			}
		});
		session.getTransaction().commit();
		logger.info("End Init CMS");
	}

	
}
