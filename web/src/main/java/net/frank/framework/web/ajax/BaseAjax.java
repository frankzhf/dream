package net.frank.framework.web.ajax;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.service.BaseService;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

public class BaseAjax {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	private AjaxTemplate template;
	
	public AjaxTemplate getAjaxTemplate(){
		if (template==null){
			template = new AjaxTemplate();
		}
		return template;
	}
	
	public ServletContext getServletContext(){
		return WebContextFactory.get().getServletContext();
	}
	
	public ApplicationContext getContext() {
		return WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	}
	
	public Object getBean(String beanId){
		return SpringContextUtil.getBean(beanId);
	}
	
	public ClientSession getClientSession(){
		return AuthenticatorHolder.getClientSession();
	}
	
	public BaseService getService(HttpServletRequest request,String serviceName) {
		return  SpringContextUtil.getService(serviceName);
	}
	
}
