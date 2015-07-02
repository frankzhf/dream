package net.frank.framework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author david
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveRequestFilter implements Filter{
	
	public static final String ORIGINAL_SERVLET_PATH = "ORIGINAL_SERVLET_PATH";
	public static String SAVED_URI = "net.frank.save.uri";	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		if (request.getAttribute(SAVED_URI)==null){
			request.setAttribute(SAVED_URI,((HttpServletRequest)request).getRequestURI());
		}
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String path = (String) hrequest.getAttribute(ORIGINAL_SERVLET_PATH);
		if (path == null) {
			request.setAttribute(
				ORIGINAL_SERVLET_PATH, hrequest.getServletPath());
		}
		chain.doFilter(request,response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		
	}

}
