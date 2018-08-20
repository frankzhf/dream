package net.frank.cms.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.CoreService;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;

public class CoreServiceImpl implements CoreService {

	private QueryService queryService;

	private ResourceService resourceService;

	private static final String GROUP_ALAIS = ".group";

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@Transactional
	@Override
	public void move(Resource from, Resource to, boolean isClone,
			boolean recursive, Session cs) {
		if (!isClone) {
			from.setParentId(to.getId());
			resourceService.saveOrUpdateResource(from, cs);
		} else {
			if (recursive) {
				resourceService.cloneResourceWithRecursive(from, to, cs);
			} else {
				BusinessObject bo = null;
				BusinessObject _bo = null;
				Resource _clone = from.clone();
				_clone.setId(null);
				if (!CmsCommonConstants.TYPE.RESOURCE.equals(from.getTypeId())) {
					bo = queryService.getBo(from);
					_bo = bo.clone();
					_bo.setId(null);
					_bo.setResource(_clone);
					resourceService.saveOrUpdateBo(_bo, cs);
				} else {
					_clone.setParentId(to.getId());
					resourceService.saveOrUpdateResource(_clone, cs);
				}
			}
		}

	}
	@Transactional
	@Override
	public void changeSystemPreperties(Resource resource,
			final Byte ownPermission, final Byte groupPermission,
			final Byte otherPermission, final Long ownId, final Long groupId,
			final boolean permissionFlag, final boolean ownFlag,
			final boolean groupFlag, final boolean recursive,
			final Session cs) {
		if (!recursive) {
			if (permissionFlag) {
				resource.setCurrentAccountPermission(ownPermission);
				resource.setCurrentGroupPermission(groupPermission);
				resource.setOthersPermission(otherPermission);
			}
			if (ownFlag) {
				resource.setOwnResourceId(ownId);
			}
			if (groupFlag) {
				resource.setOwnGroupResourceId(groupId);
			}
			resourceService.saveOrUpdateResource(resource, cs);
		} else {
			if (CmsCommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
				resource = queryService.getResourceWithRecursive(resource);
				resourceService.saveResourceWithRecursive(resource, cs,
						new ResourceFilter() {
							@Override
							public boolean filter(Resource currResoruce) {
								if (permissionFlag) {
									currResoruce
											.setCurrentAccountPermission(ownPermission);
									currResoruce
											.setCurrentGroupPermission(groupPermission);
									currResoruce
											.setOthersPermission(otherPermission);
								}
								if (ownFlag) {
									currResoruce.setOwnResourceId(ownId);
								}
								if (groupFlag) {
									currResoruce.setOwnGroupResourceId(groupId);
								}
								return Boolean.TRUE;
							}
						});
			} else {
				if (permissionFlag) {
					resource.setCurrentAccountPermission(ownPermission);
					resource.setCurrentGroupPermission(groupPermission);
					resource.setOthersPermission(otherPermission);
				}
				if (ownFlag) {
					resource.setOwnResourceId(ownId);
				}
				if (groupFlag) {
					resource.setOwnGroupResourceId(groupId);
				}
				resourceService.saveOrUpdateResource(resource, cs);
			}
		}

	}
	@Transactional
	@Override
	public void activationAccount(List<Resource> accountResourceList,
			Resource defaultGroupRes, Session cs) {
		for (Iterator<Resource> it = accountResourceList.iterator(); it
				.hasNext();) {
			Resource accountRes = it.next();
			if(accountRes.getSelected()){
				final Long ownId = accountRes.getId();
				final Long ownGroupId = defaultGroupRes.getId();
				accountRes = queryService.getResource(accountRes.getId());
				accountRes.setOwnResourceId(ownId);
				accountRes.setOwnGroupResourceId(ownGroupId);
				accountRes
						.setCurrentAccountPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
				accountRes
						.setCurrentGroupPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
				accountRes
						.setOthersPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
				resourceService.saveOrUpdateResource(accountRes, cs);
				Account currentAccount = (Account) queryService.getBo(accountRes
						.getId());
				Resource accountContext = queryService
						.getResourceWithRecursive(currentAccount.getHome$3());
				resourceService.saveResourceWithRecursive(accountContext, cs,
						new ResourceFilter() {
							@Override
							public boolean filter(Resource currResoruce) {
								currResoruce.setOwnResourceId(ownId);
								currResoruce.setOwnGroupResourceId(ownGroupId);
								currResoruce
										.setCurrentAccountPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
								currResoruce
										.setCurrentGroupPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
								currResoruce
										.setOthersPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
								return Boolean.TRUE;
							}
						});
				Resource resGroup = queryService.getResource(
						accountContext.getId(), GROUP_ALAIS);
				Resource a2gRes = new Resource();
				a2gRes.setAlias(currentAccount.getResource().getAlias() + "@"
						+ defaultGroupRes.getAlias());
				a2gRes.setSystemNode(false);
				a2gRes.setActive(true);
				a2gRes.setCreatedDt(new Date());
				a2gRes.setLastUpdatedDt(new Date());
				a2gRes.setParentId(resGroup.getId());
				a2gRes.setTypeId(CommonConstants.TYPE.ACCOUNT_2_GROUP);
				a2gRes.setOwnResourceId(ownId);
				a2gRes.setOwnGroupResourceId(ownGroupId);
				a2gRes.setCurrentAccountPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_ACCOUNT);
				a2gRes.setCurrentGroupPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.CURRENT_GROUP);
				a2gRes.setOthersPermission(CmsCommonConstants.PERMISSION_GROUP.PRIVATE.OTHERS);
				Account2Group a2g = new Account2Group();
				a2g.setAccount$5(accountRes);
				a2g.setGroup$6(defaultGroupRes);
				a2g.setResource(a2gRes);
				resourceService.saveOrUpdateBo(a2g, cs);
			}
		}
	}
	@Transactional
	@Override
	public int addAcl(Long resourceId, Long ownId, Byte permission) {
		resourceService.addAcl(resourceId, ownId, permission);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	@Transactional
	@Override
	public int updateAcl(Long aclId, Long resourceId, Long ownId,
			Byte permission) {
		resourceService.updateAcl(aclId, resourceId, ownId, permission);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	@Transactional
	@Override
	public int deleteAcl(Long aclId) {
		resourceService.deleteAcl(aclId);
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}

}
