package net.frank.framework.dao;

import java.util.List;

import net.frank.framework.bo.SystemHistory;

public interface SystemHistoryDao {
	public List<SystemHistory> listHistory(Long resourceId);
	public SystemHistory getSystemHistory(Long id);
}
