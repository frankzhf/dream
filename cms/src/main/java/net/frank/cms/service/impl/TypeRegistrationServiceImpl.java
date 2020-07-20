package net.frank.cms.service.impl;

import org.springframework.transaction.annotation.Transactional;

import net.frank.cms.dao.TypeRegistrationDao;
import net.frank.cms.service.TypeRegistrationService;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Application;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

public class TypeRegistrationServiceImpl implements TypeRegistrationService {

	private Object locker = new Object();

	private static final String varPath = "/var/TypeRegistratorNextValue";

	private QueryService queryService;

	private ResourceService resourceService;
	
	private TypeRegistrationDao typeRegistrationDao;

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	public void setTypeRegistrationDao(TypeRegistrationDao typeRegistrationDao){
		this.typeRegistrationDao = typeRegistrationDao;
	}
	@Transactional
	@Override
	public void registrationType(String entityClass, String description,
			String typeKey, Application application,Session cs) {
		Long rt = null;
		Long parentId = null;
		synchronized (locker) {
			Resource limitRes = (Resource) queryService
					.getResourceAsPath(varPath);
			Limit limit = (Limit) queryService.getBo(limitRes);
			rt = limit.getCurrentValue();
			limit.setCurrentValue(rt +1);
			resourceService.saveOrUpdateBo(limit, RootSessionHolder.getDefaultRootSession());
		}
		Type extType = new Type();
		extType.setEntityClassName(entityClass);
		extType.setDescription(description);
		extType.setTypeKey(typeKey);
		Resource resource = new Resource();
		resource.setId(rt);
		resource.setAlias(extType.getTypeKey());
		resource.setTypeId(CommonConstants.TYPE.TYPE);
		if(application == null){
			parentId = queryService.getResourceAsPath("/resType").getId();
		}else{
			Resource appContextRes = application.getContext$3();
			parentId = queryService.getResource(appContextRes.getId(), "type").getId();
		}
		resource.setParentId(parentId);
		resource.setSystemNode(Boolean.TRUE);
		resource.setActive(Boolean.TRUE);
		resource.setOwnResourceId(cs.getAccount().getResource().getId());
		resource.setOwnGroupResourceId(cs.getCurrentGroup().getResource().getId());
		resource.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PROTECTED.CURRENT_ACCOUNT);
		resource.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PROTECTED.CURRENT_GROUP);
		resource.setOthersPermission(CommonConstants.PERMISSION_GROUP.PROTECTED.OTHERS);
		extType.setResource(resource);
		Resource rootAccountRes = queryService.getResourceAsPath("/home/root");
		Resource adminGroupRes = queryService.getResourceAsPath("/group/Admin");
		resource.setOwnResourceId(rootAccountRes.getId());
		resource.setOwnGroupResourceId(adminGroupRes.getId());
		resource.setLastAccountResourceId(rootAccountRes.getId());
		typeRegistrationDao.insertResource(resource);
		typeRegistrationDao.insertType(extType);
	}
}
