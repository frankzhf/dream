package net.frank.cms.service;

import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface AdminService {
	public void addUnit(String unitName, String unitCode,
			Resource parentUnitRes, Session cs);

	public void addGroup(String groupName, Resource parent, Session cs);

	public void addAccount(String loginName, String password, Session cs);

	public void appointManager(Long unitResourceId, Long staffResourceId,
			Session cs);

	public boolean validateAppointManager(Long unitResourceId,
			Long staffResourceId, Session cs);

	public boolean validateGrantStaffGroup(Long groupResourceId,
			Long staffResourceId,Session cs);
	
	public void grantStaffGroup(Long groupResourceId,
			Long staffResourceId,Session cs);
	
	public void removeStaffGroup(Long a2gResourceId,Session cs);
}