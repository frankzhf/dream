package net.frank.framework.bo;

public abstract class BusinessObject extends BaseEntity implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5729266293056330445L;
	private Resource resource = new Resource();

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}

	@Override
	public BusinessObject clone() {
		Object cloneObject = null;
		try {
			cloneObject = super.clone();
		} catch (CloneNotSupportedException e) {
			log.debug("Resource.clone() error.");
			e.printStackTrace();
		}
		return cloneObject instanceof BusinessObject ? (BusinessObject) cloneObject
				: null;
	}
}
