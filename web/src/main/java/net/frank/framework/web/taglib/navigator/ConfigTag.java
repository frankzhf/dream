package net.frank.framework.web.taglib.navigator;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.frank.framework.navigation.Menu;
import net.frank.framework.navigation.MenuRepository;

/**
 * @author Alex.Kwan
 * @version 1.0 Date 2002-8-9
 */
public class ConfigTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4765901051539259723L;
	private String configfile;

	public int doEndTag() {
		ApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		Resource resource  = appContext.getResource(configfile);

		MenuRepository menuRepository = MenuRepository.loadConfig(
				((HttpServletRequest) pageContext.getRequest())
						.getContextPath(), resource);

		List<Menu> topMenus = menuRepository.getTopMenus();
		
		pageContext.setAttribute("menu",topMenus);
		return EVAL_PAGE;
	}

	/**
	 * @return Returns the configfile.
	 */
	public String getConfigfile() {
		return configfile;
	}

	/**
	 * @param configfile
	 *            The configfile to set.
	 */
	public void setConfigfile(String configfile) {
		this.configfile = configfile;
	}
}
