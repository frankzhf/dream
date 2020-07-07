package net.frank.cms.service.impl;

import java.util.Iterator;
import java.util.List;

import net.frank.commons.util.EncryptUtils;
import org.springframework.transaction.annotation.Transactional;

import net.frank.cms.service.AdminService;
import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Acl;
import net.frank.framework.bo.Comment;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Person;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Staff;
import net.frank.framework.bo.Unit;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.dao.PrivilegeDao;
import net.frank.framework.organization.UnitPhase;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;
import net.frank.framework.service.impl.BaseServiceImpl;

public class AdminServiceImpl extends BaseServiceImpl  implements AdminService {

	private static final String DEFUALT_UNIT_ROOT = "/unit";

	private static final String DEFAULT_HOME = "/home";

	private static final String UNIT_CONTEXT_TEMPLATE = "/contextTemplate/unit";

	private static final String ACCOUNT_CONTEXT_TEMPLATE = "/contextTemplate/account";

	private static final String DEFAULT_ACCOUNT_GROUP = "/group/Self";

	private static final String DEFAULT_GROUP_ROOT = "/group";

	private static final String STAFF_ROOT = "/staff";

	private static final String PERSON_ROOT = "/person";
	
	//private static final String DEFAULT_READ_UNIT_GROUP_PATH = "/unit/.3410/group/Staff";

	private QueryService queryService;

	private ResourceService resourceService;

	private AccountDao accountDao;

	private PrivilegeDao privilegeDao;
	
	private String unitPhasePath;
	
	public void setUnitPhasePath(String unitPhasePath){
		this.unitPhasePath = unitPhasePath;
	}

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}
	@Transactional
	@Override
	public void addUnit(String unitName, String unitCode,
			Resource parentUnitRes, Session cs) {
		Resource parent = null;
		Resource adminGroup = null;
		addAccount("Unit-admin-" + unitCode, "p@ssw0rd", cs);
		Resource unitAdminAccount = queryService.getResourceAsPath(DEFAULT_HOME
				+ "/Unit-admin-" + unitCode);
		unitAdminAccount.setActive(false);

		Resource unitAdminStaff = queryService.getResourceAsPath(STAFF_ROOT
				+ "/Unit-admin-" + unitCode);

		resourceService.saveOrUpdateResource(unitAdminAccount, cs);

		Acl acl = new Acl();
		acl.setResourceId(unitAdminAccount.getId());
		acl.setOwnId(unitAdminAccount.getId());
		acl.setPermission(CommonConstants.PERMISSION.READ);

		resourceService.saveObject(acl);

		Resource parentUnitOwn = null;
		Resource parentUnitOwnGroup = null;

		if (parentUnitRes != null) {
			Unit parentUnit = (Unit) queryService.getBo(parentUnitRes.getId());
			Resource parentUnitContext = parentUnit.getContext$3();
			parent = queryService.getResource(parentUnitContext.getId(),
					CommonConstants.CONTEXT.UNIT.CHILDREN);
			Resource parentGroupRes = queryService.getResource(
					parentUnitContext.getId(),
					CommonConstants.CONTEXT.UNIT.GROUP);
			addGroup(unitCode + "-admin", parentGroupRes, cs);
			adminGroup = queryService.getResource(parentGroupRes.getId(),
					unitCode + "-admin");

			parentUnitOwn = parentUnit.getOwn$5();
			parentUnitOwnGroup = parentUnit.getGroup$6();
		} else {
			parent = queryService.getResourceAsPath(DEFUALT_UNIT_ROOT);
			Resource parentGroupRes = queryService
					.getResourceAsPath(DEFAULT_GROUP_ROOT);
			addGroup(unitCode + "-admin", parentGroupRes, cs);
			adminGroup = queryService.getResource(parentGroupRes.getId(),
					unitCode + "-admin");
			parentUnitOwn = cs.getAccount().getResource();
			parentUnitOwnGroup = cs.getCurrentGroup().getResource();
		}

		Resource src = queryService.getResourceAsPath(UNIT_CONTEXT_TEMPLATE);
		src = queryService.getResourceWithRecursive(src);

		resourceService.cloneResourceWithRecursive(src, parent, cs, null,
				CommonConstants.POINT + unitCode);
		Resource newUnitContextRes = queryService.getResourceAsPath(parent,
				CommonConstants.POINT + unitCode);
		Resource newUnitRes = resourceService.newResource(unitName, parent,
				CommonConstants.TYPE.UNIT, true, parentUnitOwn,
				parentUnitOwnGroup, CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.READ,
				CommonConstants.PERMISSION.NONE);
		Unit unit = new Unit();
		unit.setResource(newUnitRes);
		unit.setUnitName(unitName);
		unit.setUnitCode(unitCode);
		unit.setManager$16(unitAdminStaff);
		unit.setOwn$5(unitAdminAccount);
		unit.setGroup$6(adminGroup);
		unit.setContext$3(newUnitContextRes);
		resourceService.saveOrUpdateBo(unit, cs);
		Resource groupRes = queryService.getResourceAsPath(newUnitContextRes,
				CommonConstants.CONTEXT.UNIT.GROUP);
		addGroup(unitCode + "-User", groupRes, cs);
		
		final Long unitAccountResourceId = unitAdminAccount.getId();
		final Long unitGroupResourceId = adminGroup.getId();
		
		newUnitContextRes = queryService
				.getResourceWithRecursive(newUnitContextRes);
		resourceService.saveResourceWithRecursive(newUnitContextRes, cs,
				new ResourceFilter() {
					@Override
					public boolean filter(Resource resource) {
						resource.setOwnResourceId(unitAccountResourceId);
						resource.setOwnGroupResourceId(unitGroupResourceId);
						resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
						resource.setCurrentGroupPermission(CommonConstants.PERMISSION.READ);
						resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
						return true;
					}
				});
		
		Resource unitPhasePathRes = queryService.getResourceAsPath(unitPhasePath);
		if(unitPhasePathRes!=null){
			List<Resource> children = queryService.retrieveResourceByParent(unitPhasePathRes.getId());
			for(Iterator<Resource> it=children.iterator();it.hasNext();){
				Resource child = it.next();
				if(CommonConstants.TYPE.COMMENT.equals(child.getTypeId())){
					Comment comment = (Comment)queryService.getBo(child);
					String unitPhaseClassName = new String(comment.getText());
					if(StringUtil.isNotEmpty(unitPhaseClassName)){
						UnitPhase refer = null;
						try{
							refer = (UnitPhase) Class.forName(unitPhaseClassName).newInstance();
						}catch(ClassNotFoundException e){
							log.error(e.getMessage(),e);
						}catch(IllegalAccessException e){
							log.error(e.getMessage(),e);
						}catch(InstantiationException e){
							log.error(e.getMessage(),e);
						}
						if(refer!=null){
							refer.exec(unit, newUnitContextRes, cs);
						}
					}
				}
			}
		}	
	}
	@Transactional
	@Override
	public void addGroup(String groupName, Resource parent, Session cs) {
		Resource newGroupRes = resourceService.newResource(groupName, parent,
				CommonConstants.TYPE.GROUP, false, cs.getAccount()
						.getResource(), cs.getCurrentGroup().getResource(),
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.READ,
				CommonConstants.PERMISSION.NONE);
		Group group = new Group();
		group.setGroupName(groupName);
		group.setResource(newGroupRes);
		resourceService.saveOrUpdateBo(group, cs);
	}
	@Transactional
	@Override
	public void addAccount(String loginName, String password, Session cs) {
		Resource parent = queryService.getResourceAsPath(DEFAULT_HOME);
		Resource src = queryService.getResourceAsPath(ACCOUNT_CONTEXT_TEMPLATE);
		src = queryService.getResourceWithRecursive(src);
		resourceService.cloneResourceWithRecursive(src, parent, cs, null,
				CommonConstants.POINT + loginName);
		Resource newAccountContextRes = queryService.getResourceAsPath(parent,
				CommonConstants.POINT + loginName);
		Resource newAccountRes = resourceService.newResource(loginName, parent,
				CommonConstants.TYPE.ACCOUNT, false, cs.getAccount()
						.getResource(), cs.getCurrentGroup().getResource(),
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.NONE);
		Account account = new Account();
		account.setLoginName(loginName);
		account.setPassword(EncryptUtils.encodeDES(password));
		account.setUmask("700");
		account.setType(Account.TYPE_DEFAULT);
		account.setResource(newAccountRes);
		account.setHome$3(newAccountContextRes);
		account.setStaff$16(null);
		resourceService.saveOrUpdateBo(account, cs);
		newAccountContextRes = queryService
				.getResourceWithRecursive(newAccountContextRes);
		final Long accountResourceId = newAccountRes.getId();
		final Long groupResourceId = queryService.getResourceAsPath(
				DEFAULT_ACCOUNT_GROUP).getId();
		resourceService.saveResourceWithRecursive(newAccountContextRes, cs,
				new ResourceFilter() {
					@Override
					public boolean filter(Resource resource) {
						resource.setOwnResourceId(accountResourceId);
						resource.setOwnGroupResourceId(groupResourceId);
						resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
						resource.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
						resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
						return true;
					}
				});

		Resource privilegeRes = queryService.getResource(
				newAccountContextRes.getId(),
				CommonConstants.CONTEXT.ACCOUNT.PRIVILEGE);

		privilegeRes.setOwnResourceId(queryService.getResourceAsPath(
				"/home/root").getId());
		privilegeRes.setOwnGroupResourceId(queryService.getResourceAsPath(
				"/group/admin").getId());
		privilegeRes
				.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		privilegeRes
				.setCurrentGroupPermission(CommonConstants.PERMISSION.RW);
		privilegeRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resourceService.saveOrUpdateResource(privilegeRes, cs);
		
		
		Resource configRes = queryService.getResource(
				newAccountContextRes.getId(),
				CommonConstants.CONTEXT.ACCOUNT.PRIVILEGE);
		configRes.setOwnResourceId(queryService.getResourceAsPath(
				"/home/root").getId());
		configRes.setOwnGroupResourceId(queryService.getResourceAsPath(
				"/group/admin").getId());
		configRes
				.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
		configRes
				.setCurrentGroupPermission(CommonConstants.PERMISSION.RW);
		configRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resourceService.saveOrUpdateResource(configRes, cs);
		
		Resource groupRes = queryService
				.getResourceAsPath(DEFAULT_ACCOUNT_GROUP);

		Resource staffParentRes = queryService.getResourceAsPath(STAFF_ROOT);
		Resource staffRes = resourceService.newResource(account.getLoginName(),
				staffParentRes, CommonConstants.TYPE.STAFF, false,
				account.getResource(), groupRes,
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.READ);
		Staff staff = new Staff();
		staff.setResource(staffRes);
		staff.setContext$3(null);

		Resource personParentRes = queryService.getResourceAsPath(PERSON_ROOT);
		Resource personRes = resourceService.newResource(
				account.getLoginName(), personParentRes,
				CommonConstants.TYPE.PERSON, false, account.getResource(),
				groupRes, CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.READ);
		Person person = new Person();
		person.setEnglishName(loginName);
		person.setResource(personRes);

		staff.setPerson$15(personRes);

		Resource imageRes = resourceService.newResource(account.getLoginName()
				+ ".pic", personParentRes, CommonConstants.TYPE.IMAGE, false,
				account.getResource(), groupRes,
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.READ);
		Image image = new Image();
		image.setResource(imageRes);
		image.setContext$3(null);
		person.setPhoto$11(imageRes);
		resourceService.saveOrUpdateBo(image, cs);
		resourceService.saveOrUpdateBo(person, cs);
		resourceService.saveOrUpdateBo(staff, cs);
		account.setStaff$16(staffRes);
		resourceService.saveOrUpdateBo(account, cs);
	}

	@Override
	public boolean validateAppointManager(Long unitResourceId,
			Long staffResourceId, Session cs) {
		Unit unit = (Unit) queryService.getBo(unitResourceId);
		Resource manager = unit.getManager$16();
		if (manager != null && manager.getId().equals(staffResourceId)) {
			return false;
		}
		return true;
	}
	@Transactional
	@Override
	public void appointManager(Long unitResourceId, Long staffResourceId,
			Session cs) {
		Unit unit = (Unit) queryService.getBo(unitResourceId);
		Resource unitContext = unit.getContext$3();
		Resource unitGrant = queryService.getResource(unitContext.getId(),
				CommonConstants.CONTEXT.UNIT.GRANT);
		Resource manager = unit.getManager$16();
		if (manager != null) {
			Account preAccount = accountDao.retrieveAccountByStaff(manager
					.getId());
			List<Privilege> pList = privilegeDao.getPrivilege(preAccount);
			for (Iterator<Privilege> it = pList.iterator(); it.hasNext();) {
				Privilege cP = it.next();
				if (preAccount.getResource().getId()
						.equals(cP.getAccount$5().getId())
						&& unitContext.getId().equals(cP.getDomain$3().getId())) {
					Resource delResource = cP.getResource();
					resourceService.deleteBo(cP, cs);
					resourceService.deleteResource(delResource, cs);
					break;
				}
			}
		}
		Resource newManager = queryService.getResource(staffResourceId);
		unit.setManager$16(newManager);
		Account nextAccount = accountDao.retrieveAccountByStaff(newManager
				.getId());

		resourceService.saveOrUpdateBo(unit, cs);
		Resource ownRes = queryService
				.getResource(unitGrant.getOwnResourceId());
		Resource groupRes = queryService.getResource(unitGrant
				.getOwnGroupResourceId());

		Resource privilegeRes = resourceService.newResource(
				nextAccount.getLoginName() + "@" + unitContext.getAlias(),
				unitGrant, CommonConstants.TYPE.PRIVILEGE, true, ownRes,
				groupRes, unitGrant.getCurrentAccountPermission(),
				unitGrant.getCurrentGroupPermission(),
				unitGrant.getOthersPermission());
		Privilege priv = new Privilege();
		priv.setResource(privilegeRes);
		priv.setAccount$5(nextAccount.getResource());
		priv.setDomain$3(unitContext);
		resourceService.saveOrUpdateBo(priv, cs);
	}

	@Override
	public boolean validateGrantStaffGroup(Long groupResourceId,
			Long staffResourceId, Session cs) {
		Account account = accountDao.retrieveAccountByStaff(staffResourceId);
		Resource groupRes = queryService.getResource(groupResourceId);
		Resource groupFolderRes = queryService.getResource(groupRes
				.getParentId());
		Resource unitContextRes = queryService.getResource(groupFolderRes
				.getParentId());
		Resource grantFolderRes = queryService.getResource(
				unitContextRes.getId(), CommonConstants.CONTEXT.UNIT.GRANT);
		List<Resource> children = queryService
				.retrieveResourceByParent(grantFolderRes.getId());
		if (children != null && !children.isEmpty()) {
			for (Iterator<Resource> it = children.iterator(); it.hasNext();) {
				Resource child = it.next();
				if (CommonConstants.TYPE.ACCOUNT_2_GROUP.equals(child
						.getTypeId())) {
					Account2Group a2g = (Account2Group) queryService
							.getBo(child.getId());
					if (a2g.getAccount$5().getId()
							.equals(account.getResource().getId())
							&& a2g.getGroup$6().getId().equals(groupResourceId)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	@Transactional
	@Override
	public void grantStaffGroup(Long groupResourceId, Long staffResourceId,
			Session cs) {
		Account account = accountDao.retrieveAccountByStaff(staffResourceId);
		Resource groupRes = queryService.getResource(groupResourceId);
		Resource groupFolderRes = queryService.getResource(groupRes
				.getParentId());
		Resource unitContextRes = queryService.getResource(groupFolderRes
				.getParentId());
		Resource grantFolderRes = queryService.getResource(
				unitContextRes.getId(), CommonConstants.CONTEXT.UNIT.GRANT);
		Resource ownRes = queryService.getResource(grantFolderRes
				.getOwnResourceId());
		Resource ownGroupRes = queryService.getResource(grantFolderRes
				.getOwnGroupResourceId());
		Resource a2gResource = resourceService.newResource(account
				.getResource().getAlias() + "@" + groupRes.getAlias(),
				grantFolderRes, CommonConstants.TYPE.ACCOUNT_2_GROUP, false,
				ownRes, ownGroupRes,
				grantFolderRes.getCurrentAccountPermission(),
				grantFolderRes.getCurrentGroupPermission(),
				grantFolderRes.getOthersPermission());
		Account2Group a2gObject = new Account2Group();
		a2gObject.setResource(a2gResource);
		a2gObject.setAccount$5(account.getResource());
		a2gObject.setGroup$6(groupRes);
		resourceService.saveOrUpdateBo(a2gObject, cs);
	}
	@Transactional
	@Override
	public void removeStaffGroup(Long a2gResourceId, Session cs) {
		Account2Group a2g = (Account2Group) queryService.getBo(a2gResourceId);
		Resource delResource = a2g.getResource();
		resourceService.deleteBo(a2g, cs);
		resourceService.deleteResource(delResource, cs);
	}
}
