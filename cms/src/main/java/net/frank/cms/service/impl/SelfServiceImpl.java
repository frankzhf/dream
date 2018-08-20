package net.frank.cms.service.impl;

import org.springframework.transaction.annotation.Transactional;

import net.frank.cms.service.SelfService;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Image;
import net.frank.framework.bo.Person;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Staff;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ResourceService;
import net.frank.framework.web.security.ClientSession;

public class SelfServiceImpl implements SelfService {

	private QueryService queryService;

	private ResourceService resourceService;

	private static final String STAFF_ROOT = "/staff";
	private static final String PERSON_ROOT = "/person";
	private static final String DEFAULT_GROUP_PATH = "/group/Self";

	public void setQueryService(QueryService queryService) {
		this.queryService = queryService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	@Transactional
	@Override
	public void addPersonalInfo(ClientSession cs) {
		Account currentAccount = cs.getAccount();
		Staff staff = null;
		Person person = null;
		Resource groupRes = queryService.getResourceAsPath(DEFAULT_GROUP_PATH);
		if(currentAccount.getStaff$16() == null){
			Account dbAccount = (Account)queryService.getBo(currentAccount.getResource().getId());
			Resource staffParentRes = queryService.getResourceAsPath(STAFF_ROOT);
			Resource staffRes = resourceService.newResource(dbAccount.getLoginName(), staffParentRes, 
					CommonConstants.TYPE.STAFF, false, dbAccount.getResource(),groupRes,
					CommonConstants.PERMISSION.ALL, CommonConstants.PERMISSION.NONE, CommonConstants.PERMISSION.READ);
			staff = new Staff();
			staff.setResource(staffRes);
			staff.setContext$3(null);
			
			Resource personParentRes = queryService.getResourceAsPath(PERSON_ROOT);
			Resource personRes = resourceService.newResource(dbAccount.getLoginName(), personParentRes, 
					CommonConstants.TYPE.PERSON, false, dbAccount.getResource(),groupRes,
					CommonConstants.PERMISSION.ALL, CommonConstants.PERMISSION.NONE, CommonConstants.PERMISSION.READ);
			person = new Person();
			person.setResource(personRes);
			
			staff.setPerson$15(personRes);
			
			Resource imageRes = resourceService.newResource(dbAccount.getLoginName()+".pic", personParentRes, 
					CommonConstants.TYPE.IMAGE, false, dbAccount.getResource(),groupRes,
					CommonConstants.PERMISSION.ALL, CommonConstants.PERMISSION.NONE, CommonConstants.PERMISSION.READ);
			Image image = new Image();
			image.setResource(imageRes);
			
			person.setPhoto$11(imageRes);
			
			resourceService.saveOrUpdateBo(image, cs);
			resourceService.saveOrUpdateBo(person, cs);
			resourceService.saveOrUpdateBo(staff, cs);
			dbAccount.setStaff$16(staffRes);
			resourceService.saveOrUpdateBo(dbAccount, cs);
			
			currentAccount.setStaff$16(staffRes);
		}
	}
}
