package net.frank.framework.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;

public class AclPermissionServiceImpl extends PermissionServiceImpl {

	@Override
	public boolean checkReadPermission(Resource resource, Session cs) {
		boolean rt = super.checkReadPermission(resource, cs);
		if (!rt) {
			QueryService queryService = (QueryService) SpringContextUtil
					.getBean(ServiceNames.QUERY_SERVICE);
			List<Acl> aclList = queryService.listAcl(resource.getId());
			if (aclList != null && !aclList.isEmpty()) {
				Map<Long, Acl> aclMap = new HashMap<Long, Acl>();
				for (Iterator<Acl> it = aclList.iterator(); it.hasNext();) {
					Acl currAcl = it.next();
					aclMap.put(currAcl.getOwnId(), currAcl);
					if (currAcl.getOwnId().equals(
							cs.getAccount().getResource().getId())) {
						if (currAcl.getPermission().equals(
								CommonConstants.PERMISSION.ALL)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.RW)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.RX)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.READ)) {
							return true;
						}
					}
				}
				List<Resource> groupResList = cs.getGroups();
				if (groupResList != null && !groupResList.isEmpty()) {
					for (Iterator<Resource> it = groupResList.iterator(); it
							.hasNext();) {
						Resource groupRes = it.next();
						Acl currAcl = aclMap.get(groupRes.getId());
						if (currAcl != null) {
							if (currAcl.getPermission().equals(
									CommonConstants.PERMISSION.ALL)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.RW)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.RX)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.READ)) {
								return true;
							}
						}
					}
				}
			}
		}
		return rt;
	}

	@Override
	public boolean checkWritePermission(Resource resource, Session cs) {
		boolean rt = super.checkWritePermission(resource, cs);
		if (!rt) {
			QueryService queryService = (QueryService) SpringContextUtil
					.getBean(ServiceNames.QUERY_SERVICE);
			List<Acl> aclList = queryService.listAcl(resource.getId());
			if (aclList != null && !aclList.isEmpty()) {
				Map<Long, Acl> aclMap = new HashMap<Long, Acl>();
				for (Iterator<Acl> it = aclList.iterator(); it.hasNext();) {
					Acl currAcl = it.next();
					aclMap.put(currAcl.getOwnId(), currAcl);
					if (currAcl.getOwnId().equals(
							cs.getAccount().getResource().getId())) {
						if (currAcl.getPermission().equals(
								CommonConstants.PERMISSION.ALL)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.RW)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.WX)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.WRITE)) {
							return true;
						}
					}
				}
				List<Resource> groupResList = cs.getGroups();
				if (groupResList != null && !groupResList.isEmpty()) {
					for (Iterator<Resource> it = groupResList.iterator(); it
							.hasNext();) {
						Resource groupRes = it.next();
						Acl currAcl = aclMap.get(groupRes.getId());
						if (currAcl != null) {
							if (currAcl.getPermission().equals(
									CommonConstants.PERMISSION.ALL)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.RW)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.WX)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.WRITE)) {
								return true;
							}
						}
					}
				}
			}
		}
		return rt;
	}

	@Override
	public boolean checkRunPermission(Resource resource, Session cs) {
		boolean rt = super.checkRunPermission(resource, cs);
		if (!rt) {
			QueryService queryService = (QueryService) SpringContextUtil
					.getBean(ServiceNames.QUERY_SERVICE);
			List<Acl> aclList = queryService.listAcl(resource.getId());
			if (aclList != null && !aclList.isEmpty()) {
				Map<Long, Acl> aclMap = new HashMap<Long, Acl>();
				for (Iterator<Acl> it = aclList.iterator(); it.hasNext();) {
					Acl currAcl = it.next();
					aclMap.put(currAcl.getOwnId(), currAcl);
					if (currAcl.getOwnId().equals(
							cs.getAccount().getResource().getId())) {
						if (currAcl.getPermission().equals(
								CommonConstants.PERMISSION.ALL)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.RX)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.WX)
								|| currAcl.getPermission().equals(
										CommonConstants.PERMISSION.RUN)) {
							return true;
						}
					}
				}
				List<Resource> groupResList = cs.getGroups();
				if (groupResList != null && !groupResList.isEmpty()) {
					for (Iterator<Resource> it = groupResList.iterator(); it
							.hasNext();) {
						Resource groupRes = it.next();
						Acl currAcl = aclMap.get(groupRes.getId());
						if (currAcl != null) {
							if (currAcl.getPermission().equals(
									CommonConstants.PERMISSION.ALL)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.RX)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.WX)
									|| currAcl.getPermission().equals(
											CommonConstants.PERMISSION.RUN)) {
								return true;
							}
						}
					}
				}
			}
		}
		return rt;
	}
}
