package net.frank.repository.dao;

import java.util.List;

import net.frank.repository.dao.impl.rowmapper.UnitOrder;

public interface RepositoryDao {
	public List<UnitOrder> listAllUnit();
}
