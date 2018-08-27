package net.frank.framework.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.commons.CommonConstants;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;

public class ClobContentServlet extends HttpServlet {
	private transient Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 8457203013140361324L;
	private static final String RESPONSE_HEADER_DEFALUT_CONTENT_TYPE = "text/html";
	private static final String DEFAULT_CONTENT_FIELD = "content";
	private static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";
	public void destory() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QueryService queryService = (QueryService) SpringContextUtil
				.getBean(ServiceNames.QUERY_SERVICE);
		PermissionService permissionService = (PermissionService) SpringContextUtil
				.getBean(ServiceNames.PERMISSION_SERVICE);
		Long id = Long.decode(request.getParameter("resourceId"));
		String elementId = request.getParameter("elementId") == null ? DEFAULT_CONTENT_FIELD
				: request.getParameter("elementId").substring(
						request.getParameter("elementId").indexOf(
								".clobString(") + 12,
						request.getParameter("elementId").length()-1);

		Resource resource = queryService.getResource(id);
		BusinessObject businessObject = queryService.getBo(id);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		if (!permissionService.checkReadPermission(resource, cs)) {
			log.debug("ClobContentServlet.doGet checkReadPermission failure.");
			return;
		}
		
		processResponseHeader(response, businessObject);
		PrintWriter pw = response.getWriter();
		pw.write(businessObject.getClobString(elementId));
		pw.flush();
	}
	
	private void processResponseHeader(HttpServletResponse response,
			BusinessObject bo) {
		//response.reset();
		processContentType(response, bo);
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.addHeader(CommonConstants.HTML_HEAD.PRAGMA, CommonConstants.HTML_HEAD.NOCACHE);
		response.addHeader(CommonConstants.HTML_HEAD.EXPIRES, CommonConstants.HTML_HEAD.ZERO);
	}

	private void processContentType(HttpServletResponse response,
			BusinessObject bo) {
		response.setContentType(RESPONSE_HEADER_DEFALUT_CONTENT_TYPE);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}