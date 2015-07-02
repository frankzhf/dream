package net.frank.framework.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.SystemHistory;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;

public class ResourceServiceImpl extends BaseServiceImpl implements
		ResourceService {
	private QueryService queryService;
	
	@Override
	public Resource newResource(String alias, Resource parent, Long typeId,
			boolean isSystem, Resource own, Resource ownGroup,
			Byte ownPermission, Byte groupPermission, Byte othersPermission) {
		Resource resource = new Resource();
		resource.setAlias(alias);
		resource.setActive(true);
		resource.setSystemNode(isSystem);
		resource.setCreatedDt(new Date());
		resource.setLastUpdatedDt(new Date());
		resource.setParentId(parent.getId());
		resource.setTypeId(typeId);
		resource.setOwnResourceId(own.getId());
		resource.setOwnGroupResourceId(ownGroup.getId());
		resource.setCurrentAccountPermission(ownPermission);
		resource.setCurrentGroupPermission(groupPermission);
		resource.setOthersPermission(othersPermission);
		return resource;
	}
	
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	@Override
	public Resource saveOrUpdateResource(Resource resource, Session session) {
		Date currentDate = new Date();
		if (resource.getId() == null) {
			resource.setOwnResourceId(session.getAccount().getResource()
					.getId());
			resource.setOwnGroupResourceId(session.getCurrentGroup()
					.getResource().getId());
			resource.setCreatedDt(currentDate);
		} else {
			if(resource.getSystemNode()){
				saveResourceHistory(resource, session);
			}
			resource = (Resource) merge(resource);
		}
		resource.setLastUpdatedDt(currentDate);
		if(resource.getParentId()!=null){
			Resource parent = queryService.getResource(resource.getParentId());
			parent.setLastUpdatedDt(currentDate);
			saveObject(parent);
		}
		return (Resource) saveObject(resource);
	}

	@Override
	public BusinessObject saveOrUpdateBo(BusinessObject bo, Session session) {
		Date currentDate = new Date();
		Resource resource = bo.getResource();
		if (resource.getId() == null) {
			resource.setCreatedDt(currentDate);
		}else{
			if(resource.getSystemNode()){
				saveHistory(bo, session);
			}
			resource = (Resource) merge(resource);
			bo = (BusinessObject)merge(bo);
		}
		resource.setLastAccountResourceId(session.getAccount().getResource()
				.getId());
		resource.setLastUpdatedDt(currentDate);
		saveObject(resource);
		Resource parent = queryService.getResource(resource.getParentId());
		parent.setLastUpdatedDt(currentDate);
		saveObject(parent);
		BusinessObject returnValue = (BusinessObject) saveObject(bo);
		return returnValue;
	}

	@Override
	public BusinessObject deleteBo(BusinessObject bo, Session session) {
		saveHistory(bo, session);
		removeObject(bo);
		return bo;
	}
	
	@Override
	public Resource deleteResource(Resource resource, Session session) {
		saveResourceHistory(resource, session);
		try{
			removeObject(resource);
			getBaseDao().flush();
		}catch(Exception e){
			
		}
		return resource;
	}


	@Override
	public void saveHistory(BusinessObject bo, Session session) {
		SystemHistory sh = new SystemHistory();
		sh.setResourceId(bo.getResource().getId());
		sh.setLogDate(new Date());
		sh.setOpResoureId(session.getAccount().getResource().getId());
		BusinessObject oldObject = queryService.getBo(bo.getResource().getId());
		Resource oldResource = queryService.getResource(oldObject.getResource()
				.getId());
		oldObject.setResource(null);
		oldResource.setObject(oldObject);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oo;
		try {
			oo = new ObjectOutputStream(baos);
			oo.writeObject(oldResource);
			sh.setHistoryContent(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		saveObject(sh);
		oldResource.setObject(null);
		oldObject.setResource(oldResource);
	}

	@Override
	public void saveResourceHistory(Resource resource, Session session) {
		SystemHistory sh = new SystemHistory();
		sh.setResourceId(resource.getId());
		sh.setLogDate(new Date());
		sh.setOpResoureId(session.getAccount().getResource().getId());
		Resource oldResource = queryService.getResource(resource.getId());
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo;
		try {
			oo = new ObjectOutputStream(bo);
			oo.writeObject(oldResource);
			oo.flush();
			sh.setHistoryContent(bo.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		saveObject(sh);
	}

	@Override
	public void saveResourceWithRecursive(Resource src, Session session,
			boolean includeObject, ResourceFilter resourceFilter) {
		boolean goon = false;
		List<Resource> listResource = null;
		BusinessObject bo = null;
		if (CommonConstants.TYPE.RESOURCE.equals(src.getTypeId())
				&& src.getChildren() != null && !src.getChildren().isEmpty()) {
			listResource = src.getChildren();
			goon = true;
		} else {
			bo = src.getObject();
		}
		if (resourceFilter == null || resourceFilter.filter(src)) {
			saveOrUpdateResource(src, session);
			if (bo != null && includeObject) {
				saveOrUpdateBo(bo, session);
			}
		}
		if (goon) {
			for (Iterator<Resource> it = listResource.iterator(); it.hasNext();) {
				Resource sonRes = it.next();
				saveResourceWithRecursive(sonRes, session, includeObject,
						resourceFilter);
			}
		}
	}

	@Override
	public void saveResourceWithRecursive(Resource src, Session session,
			ResourceFilter resourceFilter) {
		saveResourceWithRecursive(src, session, false, resourceFilter);
	}

	@Override
	public void saveResourceWithRecursive(Resource src, Session session) {
		saveResourceWithRecursive(src, session, false, null);
	}

	@Override
	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session, ResourceFilter resourceFilter, String alias) {
		if (src.getParentId().equals(target.getId())) {
			log.info("Source 's parent is target");
			return;
		}
		Stack<Resource> stack = queryService.getNodeStack(target.getId(), null);
		while (!stack.isEmpty()) {
			Resource resPath = stack.pop();
			if (resPath.getId().equals(src.getId())) {
				log.info("Resource can't copy to below path");
				return;
			}
		}
		cloneResourceWithRecursive2(src, target, session, resourceFilter, alias);
	}

	private void cloneResourceWithRecursive2(Resource src, Resource target,
			Session session, ResourceFilter resourceFilter, String alias) {
		Resource _src = src.clone();
		boolean goon = false;
		List<Resource> listResource = null;
		BusinessObject bo = null;
		if (CommonConstants.TYPE.RESOURCE.equals(_src.getTypeId())) {
			listResource = queryService.retrieveResourceByParent(_src.getId());
		} else {
			BusinessObject busObj = queryService.getBo(_src.getId());
			bo = (busObj.clone());
		}
		if (listResource != null && listResource.size() > 0) {
			goon = true;
		}
		if (resourceFilter == null || resourceFilter.filter(src)) {
			_src.setId(null);
			_src.setParentId(target.getId());
			_src.setAlias(alias);
			saveOrUpdateResource(_src, session);
			if (bo != null) {
				bo.setId(null);
				bo.setResource(_src);
				saveObject(bo);
			}
			if (goon) {
				for (Iterator<Resource> it = listResource.iterator(); it
						.hasNext();) {
					Resource sonRes = it.next();
					cloneResourceWithRecursive2(sonRes, _src, session,
							resourceFilter, sonRes.getAlias());
				}
			}
		}
	}

	@Override
	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session, ResourceFilter resourceFilter) {
		cloneResourceWithRecursive(src, target, session, resourceFilter,
				src.getAlias());
	}

	@Override
	public void cloneResourceWithRecursive(Resource src, Resource target,
			Session session) {
		cloneResourceWithRecursive(src, target, session, null, src.getAlias());
	}
	@Override
	public void deleteAcl(Long aclId) {
		Acl acl = new Acl();
		acl.setId(aclId);
		removeObject(acl);
	}
	@Override
	public void addAcl(Long resourceId, Long ownId, Byte permission) {
		Acl acl = new Acl();
		acl.setResourceId(resourceId);
		acl.setOwnId(ownId);
		acl.setPermission(permission);
		saveObject(acl);
		
	}
	@Override
	public void updateAcl(Long aclId, Long resourceId, Long ownId,
			Byte permission) {
		Acl acl = new Acl();
		acl.setId(aclId);
		acl.setResourceId(resourceId);
		acl.setOwnId(ownId);
		acl.setPermission(permission);
		saveObject(acl);
	}

	
}