package net.frank.springweb.home;

import javax.servlet.http.HttpServletRequest;

import net.frank.aa.service.AaService;
import net.frank.framework.security.Session;
import net.frank.framework.web.WebConstants;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.spring.controller.ControllerBaseSupport;
import net.frank.springweb.home.form.LoginForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class IndexController extends ControllerBaseSupport {
	private static final String AA_SERVICE_BEAN_ID = "aaService";

	private static final String VIEW_LOGIN = "login";
	private static final String VIEW_VALIDATION = "commons/validation";
	private static final String VIEW_PING = "commons/ping";
	private static final String VIEW_WELCOME = "commons/welcome";
	private static final String VIEW_INIT = "commons/init";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm", loginForm);
		return VIEW_LOGIN;
	}

	@RequestMapping(value = "/validation", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String validation() {
		return VIEW_VALIDATION;
	}

	@RequestMapping(value = "/ping", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String ping() {
		return VIEW_PING;
	}

	@RequestMapping(value = "/init", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String init() {
		return VIEW_INIT;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult) {
		ServletRequestAttributes sras = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = sras.getRequest();
		AaService aaService = (AaService) getBean(AA_SERVICE_BEAN_ID);
		String username = loginForm.getLoginname();
		String password = loginForm.getPassword();
		Session cs = new ClientSession(username, request.getLocalAddr());
		((ClientSession)cs).setScreenWith(loginForm.getScreenWith());
		((ClientSession)cs).setScreenHeight(loginForm.getScreenHeight());
		cs = aaService.login(cs, username, password, null);
		request.getSession().setAttribute(WebConstants.CLIENT_SESSION_KEY, cs);
		if (Session.STATUS_LOGINED.equals(cs.getStatus())) {
			AuthenticatorHolder.setClientSession((ClientSession) cs);
			return VIEW_WELCOME;
		} else {
			if (Session.STATUS_NOT_EXISTS.equals(cs.getStatus())) {
				bindingResult.rejectValue("loginname",
						"msg.login.account.not.exists");
			} else if (Session.STATUS_INCORRERT_PW.equals(cs.getStatus())) {
				bindingResult.rejectValue("password", "msg.login.pwd.invalid");
			}
			return VIEW_LOGIN;
		}

	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.GET)
	public String doLogin2(Model model) {
		return login(model);
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String logout() {
		ServletRequestAttributes sras = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = sras.getRequest();
		request.getSession().invalidate();
		return "redirect:/login";
	}

}