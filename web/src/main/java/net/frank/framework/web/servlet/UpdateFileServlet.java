package net.frank.framework.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UpdateFileServlet extends HttpServlet {

	private transient Log log = LogFactory.getLog(getClass());

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
		ClientSession cs = AuthenticatorHolder.getClientSession();
		Long homeResId = cs.getAccount().getHome$3().getId();
		Resource homeRes = queryService.getResource(homeResId);
		String fullPath = queryService.getNodePath(homeRes);
		log.info("Current Account 's home is:" + fullPath);
		int contentLength = request.getContentLength();
		if (contentLength > 0) {
			InputStream in = request.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] value = new byte[4096];
			int flag = -1;
			while ((flag = in.read(value)) != -1) {
				bos.write(value, 0, flag);
			}
			byte[] full = bos.toByteArray();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
