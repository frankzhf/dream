package net.frank.framework.dao;

import net.frank.framework.bo.Account;

public interface AccountDao extends BaseDao{
	Account getBusinessObject(Long resourceId);
	Account retrieveAccountByUid(String loginName);
	Account retrieveAccountByStaff(Long staffResourceId);
}
