package net.frank.framework.web.spring;

import javax.servlet.ServletContextEvent;

import net.frank.framework.spring.SpringContextHolder;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextLoaderListener extends
		org.springframework.web.context.ContextLoaderListener {

	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
		SpringContextHolder.setApplicationContext(context);
	}

}
