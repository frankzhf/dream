package net.frank.framework.dao;

import java.util.List;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Privilege;

public interface PrivilegeDao {
	public List<Privilege> getPrivileger(Account account);
}
