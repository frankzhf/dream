package net.frank.repository.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.repository.CommonConstants;
import net.frank.commons.util.DateUtil;
import net.frank.repository.authorization.RepositorySizeAuthorization;
import net.frank.repository.bo.File;
import net.frank.repository.bo.SharedRequest;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Limit;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.AclDao;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.repository.service.FileRepositoryService;

public final class FileRepositoryServiceImpl extends RepositoryQueryServiceImpl implements FileRepositoryService {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String CURRENT_SERVICE_OPERATE_GROUP_PATH = "/groups/Self";
	
	private static final String REPOSITORY_FOLDER = "repository";
	
	private static final String PENDING_FOLDER = "pending";
	
	private static final String FOLDER_DATE_FROMAT = "yyyyMMdd";

	private static Resource GROUP_RESOURCE = null;

	private CmsService cmsService;
	
	private BaseDao baseDao;
	
	private AclDao aclDao;

	private String repositoryPath;
	
	private int bufferLength;

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}
	
	public void setBaseDao(BaseDao baseDao){
		this.baseDao = baseDao;
	}
	
	public void setAclDao(AclDao aclDao){
		this.aclDao = aclDao;
	}

	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}
	
	public void setBufferLength(int bufferLength){
		this.bufferLength = bufferLength;
	}

	@Override
	public Integer mkdir(Resource parent, String name, Session cs) {
		Resource folder = fillResource(parent, name,
				CommonConstants.TYPE.RESOURCE, cs);
		folder = cmsService.createResource(folder, cs);
		return folder.getCode();
	}

	@Override
	public Integer remove(Resource parent, String name, Session cs) {
		return null;
	}

	@Override
	public Integer rename(Resource parent, String oldName, String newName,
			Session cs) {
		return null;
	}
	
	@Override
	public Integer createFile(Resource parent, String fileName, Integer length,
			InputStream content, Session cs) {
		return createFile(parent,fileName,length,content,cs,true);
	}
	
	@Override
	public Integer createFile(Resource parent, String fileName, Integer length,
			InputStream content, Session cs, boolean checkFileSize) {
		Limit limit = null;
		if(checkFileSize){
			limit = (Limit)cs.getAttribute(RepositorySizeAuthorization.REPO_CAPACITY_KEY);
			if(limit.getCurrentValue() + length > limit.getLimitValue()){
				return CommonConstants.CMS_CODE.MESSAGE_LIMIT_MAX_CAPACITY;
			}
		}
		Resource fileResource = fillResource(parent, fileName,
				CommonConstants.TYPE.FILE, cs);
		File file = new File();
		file.setResource(fileResource);
		fileResource.setObject(file);
		
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		String fileSystemName = UUID.randomUUID().toString();
		file.setFileName(fileName);
		file.setLength(length);
		
		StringBuffer filePath = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
		filePath.append(repositoryPath).append(java.io.File.separator).append(DateUtil.toString(currentDate,
				FOLDER_DATE_FROMAT));
		java.io.File _folder = new java.io.File(filePath.toString());
		if(!_folder.exists()){
			_folder.mkdir();
		}
		filePath.append(java.io.File.separator).append(c.get(Calendar.HOUR_OF_DAY));
		_folder = new java.io.File(filePath.toString());
		if(!_folder.exists()){
			_folder.mkdir();
		}
		filePath.append(java.io.File.separator).append(fileSystemName);
		file.setReponsitoryName(filePath.toString());
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(filePath.toString());
			byte[] buffer = new byte[getBufferLength()];
			int flag = -1;
			while((flag=content.read(buffer))!=-1){
				fos.write(buffer, 0, flag);
			}
			fos.flush();
		}catch(IOException e){
			log.error("FileRepositoryServiceImpl.createFile() error:\n"+e.getMessage());
			java.io.File _file = new java.io.File(filePath.toString());
			if(_file.exists()){
				_file.delete();
			}
			return CommonConstants.CMS_CODE.MESSAGE_UNKNOW;
		}finally{
			try{
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
				
			}
		}
		try{
			fileResource.setOwnGroupResourceId(getOperateGroupId(cs));
			fileResource = cmsService.createResource(fileResource, cs);
			if(checkFileSize){
				limit.setCurrentValue(limit.getCurrentValue() + length);
				baseDao.saveObject(limit);
			}
			if(!CommonConstants.CMS_CODE.MESSAGE_OK.equals(fileResource.getCode())){
				java.io.File _file = new java.io.File(filePath.toString());
				if(_file.exists()){
					_file.delete();
				}
			}
		}catch(Exception e){
			java.io.File _file = new java.io.File(filePath.toString());
			if(_file.exists()){
				_file.delete();
			}
			return CommonConstants.CMS_CODE.MESSAGE_UNKNOW;
		}
		return fileResource.getCode();
	}

	@Override
	public Integer updateFile(Resource parent, String fileName,
			InputStream content, Session cs) {
		return null;
	}

	@Override
	public Integer moveFile(Resource oldParent, String fileName,
			Resource newParent, Session cs, boolean clone) {
		return null;
	}

	@Override
	public Integer deleteFile(File file, Session cs) {
		Limit limit = (Limit)cs.getAttribute(RepositorySizeAuthorization.REPO_CAPACITY_KEY);
		limit.setCurrentValue(limit.getCurrentValue()-file.getLength());
		baseDao.saveObject(limit);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	@Override
	public Integer getFileContent(File file,
			OutputStream context, Session cs){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file.getReponsitoryName());
			byte[] buffer = new byte[getBufferLength()];
			int flag = -1;
			while((flag=fis.read(buffer))!=-1){
				context.write(buffer, 0, flag);
			}
		} catch (IOException e) {
			log.error("FileRepositoryServiceImpl.getFileContent() error:\n"+e.getMessage());
			return CommonConstants.CMS_CODE.MESSAGE_UNKNOW;
		}finally{
			try{
				if(fis!=null){
					fis.close();
				}
			}catch (IOException e) {
				
			}
		}
		return CommonConstants.CMS_CODE.MESSAGE_OK;
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
		resource.setOwnResourceId(cs.getAccount().getResource().getId());
		resource.setOwnGroupResourceId(getOperateGroupId(cs));
		resource.setLastAccountResourceId(null);
		resource.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
		resource.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
		resource.setOthersPermission(CommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
		return resource;
	}

	private Long getOperateGroupId(Session cs) {
		if (GROUP_RESOURCE == null) {
			GROUP_RESOURCE = cmsService.getResource(
					CURRENT_SERVICE_OPERATE_GROUP_PATH, cs);
		}
		return GROUP_RESOURCE.getId();
	}
	
	/**
	private Resource getUnitPublisher(Resource unitRes){
		Unit unit = (Unit) unitRes.getObject();
		String unitCode = unit.getUnitCode();
		Resource context = unit.getContext$3();
		Session rootSession = new RootSession();
		Resource group = cmsService.getResource(context, UNIT_GROUP_FOLDER, rootSession);
		Resource publisherGroup = cmsService.getResource(group, unitCode + UNIT_PUBLISHER_SUFFIX, rootSession);
		return publisherGroup;
	}
	**/
	private void setPublisherPermission(Resource resource){
		//resource.setOwnGroupResourceId(getUnitPublisher(unitRes));
		resource.setCurrentAccountPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.CURRENT_ACCOUNT);
		resource.setCurrentGroupPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.CURRENT_GROUP);
		resource.setOthersPermission(CommonConstants.PERMISSION_GROUP.PUBLISHER.OTHERS);
	}
	
	
	private int getBufferLength(){
		return bufferLength == 0 ? CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH : bufferLength;
	}

	@Override
	public Integer shareFileWithUnit(Resource fileRes, Resource unitRes,String desc, boolean clone,Session cs) {
		Resource contextRes = ((Unit)unitRes.getObject()).getContext$3();
		Resource repositoryFolder = cmsService.getResource(contextRes,REPOSITORY_FOLDER,cs);
		Resource pendingFolder = cmsService.getResource(repositoryFolder,PENDING_FOLDER,RootSessionHolder.getDefaultRootSession());
		Resource srResource = fillResource(pendingFolder, fileRes.getAlias()+"##"+unitRes.getAlias(),
				CommonConstants.TYPE.SHAREDREQUEST, cs);
		Unit currUnit = (Unit)unitRes.getObject();
		Resource ownGroupResource = getUnitPublisher(currUnit);
		srResource.setOwnGroupResourceId(ownGroupResource.getId());
		setPublisherPermission(srResource);
		Resource fileResThis = null;
		if(clone){
			File orgFile = (File) fileRes.getObject();
			fileResThis = fillResource(pendingFolder, fileRes.getAlias(), CommonConstants.TYPE.FILE, cs);
			fileResThis.setOwnGroupResourceId(ownGroupResource.getId());
			setPublisherPermission(fileResThis);
			File shareFile = new File();
			//shareFile.setResource(fileResThis);
			shareFile.setFileName(orgFile.getFileName());
			shareFile.setLength(orgFile.getLength());
			
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			String fileSystemName = UUID.randomUUID().toString();
			StringBuffer filePath = new StringBuffer(CommonConstants.DEFAULT_STRING_BUFFER_LENGTH);
			filePath.append(repositoryPath).append(java.io.File.separator).append(DateUtil.toString(currentDate,
					FOLDER_DATE_FROMAT));
			java.io.File _folder = new java.io.File(filePath.toString());
			if(!_folder.exists()){
				_folder.mkdir();
			}
			filePath.append(java.io.File.separator).append(c.get(Calendar.HOUR_OF_DAY));
			_folder = new java.io.File(filePath.toString());
			if(!_folder.exists()){
				_folder.mkdir();
			}
			filePath.append(java.io.File.separator).append(fileSystemName);
			shareFile.setReponsitoryName(filePath.toString());
			FileOutputStream fos = null;
			FileInputStream fis = null;
			try{
				fis = new FileInputStream(orgFile.getReponsitoryName());
				fos = new FileOutputStream(filePath.toString());
				byte[] buffer = new byte[getBufferLength()];
				int flag = -1;
				while((flag=fis.read(buffer))!=-1){
					fos.write(buffer, 0, flag);
				}
				fos.flush();
			}catch(IOException e){
				log.error("FileRepositoryServiceImpl.shareFileWithUnit() error:\n"+e.getMessage());
				java.io.File _file = new java.io.File(filePath.toString());
				if(_file.exists()){
					_file.delete();
				}
				return CommonConstants.CMS_CODE.MESSAGE_UNKNOW;
			}finally{
				try{
					if(fos!=null){
						fos.close();
					}
					if(fis!=null){
						fis.close();
					}
				}catch(IOException e){
					
				}
			}
			fileResThis.setObject(shareFile);
			cmsService.createResource(fileResThis, cs);
		}else{
			fileRes.setParentId(pendingFolder.getId());
			fileRes.setOwnGroupResourceId(ownGroupResource.getId());
			setPublisherPermission(fileRes);
			cmsService.updateResource(fileRes, cs);
			Limit limit = (Limit)cs.getAttribute(RepositorySizeAuthorization.REPO_CAPACITY_KEY);
			limit.setCurrentValue(limit.getCurrentValue() - ((File)fileRes.getObject()).getLength());
			baseDao.saveObject(limit);
			fileResThis = fileRes;
			List<Acl> aclList = aclDao.listAcl(fileRes.getId());
			if(aclList !=null && !aclList.isEmpty()){
				for(Iterator<Acl> it=aclList.iterator();it.hasNext();){
					Acl currAcl = it.next();
					baseDao.removeObject(currAcl);
				}
			}
		}
		SharedRequest sr = new SharedRequest();
		sr.setAction(SharedRequest.ACTION_CREATE);
		sr.setText(desc.toCharArray());
		sr.setFile$50000(fileResThis);
		sr.setMoveTo$3(null);
		srResource.setObject(sr);
		cmsService.createResource(srResource, cs);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

}
