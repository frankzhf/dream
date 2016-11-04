package net.frank.cms.service;

import net.frank.framework.bo.Application;
import net.frank.framework.security.Session;

public interface TypeRegistrationService {
	public void registrationType(String entityClass, String description,
			String typeKey,Application applciation,Session cs);

}
