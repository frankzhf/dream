package net.frank.framework.web.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpSessionEventPublisher implements HttpSessionListener {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	private static int SESSION_CNT = 0;
	
	public static int getSessionCount(){
		return SESSION_CNT;
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		log.debug(event.getSession().getId() + " Created time is " + new Date());
		SESSION_CNT ++;
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		log.debug(event.getSession().getId() + " Destoryed time is " + new Date() );
		SESSION_CNT --;
	}

}
