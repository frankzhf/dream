package net.frank.framework.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.web.WebConstants;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.ws.define.WsResponse;
import net.frank.framework.ws.process.BoXmlUtil;

public class SecurityFilter implements Filter {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	public static final String ORIGINAL_SERVLET_PATH = "ORIGINAL_SERVLET_PATH";
	private static final String WS_REQUEST_URL = "/jaxrs";
	
	private static final String WS_COMMON_UTIL_BEAN_ID = "boXmlUtil";

	private String unfilteredURIs;

	private String loginURL;

	private BoXmlUtil boXmlUtil;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.debug("SecurityFilter.doFilter BEG");
		try{
			HttpServletRequest hrequest = (HttpServletRequest) request;
			HttpServletResponse hresponse = (HttpServletResponse) response;
	
			String path = (String) hrequest.getAttribute(ORIGINAL_SERVLET_PATH);
			if (path == null) {
				request.setAttribute(ORIGINAL_SERVLET_PATH,
						hrequest.getServletPath());
			}
			String context = hrequest.getContextPath();
			String requestURI = hrequest.getRequestURI().substring(context.length());
			log.debug("requestURI:" + requestURI);
	
			if (requestURI.matches(unfilteredURIs)) {
				log.debug("SecurityFilter.doFilter unfilteredURIs");
				chain.doFilter(request, response);
				return;
			}
			ClientSession cs = (ClientSession) hrequest.getSession(true)
					.getAttribute(WebConstants.CLIENT_SESSION_KEY);
			if (cs != null && ClientSession.STATUS_LOGINED.equals(cs.getStatus())) {
				log.debug("SecurityFilter.doFilter isLogined.");
				cs.setPrevRequestTime(new Date());
				AuthenticatorHolder.setClientSession(cs);
				chain.doFilter(request, response);
				return;
			}
			if (requestURI.indexOf(WS_REQUEST_URL) > -1) {
				WsResponse wsResponse = new WsResponse();
				wsResponse.setMessageNumber(WsResponse.MESSAGE_SESSION_EXPIRED);
				if (boXmlUtil == null) {
					boXmlUtil = (BoXmlUtil) SpringContextHolder
							.getApplicationContext().getBean(WS_COMMON_UTIL_BEAN_ID);
				}
				hresponse.getOutputStream().print(
						boXmlUtil.wsResponse2Xml(wsResponse));
			} else {
				hresponse.sendRedirect(hrequest.getContextPath() + loginURL);
			}
		}finally{
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig config) throws ServletException {
		loginURL = config.getInitParameter("loginURL").trim();
		unfilteredURIs = jointString(config.getInitParameter("unfilteredURIs"));
	}

	protected String jointString(String str) {
		StringBuffer buf = new StringBuffer();
		for (StringTokenizer st = new StringTokenizer(str != null ? str : "",
				"\n", false); st.hasMoreTokens(); buf.append(st.nextToken()
				.trim()))
			;
		return buf.toString();
	}

}