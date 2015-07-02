package net.frank.framework.web.tiny;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.commons.CommonConstants;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;

public class RetrieveLinkServlet extends HttpServlet {
	private static final long serialVersionUID = -7360047000517191210L;
	private static final String RESPONSE_HEADER_DEFALUT_CONTENT_TYPE = "text/javascript";
	private static final String PROCESS_DOCUMENT_URL = "/document?elementId=clobString(docBody)&resourceId=";

	public void destory() {
		super.destroy();
	}

	public void init() throws ServletException {
		super.init();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(RESPONSE_HEADER_DEFALUT_CONTENT_TYPE);
		response.setCharacterEncoding(CommonConstants.HTML_HEAD.RESPONSE_OUTPUT_UNCODE);
		response.setHeader(CommonConstants.HTML_HEAD.PRAGMA,
				CommonConstants.HTML_HEAD.NOCACHE);
		response.setHeader(CommonConstants.HTML_HEAD.EXPIRES,
				CommonConstants.HTML_HEAD.ZERO);
		PrintWriter pw = response.getWriter();

		QueryService queryService = (QueryService) SpringContextUtil
				.getBean(ServiceNames.QUERY_SERVICE);
		PermissionService permissionService = (PermissionService) SpringContextUtil
				.getBean(ServiceNames.PERMISSION_SERVICE);
		List<Resource> linkList = queryService
				.retrieveResourceByType(CommonConstants.TYPE.ARTICLE);
		List<Resource> filterList = permissionService.filterList(linkList,
				AuthenticatorHolder.getClientSession());
		List<Item> itemList = new ArrayList<Item>();
		for (Iterator<Resource> it = filterList.iterator(); it.hasNext();) {
			Resource currResource = it.next();
			if (permissionService.checkReadPermission(currResource,
					AuthenticatorHolder.getClientSession())) {
				Item item = new Item();
				item.setPath(queryService.getResourcePath(currResource));
				item.setMapping("http://" + request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ PROCESS_DOCUMENT_URL + currResource.getId());
				itemList.add(item);
			}
		}

		Collections.sort(itemList, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.getPath().compareTo(o2.getPath());
			}
		});

		pw.write("var tinyMCELinkList = new Array(");
		for (int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);
			if (i != 0) {
				pw.write(",");
			}
			pw.write("[\"" + item.getPath() + "\", \"" + item.getMapping()
					+ "\"]");
		}
		pw.write(");");
		pw.flush();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
