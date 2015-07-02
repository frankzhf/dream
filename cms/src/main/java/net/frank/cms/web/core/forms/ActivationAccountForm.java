package net.frank.cms.web.core.forms;

import java.util.ArrayList;
import java.util.List;

import net.frank.framework.bo.Resource;

import org.apache.struts.action.ActionForm;

public class ActivationAccountForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = -17632989299998562L;
	private List<Resource> resources = new ArrayList<Resource>();

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public void setResource(int index, Resource resource) {
		while (resources.size() <= index) {
			resources.add(new Resource());
		}
		resources.set(index, resource);
	}

	public Resource getResource(int index) {
		while (resources.size() <= index) {
			resources.add(new Resource());
		}
		return resources.get(index);
	}
	
}
