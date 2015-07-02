package net.frank.cms.web.common.ajaxs;

import java.util.Iterator;
import java.util.List;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.taglib.tree.TreeNode;

public class QueryServiceAjax extends BaseAjax {
	public List<Resource> getChildren(Long resourceId) {
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		return queryService.retrieveResourceByParent(resourceId);
	}
	
	public Resource getResource(Long parentId,String alias){
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		return queryService.getResource(parentId, alias);
	}

	public boolean checkResourceNode(Long resourceId) {
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource resource = queryService.getResource(resourceId);
		if (resource != null
				&& CmsCommonConstants.TYPE.RESOURCE
						.equals(resource.getTypeId())) {
			return true;
		} else {
			return false;
		}
	}

	public Long checkTypeId(Long resourceId) {
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource resource = queryService.getResource(resourceId);
		return resource.getTypeId();
	}

	public TreeNode getTreeNodeDetails(Long resourceId) {
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		Resource currentResource = queryService.getResource(resourceId);
		List<Resource> children = queryService
				.retrieveResourceByParent(resourceId);
		TreeNode current = new TreeNode();
		current.setId(currentResource.getId() + CmsCommonConstants.EMPTY_STRING);
		current.setName(currentResource.getAlias());
		current.setTypeId(currentResource.getTypeId());
		for (Iterator<Resource> it = children.iterator(); it.hasNext();) {
			Resource childResource = it.next();
			TreeNode child = new TreeNode();
			child.setId(childResource.getId() + CmsCommonConstants.EMPTY_STRING);
			child.setName(childResource.getAlias());
			child.setTypeId(childResource.getTypeId());
			current.addChild(child);
		}
		return current;
	}

	// used by selector dialog
	public TreeNode retrieveChildren(Long resourceId, Long typeId) {
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		Resource currentResource = queryService.getResource(resourceId);
		List<Resource> children = queryService.retrieveResourceByParent(resourceId);
		TreeNode current = new TreeNode();
		current.setId(currentResource.getId() + CmsCommonConstants.EMPTY_STRING);
		current.setName(currentResource.getAlias());
		current.setTypeId(currentResource.getTypeId());
		for (Iterator<Resource> it = children.iterator(); it.hasNext();) {
			Resource childResource = it.next();
			if (CmsCommonConstants.TYPE.RESOURCE.equals(childResource.getTypeId())
					|| (typeId.equals(childResource.getTypeId()) && permissionService
							.checkReadPermission(childResource,
									getClientSession()))) {
				TreeNode child = new TreeNode();
				child.setId(childResource.getId()
						+ CmsCommonConstants.EMPTY_STRING);
				child.setName(childResource.getAlias());
				child.setTypeId(childResource.getTypeId());
				current.addChild(child);
			}
		}
		return current;
	}
}
