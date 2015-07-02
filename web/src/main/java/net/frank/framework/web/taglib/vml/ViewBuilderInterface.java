package net.frank.framework.web.taglib.vml;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public interface ViewBuilderInterface {
	public StringBuffer builder(HttpServletRequest request,ServletContext context,
			String parament, String shape, String type,
			long left, long top, long width, long height);
}
