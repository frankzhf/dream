package net.frank.aa.service.impl.a11n;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Type;
import net.frank.framework.security.Authorization;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.app.DefaultApp;

public class TypeAuthorization implements Authorization {

	private DefaultApp defaultApp;

	private CmsService cmsService;

	public void setDefaultApp(DefaultApp defaultApp) {
		this.defaultApp = defaultApp;
	}

	public void setCmsService(CmsService cmsService) {
		this.cmsService = cmsService;
	}

	@Override
	public void exec(Session session) {
		if (Session.STATUS_LOGINED.equals(session.getStatus())) {
			Map<Long, Type> appTypeMap = defaultApp.getTypeMap();
			Map<Long, Type> userTypeMap = new HashMap<Long, Type>();
			if (!appTypeMap.isEmpty()) {
				for (Iterator<Long> it = appTypeMap.keySet().iterator(); it
						.hasNext();) {
					Long id = it.next();
					Resource res = new Resource();
					res.setId(id);
					res = cmsService.getResource(res, session);
					if (CommonConstants.CMS_CODE.MESSAGE_OK.equals(res
							.getCode())) {
						Type type = (Type) res.getObject();
						userTypeMap.put(id, type);
					}
				}
			}
			session.setAttribute(Session.CS_ATTRIBLE_TYPES_KEY, userTypeMap);
		}
	}
}
