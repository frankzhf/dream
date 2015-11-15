package net.frank.framework.web.taglib.navigator.renderer;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.jsp.PageContext;

import net.frank.framework.navigation.MenuRepository;


public abstract class NavigationRenderer implements HttpSessionBindingListener{
	public void valueBound(HttpSessionBindingEvent event) {
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		destroy();
	}
	
	public abstract String renderMenu(PageContext context,MenuRepository rep);
	public abstract void destroy();
}
