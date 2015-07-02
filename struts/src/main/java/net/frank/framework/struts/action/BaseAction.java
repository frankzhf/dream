package net.frank.framework.struts.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.frank.framework.service.BaseService;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessages;
import org.springframework.context.ApplicationContext;

public class BaseAction extends Action {
	protected transient Log log = LogFactory.getLog(getClass());

	public boolean hasErrors(HttpServletRequest request) {
		ActionMessages msgs = getErrors(request);
		if (msgs == null || msgs.size() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public ActionForward parameterizeActionForward(String name, String module,
			String action, Map<String, Object> params) {
		if (params == null) {
			throw new NullPointerException("params can not be null.");
		}

		ActionForward ret = new ActionForward();

		ret.setModule(module);
		ret.setName(name);
		ret.setRedirect(true);

		StringBuffer pathBuf = new StringBuffer(action + ".do");
		pathBuf.append("?");

		for (Iterator<Map.Entry<String, Object>> iter = params.entrySet()
				.iterator(); iter.hasNext();) {
			Map.Entry<String, Object> param = iter.next();

			try {
				pathBuf.append(URLEncoder.encode((String) param.getKey(),
						"UTF-8"));
				pathBuf.append("=");
				pathBuf.append(URLEncoder.encode((String) param.getValue()
						.toString(), "UTF-8"));

				if (iter.hasNext()) {
					pathBuf.append("&");
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		ret.setPath(pathBuf.toString());

		return ret;
	}

	public ActionForward parameterizeActionForward(
			ActionForward originalForward, Map<String, Object> params) {
		if (originalForward == null) {
			throw new NullPointerException("originalForward can not be null.");
		}
		if (params == null) {
			throw new NullPointerException("params can not be null.");
		}

		ActionForward ret = new ActionForward();
		ret.setModule(originalForward.getModule());
		ret.setName(originalForward.getName());
		ret.setRedirect(originalForward.getRedirect());
		StringBuffer pathBuf = new StringBuffer(originalForward.getPath());
		pathBuf.append("?");
		for (Iterator<Map.Entry<String, Object>> iter = params.entrySet()
				.iterator(); iter.hasNext();) {
			Map.Entry<String, Object> param = iter.next();
			try {
				pathBuf.append(URLEncoder.encode((String) param.getKey(),
						"UTF-8"));
				pathBuf.append("=");
				pathBuf.append(URLEncoder.encode((String) param.getValue()
						.toString(), "UTF-8"));
				if (iter.hasNext()) {
					pathBuf.append("&");
				}
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		ret.setPath(pathBuf.toString());
		return ret;
	}

	public ApplicationContext getContext() {
		return SpringContextHolder.getApplicationContext();
	}

	public Object getBean(String beanId) {
		return getContext().getBean(beanId);
	}

	public BaseService getService(HttpServletRequest request, String serviceName) {
		return SpringContextUtil.getService(serviceName);
	}

	public ClientSession getClientSession() {
		return AuthenticatorHolder.getClientSession();
	}
}
