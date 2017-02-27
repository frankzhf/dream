package net.frank.cms.ext.selector.unit.dao;

import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;

public interface UnitSelectorDao {
	public Unit retrieveUnitByContext(Resource context);
}
