package net.frank.framework.service;

import java.util.List;

import net.frank.framework.bo.IForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.security.Session;

public interface PermissionService {
	public void fillForm(Resource resource, IForm iFrom);

	public void fillResource(IForm iFrom, Resource resource);

	public boolean checkReadPermission(Resource resource, Session cs);

	public boolean checkWritePermission(Resource resource, Session cs);

	public boolean checkRunPermission(Resource resource, Session cs);

	public List<Resource> filterList(List<Resource> resourceList,
			Session cs);

}
