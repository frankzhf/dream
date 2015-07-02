package net.frank.framework.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Group;
import net.frank.framework.bo.Privilege;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.BaseTestCase;
import net.frank.framework.security.Session;

public class TestCmsService  extends BaseTestCase {
	private CmsService cmsService;
	private Session cs;
	
	public void setUp() {
		super.setUp();
		AccountDao accountDao = (AccountDao)getBean("accountDao");
		final Account current= accountDao.retrieveAccountByUid("root");
		Privilege p = new Privilege();
		
		Resource folderRoot = new Resource();
		folderRoot.setId(1L);
		p.setAccount$5(current.getResource());
		p.setDomain$3(folderRoot);
		
		final List<Privilege> pArray = new ArrayList<Privilege>();
		pArray.add(p);
		
		cs = new Session(){

			@Override
			public String getLocalCd() {
				return null;
			}

			@Override
			public void setLocalCd(String localCd) {
				
			}

			@Override
			public Integer getLoginType() {
				return LOGIN_TYPE_DEFAULT;
			}

			@Override
			public Integer getStatus() {
				return STATUS_LOGINED;
			}

			@Override
			public void setStatus(Integer status) {
				
			}

			@Override
			public String getLoginName() {
				return "root";
			}

			@Override
			public Account getAccount() {
				return current;
			}

			@Override
			public Group getCurrentGroup() {
				return null;
			}

			@Override
			public List<Resource> getGroups() {
				return null;
			}

			@Override
			public List<Privilege> getPrivileges() {
				return pArray;
			}

			@Override
			public Map<Long,Type> getUserTypeMap(){
				return null;
			}

			@Override
			public void setAccount(Account account) {
				
				
			}

			@Override
			public void setCurrentGroup(Group currentGroup) {
				
			}

			@Override
			public void setAttributes(Map<String, Object> attributes) {
				
			}

			@Override
			public Map<String, Object> getAttributes() {
				return null;
			}

			@Override
			public void setAttribute(String key, Object value) {
				
			}

			@Override
			public Object getAttribute(String key) {
				return null;
			}
			
		};
		
		cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
	}
	
	
	public void testDeleteFunction(){
		Resource resource = cmsService.getResource("/home/.zhaofeng/.groups/zhaofeng@Self", cs);
		try{
			cmsService.deleteResource2(resource, cs);
		}catch(SQLException e){
			Resource del = cmsService.getResource("/del", cs);
			resource.setActive(Boolean.FALSE);
			resource.setParentId(del.getId());
			cmsService.updateResource(resource, cs);
		}
		
	}


	@Override
	public String[] getSpringConfig() {
		return new String[] {
				"/applicationContext-datasource.xml",
				"/applicationContext-base.xml",
				"/applicationContext-dao.xml",
				"/applicationContext-service.xml",
				"/applicationContext-test.xml"};
	}
}
