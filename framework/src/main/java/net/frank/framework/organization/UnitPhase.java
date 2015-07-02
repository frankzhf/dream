package net.frank.framework.organization;

import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.Session;

public interface UnitPhase {
	public void exec(Unit unit, Resource unitContext, Session cs);
}
