package net.frank.framework.bsui.grid.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.framework.bsui.grid.DataGenerator;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

public class GeneratorDataServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1655934662507699776L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String path = request.getParameter("path");
		if(path.indexOf("/")!=0){
			path = "/"+path;
		}
		DataGenerator dataGenerator = (DataGenerator) SpringContextUtil
				.getBean("dataGenerator");
		ClientSession cs = AuthenticatorHolder.getClientSession();
		PrintWriter pw = response.getWriter();
		String json = dataGenerator.generate(path,cs);
		pw.write(json);
		pw.flush();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
