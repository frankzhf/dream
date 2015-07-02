package net.frank.framework.bo;

public final class Privilege extends BusinessObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4776647523770286881L;

	private Resource account$5 = new Resource();
	
	private Resource domain$3 = new Resource();
	
	public Resource getAccount$5() {
		return account$5;
	}

	public void setAccount$5(Resource account$5) {
		this.account$5 = account$5;
	}

	public Resource getDomain$3() {
		return domain$3;
	}

	public void setDomain$3(Resource domain$3) {
		this.domain$3 = domain$3;
	}
}
