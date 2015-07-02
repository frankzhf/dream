package net.frank.framework.web.taglib.tree;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.commons.util.StringUtil;

public class TreeServlet extends HttpServlet {

	private static final long serialVersionUID = -300406262467612771L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String builder = request.getParameter("builder");
		if (StringUtil.isEmpty(builder)){
			return;
		}
		String callback = request.getParameter("callback");
		if (StringUtil.isEmpty(callback)){
			return;
		}
		
		TreeBuilder tb;
		try {
			tb = (TreeBuilder)Class.forName(builder).newInstance();
			tb.setCallback(callback);
			TreeNode root = tb.buildTree(request,getServletContext());
			request.setAttribute("tree", root);
			response.setCharacterEncoding("GBK");
			response.setContentType("text/xml");
			response.setHeader("Pragma","no-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setHeader("Expires","0");
			String content = tb.printXML(root);
			response.getOutputStream().write(content.getBytes());
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
