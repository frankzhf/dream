package net.frank.framework.web.taglib.navigator.renderer;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import net.frank.framework.navigation.Menu;
import net.frank.framework.navigation.MenuRepository;


/**
 * @author Alex.Kwan
 * @version 1.0 Date 2002-8-9
 */
public class DefaultNavigationRenderer extends NavigationRenderer {
	public static final int MODE_UNSELECTED = 0;
	public static final int MODE_SELECTED = 1;
	public static final int MODE_ACTIVED = 2;

	private PageContext pageContext;
	private MenuRepository repository;

	public String renderMenu(PageContext context,MenuRepository rep) {
		
		repository  = rep;
		setPageContext(context);
		
		StringBuffer buf = new StringBuffer();


		buildHeader(buf);
		buildBody(buf);
		buildFooter(buf);

		return buf.toString();
	}

	public void destroy() {
		pageContext = null;
	}

	protected PageContext getPageContext() {
		return pageContext;
	}

	protected void setPageContext(PageContext context) {
		pageContext = context;
	}
		
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) getPageContext().getRequest();
	}

	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) getPageContext().getResponse();
	}
	
	protected ServletContext getContext() {
		return getPageContext().getServletContext();
	}	


	private void buildHeader(StringBuffer buf) {
		buf.append("<b:navpanel style=\"width: 160px;\">");
	}

	private void buildFooter(StringBuffer buf) {
		buf.append("</b:navpanel>");
	}

	private void buildBody(StringBuffer buf) {
		MenuRepository menuRepository = this.repository;
		List<Menu> topMenus = menuRepository.getTopMenus();
		for (Iterator<Menu> iter = topMenus.iterator(); iter.hasNext();) {
			Menu menu = iter.next();
			buf.append("<b:navpanelhead style=\"font-size: 12px;font-weight: bold;text-align: center;\">");
			buf.append(menu.getTitle());
			buf.append("</b:navpanelhead>");
			buf.append("<b:navpanelbody>");
			for (Iterator<Menu> iterator = menu.getChildren().iterator(); iterator.hasNext();) {
				Menu subMenu = iterator.next();
				buf.append("<p style=\"font-size: 12px;text-align: center;\">");
				buf.append("<a href=\""+subMenu.getPath()+"\" target=\"body\">");
				buf.append(subMenu.getTitle());
				buf.append("</a>");
				buf.append("</p>");
			}
			buf.append("</b:navpanelbody>");
		}
	}	
}

