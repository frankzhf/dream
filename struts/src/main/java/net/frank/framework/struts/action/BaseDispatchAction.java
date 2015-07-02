package net.frank.framework.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

/**
 * @author david
 * 
 */
public abstract class BaseDispatchAction extends BaseAction {
	/**
	 * The Class instance of this <code>DispatchAction</code> class.
	 */
	protected Class<?> clazz = this.getClass();

	/**
	 * Commons Logging instance.
	 */
	protected static Log log = LogFactory.getLog(BaseDispatchAction.class);

	/**
	 * The message resources for this package.
	 */
	protected static MessageResources messages = MessageResources
			.getMessageResources("org.apache.struts.actions.LocalStrings");

	/**
	 * The set of Method objects we have introspected for this class, keyed by
	 * method name. This collection is populated as different methods are
	 * called, so that introspection needs to occur only once per method name.
	 */
	protected HashMap<String,Method> methods = new HashMap<String,Method>();

	/**
	 * The set of argument type classes for the reflected method call. These are
	 * the same for all calls, so calculate them only once.
	 */
	protected Class<?>[] types = { ActionMapping.class, ActionForm.class,
			HttpServletRequest.class, HttpServletResponse.class };

	public boolean hasErrors(HttpServletRequest request) {
		ActionMessages msgs = getErrors(request);

		if (msgs == null || msgs.size() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		

		// Identify the string to lookup
		String methodName = getMethodName(mapping, form, request, response,
				"function");
		
		//Identify the request parameter containing the method name
		if (methodName==null){
			methodName = mapping.getParameter();
		}
		
		//Assert.notNull(methodName);

		return dispatchMethod(mapping, form, request, response, methodName);
	}

	protected String getMethodName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			String parameter) throws Exception {
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

	protected ActionForward dispatchMethod(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response, String name) throws Exception {

		// Make sure we have a valid method name to call.
		// This may be null if the user hacks the query string.
		if (name == null) {
			return this.unspecified(mapping, form, request, response);
		}

		// Identify the method object to be dispatched to
		Method method = null;
		try {
			method = getMethod(name);

		} catch (NoSuchMethodException e) {
			String message = messages.getMessage("dispatch.method", mapping
					.getPath(), name);
			log.error(message, e);
			throw e;
		}

		ActionForward forward = null;
		try {
			Object args[] = { mapping, form, request, response };
			forward = (ActionForward) method.invoke(this, args);

		} catch (ClassCastException e) {
			String message = messages.getMessage("dispatch.return", mapping
					.getPath(), name);
			log.error(message, e);
			throw e;

		} catch (IllegalAccessException e) {
			String message = messages.getMessage("dispatch.error", mapping
					.getPath(), name);
			log.error(message, e);
			throw e;

		} catch (InvocationTargetException e) {
			// Rethrow the target exception if possible so that the
			// exception handling machinery can deal with it
			Throwable t = e.getTargetException();
			if (t instanceof Exception) {
				throw ((Exception) t);
			} else {
				String message = messages.getMessage("dispatch.error", mapping
						.getPath(), name);
				log.error(message, e);
				throw new ServletException(t);
			}
		}

		// Return the returned ActionForward instance
		return (forward);
	}

	public ActionForward cancel(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("cancel");
	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm arg1,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;
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
	
}