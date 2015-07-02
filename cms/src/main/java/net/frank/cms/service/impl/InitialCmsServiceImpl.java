package net.frank.cms.service.impl;

import net.frank.commons.CommonConstants;
import net.frank.framework.app.InitialService;
import net.frank.framework.bo.Resource;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.initial.QingMaker;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;

public class InitialCmsServiceImpl implements InitialService {
	
	private QueryService queryService;
	
	private ResourceService resourceService;
	
	private QingMaker qingMaker;
	
	private BaseDao baseDao;
	
	public void setQueryService(QueryService queryService){
		this.queryService = queryService;
	}
	
	public void setResourceService(ResourceService resourceService){
		this.resourceService = resourceService;
	}
	
	public void setQingMaker(QingMaker qingMaker){
		this.qingMaker = qingMaker;
	}
	
	public void setBaseDao(BaseDao baseDao){
		this.baseDao = baseDao;
	}
	
	@Override
	public boolean checkAppInitial() {
		return false;
	}

	@Override
	public boolean checkUserWorkspace(Session session) {
		return false;
	}

	@Override
	public void initialApp() {
		Resource groupRes = qingMaker.getAdminGroup();
		Resource groupSelfRes = queryService.getResourceAsPath("/group/Self");
		Resource appGroupRes = queryService.getResourceAsPath("/home/.root/.group");
		Resource appAccountRes = qingMaker.getRootAccount();
		
		Session rootSession = RootSessionHolder.getDefaultRootSession();
		
		qingMaker.createA2g(appAccountRes, groupSelfRes, appGroupRes);
		qingMaker.createApp("cmsApp", queryService.getResourceAsPath("/opt"),"/resType",
				rootSession, appAccountRes);
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
		resourceService.saveResourceWithRecursive(_src, rootSession, new ResourceFilter(){
			@Override
			public boolean filter(Resource resoruce) {
				resoruce.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
				resoruce.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
				resoruce.setOthersPermission(CommonConstants.PERMISSION.NONE);
				resoruce.setOwnResourceId(ownId);
				resoruce.setOwnGroupResourceId(ownGroupId);
				return true;
			}
		});
		
	}

	@Override
	public void initialUserWorkspace(Session session) {
		
	}

}
