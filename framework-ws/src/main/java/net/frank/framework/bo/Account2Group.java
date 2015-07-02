package net.frank.framework.bo;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

public final class Account2Group extends BusinessObject {

	private static final long serialVersionUID = -5863475734915958026L;
	
	private Resource account$5 = new Resource();
	
	private Resource group$6 = new Resource();

	public Resource getAccount$5() {
		return account$5;
	}

	public void setAccount$5(Resource account$5) {
		this.account$5 = account$5;
	}

	public Resource getGroup$6() {
		return group$6;
	}

	public void setGroup$6(Resource group$6) {
		this.group$6 = group$6;
	}
}
