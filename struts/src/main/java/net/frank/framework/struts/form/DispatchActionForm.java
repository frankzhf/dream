package net.frank.framework.struts.form;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.service.BaseService;

public class DispatchActionForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	protected HashMap<String,Method> methods = new HashMap<String,Method>();

	protected Class<?> clazz = this.getClass();

	protected Class<?>[] types = { ActionMapping.class, HttpServletRequest.class };

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		try {
			// Identify the string to lookup
			String methodName = getMethodName(mapping, request, "function");
			// Identify the request parameter containing the method name
			if (methodName == null) {
				methodName = mapping.getParameter();
			}
			return dispatchMethod(mapping, request, "validate"+StringUtils.capitalize(methodName));
		} catch (Exception ex) {

		}
		return null;
	}

	protected String getMethodName(ActionMapping mapping,
			HttpServletRequest request, String parameter) throws Exception {
		Enumeration<?> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String p = (String) e.nextElement();
			if (p.startsWith(parameter)) {
				int index = p.indexOf('.') + 1;
				return p.substring(index);
			}
		}
		return null;
	}

	protected ActionErrors dispatchMethod(ActionMapping mapping,
			HttpServletRequest request, String name) throws Exception {

		// Make sure we have a valid method name to call.
		// This may be null if the user hacks the query string.
		if (name == null) {
			return null;
		}
		// Identify the method object to be dispatched to
		Method method = null;
		try {
			method = getMethod(name);

		} catch (NoSuchMethodException e) {
			throw e;
		}

		ActionErrors errors = null;
		try {
			Object args[] = { mapping, request };
			errors = (ActionErrors) method.invoke(this, args);
		} catch (ClassCastException e) {
			throw e;
		} catch (IllegalAccessException e) {
			throw e;

		} catch (InvocationTargetException e) {
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				throw ((Exception) t);
			} else {
				throw new ServletException(t);
			}
		}

		return (errors);
	}

	protected Method getMethod(String name) throws NoSuchMethodException {

		synchronized (methods) {
			Method method = (Method) methods.get(name);
			if (method == null) {
				method = clazz.getMethod(name, types);
				methods.put(name, method);
			}
			return (method);
		}

	}
	
	
	public ApplicationContext getContext() {
		return WebApplicationContextUtils.getWebApplicationContext(getServlet()
				.getServletContext());
	}

	public BaseService getService(HttpServletRequest request,String serviceName) {
		return SpringContextUtil.getService(serviceName);
	}

}
