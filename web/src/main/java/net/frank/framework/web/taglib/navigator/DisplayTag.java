package net.frank.framework.web.taglib.navigator;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import net.frank.framework.navigation.MenuRepository;
import net.frank.framework.web.taglib.navigator.renderer.DefaultNavigationRenderer;
import net.frank.framework.web.taglib.navigator.renderer.NavigationRenderer;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DisplayTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2943166228948995729L;
	public static final String DEFAULT_RENDERER_CLASS =
			"net.frank.framework.web.taglib.navigator.renderer.DefaultNavigationRenderer";
	public static final String RENDERER_KEY = "RENDERER";
	
	private String rendererClass = DEFAULT_RENDERER_CLASS;
	private String configfile;
		
	public int doEndTag() {
		
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		Resource resource  = appContext.getResource(configfile);
		
		MenuRepository rep = MenuRepository.loadConfig( ((HttpServletRequest)pageContext.getRequest()).getContextPath() ,resource);
		
		JspWriter out = pageContext.getOut();
		NavigationRenderer renderer = getNavigationRenderer();

		try {
			out.write(renderer.renderMenu(pageContext,rep));
		} catch(IOException ioe) {
		}

		return EVAL_PAGE;
	}

	/**
	 * Returns the rendererClass.
	 * @return String
	 */
	public String getRendererClass() {
		return rendererClass;
	}

	/**
	 * Sets the rendererClass.
	 * @param rendererClass The rendererClass to set
	 */
	public void setRendererClass(String rendererClass) {
		this.rendererClass = rendererClass;
	}
	
	private NavigationRenderer getNavigationRenderer() {
		HttpSession session = (HttpSession) pageContext.getSession();
		NavigationRenderer renderer = 
			(NavigationRenderer) session.getAttribute(RENDERER_KEY);
			
		if (renderer == null) {
			try {
				//Class<?> clazz = Class.forName(getRendererClass());
				renderer = (NavigationRenderer) 
					Class.forName(getRendererClass()).newInstance();
			} catch (Exception e) {
				renderer = new DefaultNavigationRenderer();
			}
			
			session.setAttribute(RENDERER_KEY, renderer);
		}
		
		return renderer;
	}


	public String getConfigfile() {
		return configfile;
	}
	
	public void setConfigfile(String configfile) {
		this.configfile = configfile;
	}	
}
