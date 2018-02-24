package net.frank.yangtes.modules.zkc.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.frank.yangtes.modules.zkc.client.ZookeeperClient;
import net.frank.yangtes.modules.zkc.config.ZookeeperConfig;
import net.frank.yangtes.modules.zkc.util.ZookeeperUtil;

public class ZookeeperContextLoaderListener extends ContextLoaderListener {
	
	private transient Logger log = LoggerFactory.getLogger(ZookeeperContextLoaderListener.class);
	
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
		ZookeeperConfig config =context.getBean(ZookeeperConfig.class);
		try {
			ZookeeperClient client = new ZookeeperClient(config.getHost(),config.getTimeout());
			ZookeeperUtil.setZkClient(client);
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
	}
}
