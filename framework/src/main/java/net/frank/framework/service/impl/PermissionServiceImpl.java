package net.frank.framework.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.PermissionUtil;
import net.frank.framework.bo.IForm;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;

public class PermissionServiceImpl implements PermissionService {
	private QueryService queryService;
	
	public void setQueryService(QueryService queryService){
		this.queryService = queryService;
	}
	
	@Override
	public void fillForm(Resource resource, IForm iFrom) {
		if (resource == null) {
			return;
		}
		Boolean[] pCurrentUser = PermissionUtil.integerToBoolean(resource
				.getCurrentAccountPermission().intValue());
		iFrom.setPermission("0", pCurrentUser[0]);
		iFrom.setPermission("1", pCurrentUser[1]);
		iFrom.setPermission("2", pCurrentUser[2]);

		Boolean[] pCurrentGroup = PermissionUtil.integerToBoolean(resource
				.getCurrentGroupPermission().intValue());
		iFrom.setPermission("3", pCurrentGroup[0]);
		iFrom.setPermission("4", pCurrentGroup[1]);
		iFrom.setPermission("5", pCurrentGroup[2]);

		Boolean[] pOther = PermissionUtil.integerToBoolean(resource
				.getOthersPermission().intValue());
		iFrom.setPermission("6", pOther[0]);
		iFrom.setPermission("7", pOther[1]);
		iFrom.setPermission("8", pOther[2]);
	}

	@Override
	public void fillResource(IForm iFrom, Resource resource) {
		if (iFrom == null) {
			resource.setCurrentAccountPermission(CommonConstants.PERMISSION.NONE);
			resource.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
			resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
			return;
		}
		Map<Integer, Boolean> permissionMap = iFrom.getPermissionMap();
		Boolean[] _temp = new Boolean[3];
		for (int i = 0; i < 3; i++) {
			_temp[i % 3] = permissionMap.get(i);
		}
		resource.setCurrentAccountPermission(PermissionUtil.booleanToInteger(
				_temp).byteValue());
		for (int i = 3; i < 6; i++) {
			_temp[i % 3] = permissionMap.get(i);
		}
		resource.setCurrentGroupPermission(PermissionUtil.booleanToInteger(
				_temp).byteValue());
		for (int i = 6; i < 9; i++) {
			_temp[i % 3] = permissionMap.get(i);
		}
		resource.setOthersPermission(PermissionUtil.booleanToInteger(_temp)
				.byteValue());
	}

	@Override
	public boolean checkReadPermission(Resource resource, Session cs) {
		if (cs.getPrivileges() != null) {
			if (checkPrivileges(resource, cs.getPrivileges())) {
				return true;
			}
		}
		Map<Long, Resource> groupMap = new HashMap<Long, Resource>();
		for (Iterator<Resource> it = cs.getGroups().iterator(); it.hasNext();) {
			Resource currGroup = it.next();
			groupMap.put(currGroup.getId(), currGroup);
		}
		if (resource.getOwnResourceId().equals(
				cs.getAccount().getResource().getId())) {
			Byte permission = resource.getCurrentAccountPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RW)
					|| permission.equals(CommonConstants.PERMISSION.RX)
					|| permission.equals(CommonConstants.PERMISSION.READ)) {
				return true;
			}
		} 
		if (groupMap.get(resource.getOwnGroupResourceId()) != null) {
			Byte permission = resource.getCurrentGroupPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RW)
					|| permission.equals(CommonConstants.PERMISSION.RX)
					|| permission.equals(CommonConstants.PERMISSION.READ)) {
				return true;
			}
		} 
		Byte permission = resource.getOthersPermission();
		if (permission.equals(CommonConstants.PERMISSION.ALL)
				|| permission.equals(CommonConstants.PERMISSION.RW)
				|| permission.equals(CommonConstants.PERMISSION.RX)
				|| permission.equals(CommonConstants.PERMISSION.READ)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkWritePermission(Resource resource, Session cs) {
		if (cs.getPrivileges() != null) {
			if (checkPrivileges(resource, cs.getPrivileges())) {
				return true;
			}
		}
		Map<Long, Resource> groupMap = new HashMap<Long, Resource>();
		for (Iterator<Resource> it = cs.getGroups().iterator(); it.hasNext();) {
			Resource currGroup = it.next();
			groupMap.put(currGroup.getId(), currGroup);
		}
		if (resource.getOwnResourceId().equals(
				cs.getAccount().getResource().getId())) {
			Byte permission = resource.getCurrentAccountPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RW)
					|| permission.equals(CommonConstants.PERMISSION.WX)
					|| permission.equals(CommonConstants.PERMISSION.WRITE)) {
				return true;
			}
		}
		if (groupMap.get(resource.getOwnGroupResourceId()) != null) {
			Byte permission = resource.getCurrentGroupPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RW)
					|| permission.equals(CommonConstants.PERMISSION.WX)
					|| permission.equals(CommonConstants.PERMISSION.WRITE)) {
				return true;
			}
		}
		Byte permission = resource.getOthersPermission();
		if (permission.equals(CommonConstants.PERMISSION.ALL)
				|| permission.equals(CommonConstants.PERMISSION.RW)
				|| permission.equals(CommonConstants.PERMISSION.WX)
				|| permission.equals(CommonConstants.PERMISSION.WRITE)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkRunPermission(Resource resource, Session cs) {
		if (cs.getPrivileges() != null) {
			if (checkPrivileges(resource, cs.getPrivileges())) {
				return true;
			}
		}
		Map<Long, Resource> groupMap = new HashMap<Long, Resource>();
		for (Iterator<Resource> it = cs.getGroups().iterator(); it.hasNext();) {
			Resource currGroup = it.next();
			groupMap.put(currGroup.getId(), currGroup);
		}
		if (resource.getOwnResourceId().equals(
				cs.getAccount().getResource().getId())) {
			Byte permission = resource.getCurrentAccountPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RX)
					|| permission.equals(CommonConstants.PERMISSION.WX)
					|| permission.equals(CommonConstants.PERMISSION.RUN)) {
				return true;
			}
		}
		if (groupMap.get(resource.getOwnGroupResourceId()) != null) {
			Byte permission = resource.getCurrentGroupPermission();
			if (permission.equals(CommonConstants.PERMISSION.ALL)
					|| permission.equals(CommonConstants.PERMISSION.RX)
					|| permission.equals(CommonConstants.PERMISSION.WX)
					|| permission.equals(CommonConstants.PERMISSION.RUN)) {
				return true;
			}
		}
		Byte permission = resource.getOthersPermission();
		if (permission.equals(CommonConstants.PERMISSION.ALL)
				|| permission.equals(CommonConstants.PERMISSION.RX)
				|| permission.equals(CommonConstants.PERMISSION.WX)
				|| permission.equals(CommonConstants.PERMISSION.RUN)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Resource> filterList(List<Resource> resourceList, Session cs) {
		for (Iterator<Resource> it = resourceList.iterator(); it.hasNext();) {
			Resource resource = it.next();
			if (!resource.getActive()) {
				if (!(cs.getPrivileges() != null && checkPrivileges(resource,
						cs.getPrivileges()))) {
					it.remove();
				}
			}
		}
		return resourceList;
	}

	private boolean checkPrivileges(Resource resource,
			List<Privilege> privileges) {
		if (privileges == null || privileges.isEmpty()) {
			return Boolean.FALSE;
		}
		Resource currentResource = resource;
		//QueryService queryService = (QueryService) SpringContextUtil
		//		.getBean(ServiceNames.QUERY_SERVICE);
		Resource checkResource = resource;
		if (isIncludeList(checkResource.getId(), privileges)) {
			currentResource.setPrivilege(Boolean.TRUE);
			return Boolean.TRUE;
		} else {
			if (checkResource.getParentId() == null) {
				currentResource.setPrivilege(Boolean.FALSE);
				return Boolean.FALSE;
			}
			do {
				checkResource = queryService.getResource(checkResource
						.getParentId());
				if (isIncludeList(checkResource.getId(), privileges)) {
					currentResource.setPrivilege(Boolean.TRUE);
					return Boolean.TRUE;
				}
			} while (checkResource.getParentId() != null);
		}
		currentResource.setPrivilege(Boolean.FALSE);
		return Boolean.FALSE;

	}

	private boolean isIncludeList(Long id, List<Privilege> privileges) {
		for (Iterator<Privilege> it = privileges.iterator(); it.hasNext();) {
			Privilege privilege = it.next();
			if (id.equals(privilege.getDomain$3().getId())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
