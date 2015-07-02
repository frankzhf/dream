package net.frank.repository.service.impl;

import java.util.Date;
import java.util.List;

import net.frank.commons.util.DateUtil;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.AclDao;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.repository.CommonConstants;
import net.frank.repository.bo.File;
import net.frank.repository.bo.SharedRequest;
import net.frank.repository.service.UnitFileRepositoryService;

public final class UnitFileRepositoryServiceImpl extends
		RepositoryQueryServiceImpl implements UnitFileRepositoryService {
	
	private AclDao aclDao;
	
	private BaseDao baseDao;
	
	private CmsService cmsService;

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}
	
	public void setAclDao(AclDao aclDao){
		this.aclDao = aclDao;
	}
	
	public void setBaseDao(BaseDao baseDao){
		this.baseDao = baseDao;
	}

	@Override
	public int rejectShare(Long resourceId, Session cs) {
		Resource srResource = new Resource();
		srResource.setId(resourceId);
		srResource = cmsService.getResource(srResource, cs);
		SharedRequest sr = (SharedRequest)srResource.getObject();
		Unit currUnit = getUnitForResource(srResource);
		Resource unitAdminGroupRes = currUnit.getGroup$6();
		//srResource.setOwnGroupResourceId(unitAdminGroupRes.getId());
		Resource archiveFoldRes = getArchiveFolder(currUnit);
		if(SharedRequest.ACTION_CREATE.equals(sr.getAction())){
			Resource fileResource = sr.getFile$50000();
			fileResource = cmsService.getResource(fileResource, cs);
			File file = (File)fileResource.getObject();
			java.io.File _file = new java.io.File(file.getReponsitoryName());
			if (_file.exists()) {
				_file.delete();
			}
			//sr.setFile$37(null);
			
			fileResource.setActive(Boolean.FALSE);
			fileResource.setAlias(fileResource.getAlias()+"(Rejected as " + DateUtil.toString(new Date(),DateUtil.ALIGN_DATETIME_FORMAT) + ")" );
			fileResource.setParentId(archiveFoldRes.getId());
			cmsService.updateResource(fileResource, cs);
			fileResource.setOwnGroupResourceId(unitAdminGroupRes.getId());
			cmsService.updateResource(fileResource, RootSessionHolder.getDefaultRootSession());
			sr.setMoveTo$3(archiveFoldRes);
		}
		sr.setResult(SharedRequest.RESULT_REJECT);
		srResource.setAlias(srResource.getAlias()+"_"+DateUtil.toString(new Date(),DateUtil.ALIGN_DATETIME_FORMAT));
		srResource.setParentId(archiveFoldRes.getId());
		srResource = cmsService.updateResource(srResource, cs);
		srResource.setOwnGroupResourceId(unitAdminGroupRes.getId());
		srResource = cmsService.updateResource(srResource, RootSessionHolder.getDefaultRootSession());
		return srResource.getCode();
	}

	@Override
	public int validateApproveShare(Long resourceId, Long targetResourceId,
			Session cs) {
		Resource srResource = new Resource();
		srResource.setId(resourceId);
		Unit currentUnit = getUnitForResource(srResource);
		Resource publishedFolder = getPublishedFolder(currentUnit);
		if(publishedFolder.getId().equals(targetResourceId)){
			return CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS;
		}
		srResource = cmsService.getResource(srResource, cs);
		SharedRequest sr = (SharedRequest)srResource.getObject();
		Resource FileResource = sr.getFile$50000();
		Resource folderResource = new Resource();
		folderResource.setId(targetResourceId);
		folderResource = cmsService.getResource(folderResource, cs);
		if(folderResource!=null && 
				folderResource.getChildren()!=null &&
				!folderResource.getChildren().isEmpty()){
			for(int i=0;i<folderResource.getChildren().size();i++){
				Resource child = folderResource.getChildren().get(i);
				child = cmsService.getResource(child, cs);
				if(FileResource.getAlias().equals(child.getAlias())){
					return CommonConstants.CMS_CODE.MESSAGE_EXISTS;
				}
			}
		}
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	@Override
	public int approveShare(Long resourceId, Long targetResourceId, Session cs) {
		Resource srResource = new Resource();
		srResource.setId(resourceId);
		srResource = cmsService.getResource(srResource, cs);
		SharedRequest sr = (SharedRequest)srResource.getObject();
		Resource fileResource = sr.getFile$50000();
		fileResource = cmsService.getResource(fileResource, cs);
		Unit currUnit = getUnitForResource(srResource);
		Resource unitAdminGroupRes = currUnit.getGroup$6();
		Resource archiveFoldRes = getArchiveFolder(currUnit);
		if(SharedRequest.ACTION_CREATE.equals(sr.getAction())){
			Resource parentResource = new Resource();
			parentResource.setId(targetResourceId);
			parentResource = cmsService.getResource(parentResource, cs);
			fileResource.setParentId(targetResourceId);
			fileResource.setOwnResourceId(parentResource.getOwnResourceId());
			fileResource.setOwnGroupResourceId(parentResource.getOwnGroupResourceId());
			fileResource.setCurrentAccountPermission(parentResource.getCurrentAccountPermission());
			fileResource.setCurrentGroupPermission(parentResource.getCurrentGroupPermission());
			fileResource.setOthersPermission(parentResource.getOthersPermission());
			cmsService.updateResource(fileResource, cs);
			sr.setMoveTo$3(parentResource);
		}else{
			File file = (File)fileResource.getObject();
			java.io.File _file = new java.io.File(file.getReponsitoryName());
			if (_file.exists()) {
				_file.delete();
			}
			//sr.setFile$37(null);
			sr.setMoveTo$3(archiveFoldRes);
			((File)fileResource.getObject()).setReponsitoryName(CommonConstants.EMPTY_STRING);
			fileResource.setActive(Boolean.FALSE);
			fileResource.setAlias(fileResource.getAlias()+"(Remove as " + DateUtil.toString(new Date(),DateUtil.ALIGN_DATETIME_FORMAT) + ")" );
			fileResource.setParentId(archiveFoldRes.getId());
			cmsService.updateResource(fileResource, cs);
			fileResource.setOwnGroupResourceId(unitAdminGroupRes.getId());
			cmsService.updateResource(fileResource, RootSessionHolder.getDefaultRootSession());
		}
		
		sr.setResult(SharedRequest.RESULT_APPROV);
		srResource.setOwnGroupResourceId(unitAdminGroupRes.getId());
		srResource.setAlias(srResource.getAlias()+"_"+DateUtil.toString(new Date(),DateUtil.ALIGN_DATETIME_FORMAT));
		srResource.setParentId(archiveFoldRes.getId());
		srResource = cmsService.updateResource(srResource, cs);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	@Override
	public int createFolder(Long parentId, String folderName, Session cs) {
		Resource parentResource = new Resource();
		parentResource.setId(parentId);
		Unit currUnit = getUnitForResource(parentResource);
		Resource publisherFolder = getPublishedFolder(currUnit);
		if(publisherFolder.getId().equals(parentId)){
			return CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS;
		}
		parentResource = cmsService.getResource(parentResource, cs);
		Resource folder = fillResource(parentResource, folderName,
				CommonConstants.TYPE.RESOURCE, cs);
		folder = cmsService.createResource(folder, cs);
		folder.setOwnResourceId(parentResource.getOwnResourceId());
		folder.setOwnGroupResourceId(parentResource.getOwnGroupResourceId());
		folder.setLastAccountResourceId(cs.getAccount().getResource().getId());
		folder.setCurrentAccountPermission(parentResource.getCurrentAccountPermission());
		folder.setCurrentGroupPermission(parentResource.getCurrentGroupPermission());
		folder.setOthersPermission(parentResource.getOthersPermission());
		cmsService.createResource(parentResource, cs);
		List<Acl> listAcl = aclDao.listAcl(parentId);
		if(listAcl!=null && !listAcl.isEmpty()){
			for(int i=0;i<listAcl.size();i++){
				Acl acl = listAcl.get(i);
				Acl newAcl = new Acl();
				newAcl.setOwnId(acl.getOwnId());
				newAcl.setPermission(acl.getPermission());
				newAcl.setResourceId(folder.getId());
				baseDao.saveObject(newAcl);
			}
		}
		return folder.getCode();
	}
	
	
	private Resource fillResource(Resource parent, String name, Long typeId,
			Session cs) {
		Resource resource = new Resource();
		Date currentDate = new Date();
		resource.setAlias(name);
		resource.setSystemNode(Boolean.FALSE);
		resource.setActive(Boolean.TRUE);
		resource.setCreatedDt(currentDate);
		resource.setLastUpdatedDt(currentDate);
		resource.setParentId(parent.getId());
		resource.setTypeId(typeId);
		return resource;
	}

	@Override
	public int deleteFile(Long resourceId, String desc,  Session cs) {
		Resource fileResource = new Resource();
		fileResource.setId(resourceId);
		Unit currentUnit = getUnitForResource(fileResource);
		fileResource = cmsService.getResource(fileResource, cs);
		Resource unitPendingFolder = getPendingFolder(currentUnit);
		Resource ownGroupResource = getUnitPublisher(currentUnit);
		Resource srResource = fillResource(unitPendingFolder,fileResource.getAlias()+"##" +currentUnit.getResource().getAlias(),
				CommonConstants.TYPE.SHAREDREQUEST, cs);
		srResource.setOwnResourceId(cs.getAccount().getResource().getId());
		srResource.setOwnGroupResourceId(ownGroupResource.getId());
		srResource.setLastAccountResourceId(cs.getAccount().getResource().getId());
		srResource.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.CURRENT_ACCOUNT);
		srResource.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.CURRENT_GROUP);
		srResource.setOthersPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.OTHERS);
		SharedRequest sr = new SharedRequest();
		sr.setAction(SharedRequest.ACTION_DELETE);
		sr.setText(desc.toCharArray());
		sr.setFile$50000(fileResource);
		sr.setMoveTo$3(null);
		srResource.setObject(sr);
		srResource = cmsService.createResource(srResource, cs);
		//if(!CommonConstants.CMS_CODE.MESSAGE_OK.equals(srResource.getCode())){
		return srResource.getCode();
		//}
		//return 0;
	}
}
