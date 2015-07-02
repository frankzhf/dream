package net.frank.framework.web.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.frank.commons.CommonConstants;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.bo.Attach;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;

public class BlobContentServlet extends HttpServlet {
	protected transient Log log = LogFactory.getLog(getClass());
	protected static final String RESPONSE_HEADER_CONTENT_DISPOSITION_KEY = "Content-Disposition";
	protected static final String RESPONSE_HEADER_DEFALUT_CONTENT_TYPE = "application/octet-stream";
	private static final String DEFAULT_CONTENT_FIELD = "content";
	/**
	 * 
	 */
	private static final long serialVersionUID = 4840892797106391373L;

	//protected static final int BUFFER_SIZE = 4096;

	public void destory() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setBufferSize(CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH);
		QueryService queryService = (QueryService) SpringContextUtil
				.getBean(ServiceNames.QUERY_SERVICE);
		PermissionService permissionService = (PermissionService) SpringContextUtil
				.getBean(ServiceNames.PERMISSION_SERVICE);
		Long id = Long.decode(request.getParameter("resourceId"));
		String elementId = request.getParameter("elementId") == null ? DEFAULT_CONTENT_FIELD
				: request.getParameter("elementId");
		Resource resource = queryService.getResource(id);
		BusinessObject businessObject = queryService.getBo(id);
		byte[] content = null;
		try {
			content = (byte[]) PropertyUtils.getProperty(businessObject,
					elementId);
		} catch (IllegalAccessException e1) {
			log.error("BlobContentServlet.doGet() IllegalAccessException");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			log.error("BlobContentServlet.doGet() InvocationTargetException");
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			log.error("BlobContentServlet.doGet() NoSuchMethodException");
			e1.printStackTrace();
		}
		OutputStream os = null;
		InputStream is = null;
		try {
			int length = 0;
			processResponseHeader(response, businessObject);
			if (content != null) {
				os = response.getOutputStream();
				ClientSession cs = AuthenticatorHolder.getClientSession();
				if (!permissionService.checkReadPermission(resource, cs)) {
					response.setContentLength(length);
					os.flush();
				}
				is = new ByteArrayInputStream(content);
				byte[] buff = new byte[CommonConstants.DEFAULT_BYTE_BUFFER_LENGTH];
				int readLength = 0;
				while ((readLength = is.read(buff)) != -1) {
					os.write(buff, 0, readLength);
					length += readLength;
				}
				response.setContentLength(length);
				os.flush();
			}else{
				processNullContent(response);
			}
		} catch (IOException e) {
			log.error("Blob field read/write error(s).");
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
				if (os != null) {
					os.close();
					os = null;
				}
			} catch (IOException e) {
				log.error("Stream close error(s).");
				e.printStackTrace();
			}
		}
	}

	protected void processNullContent(HttpServletResponse response) {
		
	}

	protected void processResponseHeader(HttpServletResponse response,
			BusinessObject bo) {
		response.reset();
		processContentType(response, bo);
		String fileName = null;
		if (bo instanceof Attach) {
			fileName = ((Attach) bo).getFileName();
		} else {
			fileName = bo.getResource().getAlias();
		}
		response.addHeader(RESPONSE_HEADER_CONTENT_DISPOSITION_KEY,
				"attachment;filename=\"" + fileName + "\"");
	}

	protected void processContentType(HttpServletResponse response,
			BusinessObject bo) {
		response.setContentType(RESPONSE_HEADER_DEFALUT_CONTENT_TYPE);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
