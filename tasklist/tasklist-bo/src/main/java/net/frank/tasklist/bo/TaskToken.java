package net.frank.tasklist.bo;

import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;

public final class TaskToken extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9153240434004220654L;

	public static final Integer ACTION_OPEN = 1;

	public static final Integer ACTION_CLOSE = 2;

	public static final Integer ACTION_ASSIGN = 3;

	private Resource parent$50003 = new Resource();

	private Resource task$50002 = new Resource();

	private Integer action;

	private Resource account$5 = new Resource();
	
	private Resource context$3 = new Resource();

	public void setParent$50003(Resource parent$50003) {
		this.parent$50003 = parent$50003;
	}

	public Resource getParent$50003() {
		return parent$50003;
	}

	public Resource getTask$50002() {
		return task$50002;
	}

	public void setTask$50002(Resource task$50002) {
		this.task$50002 = task$50002;
	}

	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public Resource getAccount$5() {
		return account$5;
	}

	public void setAccount$5(Resource account$5) {
		this.account$5 = account$5;
	}
	
	public Resource getContext$3() {
		return context$3;
	}

	public void setContext$3(Resource context$3) {
		this.context$3 = context$3;
	}
}
