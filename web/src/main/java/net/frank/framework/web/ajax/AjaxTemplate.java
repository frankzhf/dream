package net.frank.framework.web.ajax;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import org.directwebremoting.WebContextFactory;


public class AjaxTemplate {
	public ServletContext getServletContext(){
		return WebContextFactory.get().getServletContext();
	}
	
	public ApplicationContext getContext() {
		return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}
	
	public HttpServletRequest getRequest(){
		return WebContextFactory.get().getHttpServletRequest();
	}
	
	public Object execute(AjaxCallback callback) {
		return callback.executeInAjax();
		
	}

}
