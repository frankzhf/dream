package net.frank.repository.organization;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.organization.UnitPhase;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextHolder;

public class AddUnitPhase implements UnitPhase {
	private static final String DEFAULT_HOME = "/home";
	private static final String DEFAULT_READ_UNIT_GROUP_PATH = "/unit/.3410/group/Staff";
	@Override
	public void exec(Unit unit, Resource unitContext, Session cs) {
		
		QueryService queryService = (QueryService)getBean(ServiceNames.QUERY_SERVICE);
		final ResourceService resourceService = (ResourceService)getBean(ServiceNames.RESOURCE_SERVICE);
		String unitCode = unit.getUnitCode();
		
		Resource unitAdminAccount = queryService.getResourceAsPath(DEFAULT_HOME
				+ "/Unit-admin-" + unitCode);
		
		Resource groupRes = queryService.getResourceAsPath(unitContext,
				CommonConstants.CONTEXT.UNIT.GROUP);
		//addGroup(unitCode + "-User", groupRes, cs);
		addGroup(unitCode + "-User-Java", groupRes, cs);
		addGroup(unitCode + "-User-DotNet", groupRes, cs);
		addGroup(unitCode + "-User-Publisher", groupRes, cs);

		final Long unitAccountResourceId = unitAdminAccount.getId();
		final Long unitGroupResourceId = unit.getGroup$6().getId();
		unitContext.setOwnResourceId(unitAccountResourceId);
		unitContext.setOwnGroupResourceId(unitGroupResourceId);
		resourceService.saveOrUpdateResource(unitContext, cs);

		
		Resource resUnitUserGroup = queryService.getResource(
				groupRes.getId(), unitCode + "-User") ;
		if(resUnitUserGroup == null){
			resUnitUserGroup = queryService.getResource(
					groupRes.getId(), "Staff"); 
		}
		final Resource unitUserGroupResource = resUnitUserGroup;
		final Resource unitUserJavaGroupResource = queryService.getResource(
				groupRes.getId(), unitCode + "-User-Java");
		final Resource unitUserDotNetGroupResource = queryService.getResource(
				groupRes.getId(), unitCode + "-User-DotNet");
		final Resource unitUserPublisherGroupResource = queryService
				.getResource(groupRes.getId(), unitCode + "-User-Publisher");

		unitContext.setOwnGroupResourceId(unitUserGroupResource.getId());
		resourceService.saveOrUpdateResource(unitContext, cs);

		Resource repositoryRes = queryService.getResource(
				unitContext.getId(), "repository");
		repositoryRes.setOwnGroupResourceId(unitUserGroupResource.getId());
		resourceService.saveOrUpdateResource(repositoryRes, cs);

		Resource grantRes = queryService.getResource(unitContext.getId(),
				"grant");
		grantRes.setCurrentGroupPermission(CommonConstants.PERMISSION.RW);
		resourceService.saveOrUpdateResource(grantRes, cs);

		Resource publishedRes = queryService.getResourceAsPath(
				unitContext, "repository/published");
		publishedRes = queryService.getResourceWithRecursive(publishedRes);

		resourceService.saveResourceWithRecursive(publishedRes, cs,
				new ResourceFilter() {
					@Override
					public boolean filter(Resource resource) {
						resource.setOwnResourceId(unitAccountResourceId);
						resource.setOwnGroupResourceId(unitUserGroupResource
								.getId());
						resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
						resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
						resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
						Acl acl = new Acl();
						acl.setResourceId(resource.getId());
						acl.setOwnId(unitUserPublisherGroupResource.getId());
						acl.setPermission(CommonConstants.PERMISSION.RW);
						resourceService.saveObject(acl);
						return true;
					}
				});

		Resource publishedJavaRes = queryService.getResourceAsPath(
				unitContext, "repository/published/Java");
		publishedJavaRes.setOwnGroupResourceId(unitUserJavaGroupResource
				.getId());
		resourceService.saveOrUpdateResource(publishedJavaRes, cs);

		Resource publishedDotNetRes = queryService.getResourceAsPath(
				unitContext, "repository/published/DotNet");
		publishedDotNetRes.setOwnGroupResourceId(unitUserDotNetGroupResource
				.getId());
		resourceService.saveOrUpdateResource(publishedDotNetRes, cs);

		Resource pendingRes = queryService.getResourceAsPath(unitContext,
				"repository/pending");
		pendingRes.setOwnGroupResourceId(unitUserGroupResource.getId());
		pendingRes.setCurrentGroupPermission(CommonConstants.PERMISSION.WRITE);
		resourceService.saveOrUpdateResource(pendingRes, cs);

		Acl acl = new Acl();
		acl.setResourceId(pendingRes.getId());
		acl.setOwnId(unitUserPublisherGroupResource.getId());
		acl.setPermission(CommonConstants.PERMISSION.RW);
		resourceService.saveObject(acl);
		
		
		Resource archiveRes = queryService.getResourceAsPath(unitContext, "repository/archive");
		archiveRes.setCurrentGroupPermission(CommonConstants.PERMISSION.RW);
		resourceService.saveOrUpdateResource(pendingRes, cs);
		
		acl = new Acl();
		acl.setResourceId(archiveRes.getId());
		acl.setOwnId(unitUserPublisherGroupResource.getId());
		acl.setPermission(CommonConstants.PERMISSION.WRITE);
		resourceService.saveObject(acl);
		
		if(!"3410".equals(unit.getUnitCode())){
			Resource readUnitGroup = queryService.getResourceAsPath(DEFAULT_READ_UNIT_GROUP_PATH);
			if(readUnitGroup!=null){
				acl = new Acl();
				acl.setResourceId(unitContext.getId());
				acl.setOwnId(readUnitGroup.getId());
				acl.setPermission(CommonConstants.PERMISSION.READ);
				resourceService.saveObject(acl);
				/***
				acl = new Acl();
				acl.setResourceId(unit.getResource().getId());
				acl.setOwnId(readUnitGroup.getId());
				acl.setPermission(CommonConstants.PERMISSION.READ);
				resourceService.saveObject(acl);
				***/
				Resource resChildrenFolder = queryService.getResource(unitContext.getId(), 
						CommonConstants.CONTEXT.UNIT.CHILDREN);
				acl = new Acl();
				acl.setResourceId(resChildrenFolder.getId());
				acl.setOwnId(readUnitGroup.getId());
				acl.setPermission(CommonConstants.PERMISSION.READ);
				resourceService.saveObject(acl);
			}
		}
		
	}
	
	private void addGroup(String groupName, Resource parent, Session cs) {
		ResourceService resourceService = 
				(ResourceService)getBean(ServiceNames.RESOURCE_SERVICE);
		Resource newGroupRes = resourceService.newResource(groupName, parent,
				CommonConstants.TYPE.GROUP, false, cs.getAccount()
						.getResource(), cs.getCurrentGroup().getResource(),
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.READ,
				CommonConstants.PERMISSION.NONE);
		Group group = new Group();
		group.setGroupName(groupName);
		group.setResource(newGroupRes);
		resourceService.saveOrUpdateBo(group, cs);
	}
	
	private Object getBean(String beanId){
		return SpringContextHolder.getApplicationContext().getBean(beanId);
	}
}
