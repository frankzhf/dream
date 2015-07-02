package net.frank.framework.service.impl;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.PasswordUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Person;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Staff;
import net.frank.framework.security.Session;
import net.frank.framework.service.AccountService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceFilter;
import net.frank.framework.service.ResourceService;

public class AccountServiceImpl extends BaseServiceImpl implements
		AccountService {

	private QueryService queryService;

	private ResourceService resourceService;

	// private static final String ROOT_FOLDER = "/";

	private static final String HOME_FOLDER = "/home";

	private static final String TEMPLATE_PATH = "/contextTemplate/account";
	
	private static final String DEFAULT_ACCOUNT_GROUP = "/group/Self";

	private static final String DEFAULT_UMASK = "700";
	
	private static final String STAFF_ROOT = "/staff";

	private static final String PERSON_ROOT = "/person";

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	public Account createLdapAccount(String loginName, String password,
			Session session) {
		return createAccount(loginName,password,session,Account.TYPE_LDAP);
	}
	
	@Override
	public Account addAccount(String loginName, String password, 
			Session session) {
		return createAccount(loginName,password,session,Account.TYPE_DEFAULT);
	}
	
	
	private Account createAccount(String loginName, String password,
			Session session,Integer accountType){
		Resource parent = queryService.getResourceAsPath(HOME_FOLDER);
		Resource src = queryService.getResourceAsPath(TEMPLATE_PATH);
		src = queryService.getResourceWithRecursive(src);
		resourceService.cloneResourceWithRecursive(src, parent, session, null,
				CommonConstants.POINT + loginName);
		Resource newAccountContextRes = queryService.getResourceAsPath(parent,
				CommonConstants.POINT + loginName);
		Resource newAccountRes = resourceService.newResource(loginName, parent,
				CommonConstants.TYPE.ACCOUNT, false, session.getAccount()
						.getResource(), session.getCurrentGroup().getResource(),
				CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.NONE);
		Account account = new Account();
		account.setLoginName(loginName);
		account.setPassword(PasswordUtil.MD5encode(password));
		account.setUmask(DEFAULT_UMASK);
		account.setType(accountType);
		account.setResource(newAccountRes);
		account.setHome$3(newAccountContextRes);
		account.setStaff$16(null);
		resourceService.saveOrUpdateBo(account, session);
		newAccountContextRes = queryService
				.getResourceWithRecursive(newAccountContextRes);
		final Long accountResourceId = newAccountRes.getId();
		final Resource groupRes = queryService
				.getResourceAsPath(DEFAULT_ACCOUNT_GROUP);
		resourceService.saveResourceWithRecursive(newAccountContextRes, session,
			new ResourceFilter() {
				@Override
				public boolean filter(Resource resource) {
					resource.setOwnResourceId(accountResourceId);
					resource.setOwnGroupResourceId(groupRes.getId());
					resource.setCurrentAccountPermission(CommonConstants.PERMISSION.ALL);
					resource.setCurrentGroupPermission(CommonConstants.PERMISSION.NONE);
					resource.setOthersPermission(CommonConstants.PERMISSION.NONE);
					return true;
				}
			}
		);
		
		Resource groupFolderRes = queryService.getResource(
				newAccountContextRes.getId(),
				CommonConstants.CONTEXT.ACCOUNT.GROUP);
		
		Resource a2gRes = resourceService.newResource(loginName+"@"+groupRes.getAlias(),groupFolderRes,
				CommonConstants.TYPE.ACCOUNT_2_GROUP, false, newAccountRes,
				groupRes,CommonConstants.PERMISSION.ALL,
				CommonConstants.PERMISSION.NONE,
				CommonConstants.PERMISSION.NONE);
		Account2Group a2g = new Account2Group();
		a2g.setResource(a2gRes);
		a2g.setAccount$5(newAccountRes);
		a2g.setGroup$6(groupRes);
		
		resourceService.saveOrUpdateBo(a2g, session);
		
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
				.setCurrentGroupPermission(CommonConstants.PERMISSION.WRITE);
		privilegeRes.setOthersPermission(CommonConstants.PERMISSION.NONE);
		resourceService.saveOrUpdateResource(privilegeRes, session);

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
		resourceService.saveOrUpdateResource(configRes, session);
		
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
		resourceService.saveOrUpdateBo(image, session);
		resourceService.saveOrUpdateBo(person, session);
		account.setStaff$16(staffRes);
		resourceService.saveOrUpdateBo(account, session);
		resourceService.saveOrUpdateBo(staff, session);
		
		return account;
	}

	@Override
	public boolean existAccount(String loginName) {
		String userResourcePath = HOME_FOLDER + "/" +loginName;
		Resource userResource = queryService.getResourceAsPath(userResourcePath);
		if(userResource!=null)
			return true;
		else
			return false;
	}
}
