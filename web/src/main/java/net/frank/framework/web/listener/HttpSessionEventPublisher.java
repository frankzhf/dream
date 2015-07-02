package net.frank.framework.web.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpSessionEventPublisher implements HttpSessionListener {
	
	private transient Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		log.debug(event.getSession().getId() + " Created time is " + new Date() );
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		log.debug(event.getSession().getId() + " Destoryed time is " + new Date() );
	}

}
