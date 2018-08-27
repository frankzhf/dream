package net.frank.framework.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;

public class CmsServiceImpl implements CmsService{
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	private QueryService queryService;
	
	private ResourceService resourceService;
	
	private PermissionService permissionService;
	
	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Override
	public Resource getResource(String path, Session cs) {
		Resource returnValue = queryService.getResourceAsPath(path);
		if(returnValue == null || !returnValue.getActive()){
			returnValue = new Resource();
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
			return returnValue;
		}
		if(permissionService.checkReadPermission(returnValue, cs)){
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			fillResource(returnValue, cs);
		}else{
			returnValue = new Resource();
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_READ);
		}
		return returnValue;
	}

	@Override
	public Resource getResource(Resource resource, Session cs) {
		if(resource==null || resource.getId()==null){
			resource = new Resource();
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
			return resource;
		}
		Long resourceId = resource.getId();
		Resource returnValue = queryService.getResource(resourceId);
		if(returnValue == null || !returnValue.getActive()){
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
			return resource;
		}
		if(permissionService.checkReadPermission(returnValue, cs)){
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			fillResource(returnValue, cs);
			resource = returnValue ;
		}else{
			resource = new Resource();
			resource.setId(resourceId);
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_READ);
		}
		return resource;
	}
	@Transactional
	@Override
	public Resource createResource(Resource resource, Session cs) {
		Resource parent = queryService.getResource(resource.getParentId());
		if(permissionService.checkWritePermission(parent, cs)){
			if(queryService.getResource(parent.getId(), resource.getAlias())!=null){
				resource.setCode(CommonConstants.CMS_CODE.MESSAGE_EXISTS);
			}else{
				if(CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
					resource = resourceService.saveOrUpdateResource(resource, cs);
				}else{
					BusinessObject bo = resource.getObject();
					bo.setResource(resource);
					bo = resourceService.saveOrUpdateBo(bo, cs);
					resource = bo.getResource();
					resource.setObject(bo);
				}
				resource.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			}
		}else{
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_WRITE);
		}
		return resource;
	}
	@Transactional
	@Override
	public Resource updateResource(Resource resource, Session cs) {
		Resource returnValue = queryService.getResource(resource.getId());
		Resource parent = queryService.getResource(resource.getParentId());
		if(permissionService.checkWritePermission(returnValue, cs) //&&
				//permissionService.checkWritePermission(parent, cs)
				){
			Resource existsResource = queryService.getResource(parent.getId(), resource.getAlias());
			if(existsResource==null || existsResource.getId().equals( resource.getId())){
				if(CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
					returnValue = resourceService.saveOrUpdateResource(resource, cs);
				}else{
					BusinessObject bo = resource.getObject();
					if(bo==null){
						bo = queryService.getBo(returnValue);	
					}
					bo.setResource(resource);
					bo = resourceService.saveOrUpdateBo(bo, cs);
					returnValue = bo.getResource();
					returnValue.setObject(bo);
				}
				returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			}else{
				returnValue = resource;
				returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_EXISTS);
			}
		}else{
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_WRITE);
		}
		return returnValue;
	}
	@Transactional
	@Override
	public Resource deleteResource(Resource resource, Session cs) {
		Resource returnValue = queryService.getResource(resource.getId());
		if(permissionService.checkWritePermission(returnValue, cs)){
			returnValue.setActive(Boolean.FALSE);
			resourceService.saveOrUpdateResource(returnValue, cs);
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
		}else{
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_WRITE);
		}
		return returnValue;
	}
	@Transactional
	public Resource deleteResource2(Resource resource, Session cs)throws SQLException {
		//Resource returnValue = getResource(resource,cs);
		try{
			if(permissionService.checkWritePermission(resource, cs)){
				if(!CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
					BusinessObject bo = resource.getObject();
					bo.setResource(resource);
					resourceService.deleteBo(bo, cs);
				}
				resourceService.deleteResource(resource, cs);
				resource.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			}else{
				resource.setCode(CommonConstants.CMS_CODE.MESSAGE_WRITE);
			}
		}catch(Exception e){
			resource.setCode(CommonConstants.CMS_CODE.MESSAGE_UNKNOW);
			throw new SQLException("Physics delete fialure");
		}
		return resource;
	}

	private void fillResource(Resource resource, Session cs){
		if(CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
			List<Resource> children = queryService.retrieveResourceByParent(resource.getId());
			if(children!=null && !children.isEmpty()){
				resource.setChildren(new ArrayList<Resource>());
				for(Iterator<Resource> it = children.iterator();it.hasNext();){
					Resource curr = it.next();
					Resource child = new Resource();
					child.setId(curr.getId());
					resource.getChildren().add(child);
				}
			}
		}else{
			BusinessObject bo = queryService.getBo(resource);
			resource.setObject(bo);
			//bo.setResource(null);
		}
	}

	@Override
	public Resource getResource(Resource parent, String alias, Session cs) {
		Resource returnValue = queryService.getResource(parent.getId(), alias);
		if(returnValue == null || !returnValue.getActive()){
			returnValue = new Resource();
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS);
			return returnValue;
		}
		if(permissionService.checkReadPermission(returnValue, cs)){
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_OK);
			fillResource(returnValue, cs);
		}else{
			returnValue = new Resource();
			returnValue.setParentId(parent.getId());
			returnValue.setAlias(alias);
			returnValue.setCode(CommonConstants.CMS_CODE.MESSAGE_READ);
		}
		return returnValue;
	}
}
