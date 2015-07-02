package net.frank.framework.web.spring.controller;

import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public abstract class ControllerBaseSupport {

	protected transient Logger logger = LoggerFactory.getLogger(getClass());

	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public Object getBean(String beanId) {
		return SpringContextUtil.getBean(beanId);
	}
	
	public ClientSession getClientSession(){
		return AuthenticatorHolder.getClientSession();
	}

}
