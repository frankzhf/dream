package net.frank.framework.dao;

import java.util.List;

import net.frank.framework.bo.Account;
import net.frank.framework.bo.Account2Group;

public interface Account2GroupDao {
	public List<Account2Group> listGroupByAccount(Account account);
}