package net.frank.repository.web.ajaxs;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.repository.CommonConstants;
import net.frank.repository.bo.File;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.dao.AclDao;
import net.frank.framework.dao.BaseDao;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.repository.service.FileRepositoryService;
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeNode;
import net.frank.repository.web.tags.MyFilesTreeBuilder;

public class RepositoryServiceAjax extends BaseAjax {

	private static final String HOME_PATH_PREFFIX = "/home/.";

	public Resource getResource(Long parentId, String alias) {
		ClientSession cs = getClientSession();
		Resource parent = new Resource();
		parent.setId(parentId);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		return cmsService.getResource(parent, alias, cs);
	}

	public Resource getResource2(Long resoruceId) {
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(resoruceId);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		return cmsService.getResource(currentResource, cs);
	}

	public int deleteFile(Long resourceId) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource deleteFile = new Resource();
		deleteFile.setId(resourceId);
		deleteFile = cmsService.getResource(deleteFile, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(deleteFile.getCode())) {
			return deleteFile.getCode();
		}
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sb.append(HOME_PATH_PREFFIX).append(cs.getAccount().getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.CONTEXT.ACCOUNT.RECYCLE_BIN);
		Resource myRecycleBin = cmsService.getResource(sb.toString(), cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(myRecycleBin.getCode())) {
			return myRecycleBin.getCode();
		}
		deleteFile.setParentId(myRecycleBin.getId());
		deleteFile = cmsService.updateResource(deleteFile, cs);
		return deleteFile.getCode();
	}

	public int createFolder(Long parentId, String folderName) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		FileRepositoryService fileRepositoryService = (FileRepositoryService) getBean(ServiceNames.REPOSITORY_FILE_SERVICE);
		ClientSession cs = getClientSession();
		Resource parent = new Resource();
		parent.setId(parentId);
		parent = cmsService.getResource(parent, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(parent.getCode())) {
			return parent.getCode();
		}
		int statusCode = fileRepositoryService.mkdir(parent, folderName, cs);
		if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(statusCode)) {
			TreeNode node = new TreeNode();
			@SuppressWarnings("unchecked")
			Map<Long, TreeNode> nodeMap = (Map<Long, TreeNode>) getAjaxTemplate()
					.getRequest()
					.getSession()
					.getAttribute(
							MyFilesTreeBuilder.MY_FILES_NODE_MAP_SESSION_KEY);
			TreeNode _parent = nodeMap.get(parentId);
			Resource _node  = cmsService.getResource(parent, folderName, cs);
			node.setId(_node.getId()+CommonConstants.EMPTY_STRING);
			node.setName(folderName);
			node.setTypeId(CommonConstants.TYPE.RESOURCE);
			_parent.addChild(node);
			nodeMap.put(_node.getId(), node);
		}
		return statusCode;
	}

	public int renameFile(Long resourceId, String newName) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(resourceId);
		currentResource = cmsService.getResource(currentResource, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource
				.getCode())) {
			return currentResource.getCode();
		}
		currentResource.setAlias(newName);
		((File) currentResource.getObject()).setFileName(newName);
		currentResource = cmsService.updateResource(currentResource, cs);
		return currentResource.getCode();
	}

	public int renameFolder(Long resourceId, String newName) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(resourceId);
		currentResource = cmsService.getResource(currentResource, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource
				.getCode())) {
			return currentResource.getCode();
		}
		currentResource.setAlias(newName);
		currentResource = cmsService.updateResource(currentResource, cs);
		if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource.getCode())) {
			@SuppressWarnings("unchecked")
			Map<Long, TreeNode> nodeMap = (Map<Long, TreeNode>) getAjaxTemplate()
					.getRequest()
					.getSession()
					.getAttribute(
							MyFilesTreeBuilder.MY_FILES_NODE_MAP_SESSION_KEY);
			TreeNode currNode = nodeMap.get(resourceId);
			currNode.setName(newName);
		}
		return currentResource.getCode();
	}

	public int deleteFolder(Long resourceId) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(resourceId);
		currentResource = cmsService.getResource(currentResource, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource
				.getCode())) {
			return currentResource.getCode();
		}
		StringBuffer sb = new StringBuffer(
				CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		sb.append(HOME_PATH_PREFFIX).append(cs.getAccount().getLoginName())
				.append(CommonConstants.PATH_SYMBOL)
				.append(CommonConstants.CONTEXT.ACCOUNT.RECYCLE_BIN);
		Resource myRecycleBin = cmsService.getResource(sb.toString(), cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(myRecycleBin.getCode())) {
			return myRecycleBin.getCode();
		}
		currentResource.setParentId(myRecycleBin.getId());
		currentResource = cmsService.updateResource(currentResource, cs);
		if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource.getCode())) {
			@SuppressWarnings("unchecked")
			Map<Long, TreeNode> nodeMap = (Map<Long, TreeNode>) getAjaxTemplate()
					.getRequest()
					.getSession()
					.getAttribute(
							MyFilesTreeBuilder.MY_FILES_NODE_MAP_SESSION_KEY);
			TreeNode currNode = nodeMap.get(resourceId);
			TreeNode parent =  currNode.getParent();
			parent.remove(currNode);
			nodeMap.remove(resourceId);
		}
		return currentResource.getCode();
	}

	public int restoreItem(Long parentId, Long itemId) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(itemId);
		currentResource = cmsService.getResource(currentResource, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource
				.getCode())) {
			return currentResource.getCode();
		}
		Resource parent = new Resource();
		parent.setId(parentId);
		parent = cmsService.getResource(parent, cs);
		currentResource.setParentId(parent.getId());
		currentResource = cmsService.updateResource(currentResource, cs);
		if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource.getCode())
				&& CommonConstants.TYPE.RESOURCE.equals(currentResource.getTypeId())) {
			TreeNode node = new TreeNode();
			@SuppressWarnings("unchecked")
			Map<Long, TreeNode> nodeMap = (Map<Long, TreeNode>) getAjaxTemplate()
					.getRequest().getSession()
						.getAttribute(
							MyFilesTreeBuilder.MY_FILES_NODE_MAP_SESSION_KEY);
			TreeNode _parent = nodeMap.get(parentId);
			node.setId(currentResource.getId()+CommonConstants.EMPTY_STRING);
			node.setName(currentResource.getAlias());
			node.setTypeId(CommonConstants.TYPE.RESOURCE);
			_parent.addChild(node);
			nodeMap.put(currentResource.getId(), node);
		}
		return currentResource.getCode();
	}

	public int deleteItem(Long itemId) {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource currentResource = new Resource();
		currentResource.setId(itemId);
		currentResource = cmsService.getResource(currentResource, cs);
		if (!CommonConstants.CMS_CODE.MESSAGE_OK.equals(currentResource
				.getCode())) {
			return currentResource.getCode();
		}
		try {
			if (CommonConstants.TYPE.FILE.equals(currentResource.getTypeId())) {
				removeFile(currentResource, cs);
				return currentResource.getCode();
			} else {
				int statusCode = removeFolder(currentResource, cs);
				return statusCode;
			}
		} catch (SQLException e) {

		}
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	
	public int validateShareFile(Long fileId,Long ownId){
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		AccountDao accountDao = (AccountDao)getBean("accountDao");
		ClientSession cs = getClientSession();
		Resource file = new Resource();
		file.setId(fileId);
		file = cmsService.getResource(file, cs);
		if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(file.getCode())){
			Account account = accountDao.retrieveAccountByStaff(ownId);
			if(account.getResource().getId().equals(file.getOwnResourceId())){
				//CUSTOM ERROR can't share to self
				return CommonConstants.CMS_CODE.MESSAGE_WRITE;
			}
			List<Acl> aclList = repositoryQueryService.listAcl(fileId, ownId);
			if(!aclList.isEmpty()){
				//CUSTOM ERROR it have shared to specify account
				return CommonConstants.CMS_CODE.MESSAGE_RUN;
			}
		}else{
			return file.getCode();
		}
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	public int shareFile(Long fileId,Long ownId){
		AccountDao accountDao = (AccountDao)getBean("accountDao");
		Account account = accountDao.retrieveAccountByStaff(ownId);
		Acl acl = new Acl();
		acl.setResourceId(fileId);
		acl.setOwnId(account.getResource().getId());
		acl.setPermission(CommonConstants.PERMISSION.READ);
		accountDao.saveObject(acl);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	public int removeShareFile(Long aclId){
		AccountDao accountDao = (AccountDao)getBean("accountDao");
		Acl acl = new Acl();
		acl.setId(aclId);
		accountDao.removeObject(acl);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

	public int validateShareFileToProject(Long resourceId, String desc,Long projectResId){
		if(projectResId == null){
			//project can't null
			return CommonConstants.CMS_CODE.MESSAGE_RUN;
		}
		if(StringUtil.isEmpty(desc)){
			//desc can't null
			return CommonConstants.CMS_CODE.MESSAGE_READ;
		}
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Session currSession = getClientSession();
		Resource unitRes = new Resource();
		unitRes.setId(projectResId);
		unitRes = cmsService.getResource(unitRes, currSession);
		Resource fileResource = new Resource();
		fileResource.setId(resourceId);
		fileResource = cmsService.getResource(fileResource, currSession);
		Unit unit = (Unit)unitRes.getObject();
		Resource contextRes = unit.getContext$3();
		//path is $context/repository/pending 
		Resource repositoryRes = cmsService.getResource(contextRes, "repository", currSession);
		Resource pendingRes = cmsService.getResource(repositoryRes, "pending", currSession);
		Resource fileRes = cmsService.getResource(pendingRes, fileResource.getAlias(), currSession);
		if(CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS.equals(fileRes.getCode())){
			return CommonConstants.CMS_CODE.MESSAGE_OK;
		}else{
			return CommonConstants.CMS_CODE.MESSAGE_EXISTS;
		}
		
	}
	
	public int shareFileToProject(Long fileResId,Long projectResId,String desc,boolean clone){
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		FileRepositoryService fileRepositoryService = (FileRepositoryService) getBean(ServiceNames.REPOSITORY_FILE_SERVICE);
		Session currSession = getClientSession();
		Resource unitRes = new Resource();
		unitRes.setId(projectResId);
		unitRes = cmsService.getResource(unitRes, currSession);
		Resource fileResource = new Resource();
		fileResource.setId(fileResId);
		fileResource = cmsService.getResource(fileResource, currSession);
		return fileRepositoryService.shareFileWithUnit(fileResource, unitRes,desc,clone,currSession);
	}

	private int removeFile(Resource currentResource, ClientSession cs)
			throws SQLException {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		FileRepositoryService fileRepositoryService = (FileRepositoryService) getBean(ServiceNames.REPOSITORY_FILE_SERVICE);
		File file = (File) currentResource.getObject();
		java.io.File _file = new java.io.File(file.getReponsitoryName());
		if (_file.exists()) {
			_file.delete();
		}
		fileRepositoryService.deleteFile(file, cs);
		AclDao aclDao = (AclDao) getBean("aclDao");
		BaseDao baseDao = (BaseDao) getBean("baseDao");
		List<Acl> aclList = aclDao.listAcl(currentResource.getId());
		if(aclList !=null && !aclList.isEmpty()){
			for(Iterator<Acl> it=aclList.iterator();it.hasNext();){
				Acl currAcl = it.next();
				baseDao.removeObject(currAcl);
			}
		}
		currentResource = cmsService.deleteResource2(currentResource, cs);
		return currentResource.getCode();
	}

	private int removeFolder(Resource currentResource, ClientSession cs)
			throws SQLException {
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		List<Resource> children = currentResource.getChildren();
		if (children != null && !children.isEmpty()) {
			for (Iterator<Resource> it = children.iterator(); it.hasNext();) {
				Resource child = it.next();
				child = cmsService.getResource(child, cs);
				if (CommonConstants.TYPE.FILE.equals(child.getTypeId())) {
					removeFile(child, cs);
				} else {
					removeFolder(child, cs);
				}
			}
		}
		currentResource = cmsService.deleteResource2(currentResource, cs);
		return currentResource.getCode();
	}

}
