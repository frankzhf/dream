package net.frank.framework.spring;

import org.springframework.context.ApplicationContext;

import net.frank.framework.service.BaseService;

public class SpringContextUtil {
	public static ApplicationContext getContext() {
		return SpringContextHolder.getApplicationContext();
	}

	public static BaseService getService(String serviceName) {
		BaseService service = null;

		service = (BaseService) getContext().getBean(serviceName);
		return service;
	}

	public static Object getBean(String beanName) {
		return getContext().getBean(beanName);
	}
}
