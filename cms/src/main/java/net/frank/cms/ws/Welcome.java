package net.frank.cms.ws;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import net.frank.aa.service.AaService;
import net.frank.cms.common.BaseJersey;
import net.frank.commons.util.StringUtil;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.AccountService;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.ws.define.WsAaInfo;
import net.frank.framework.ws.define.WsRegister;
import net.frank.framework.ws.process.BoXmlUtil;

@Path("/welcome")
public class Welcome extends BaseJersey {

	private BoXmlUtil boXmlUtil;
	
	public Welcome() {
		this.boXmlUtil = (BoXmlUtil) getBean("boXmlUtil");
	}

	@POST
	@Path("/login")
	@Produces("text/xml")
	public String login(InputStream inputInfo,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception {
		AaService aaService = (AaService) getBean("aaService");
		String strUserInfo = inputStream2String(inputInfo);
		WsAaInfo wsAaInfo = boXmlUtil.xml2Aa(strUserInfo);
		log.debug("loginName:" + wsAaInfo.getLoginName());
		log.debug("password:" + (StringUtil.isNotEmpty(wsAaInfo.getPassword()) ? "*************************" : "******Empty Password*****"));
		Session cs = new ClientSession(wsAaInfo.getLoginName(),
				request.getRemoteAddr());
		if(StringUtil.isNotEmpty(wsAaInfo.getPlatform()) ){
			((ClientSession)cs).setPlatform(wsAaInfo.getPlatform());
		}
		if(StringUtil.isNotEmpty(wsAaInfo.getApplication()) ){
			((ClientSession)cs).setApplication(wsAaInfo.getApplication());
		}
		cs = aaService.login(cs, wsAaInfo.getLoginName(),
				wsAaInfo.getPassword(), null);
		request.getSession().setAttribute("CLIENT_SESSION", cs);
		if (Session.STATUS_LOGINED.equals(cs.getStatus())) {
			wsAaInfo.setPassword("****************************");
			wsAaInfo.setLoginStatus(WsAaInfo.LOGINED);
			return boXmlUtil.aa2Xml(wsAaInfo);
		} else {
			return boXmlUtil.aa2Xml(wsAaInfo);
		}
	}
	
	
	
	@POST
	@Path("/logout")
	@Produces("text/xml")
	public String logout(InputStream inputInfo,
			@Context HttpServletRequest request) throws Exception {
		String strUserInfo = inputStream2String(inputInfo);
		WsAaInfo wsAaInfo = boXmlUtil.xml2Aa(strUserInfo);
		ClientSession cs = getClientSession();
		if(cs!=null){
			AaService aaService = (AaService) getBean("aaService");
			aaService.logout(getClientSession());
		}
		wsAaInfo.setLoginStatus(WsAaInfo.NO_LOGINED);
		request.getSession(false).removeAttribute("CLIENT_SESSION");
		return boXmlUtil.aa2Xml(wsAaInfo);
	}
	
	
	@POST
	@Path("/register")
	@Produces("text/xml")
	public String register(InputStream inputInfo,
			@Context HttpServletRequest request) throws Exception {
		String registerInfo = inputStream2String(inputInfo);
		WsRegister wsRegister = boXmlUtil.xml2WsRegister(registerInfo);
		String loginId = wsRegister.getLoginId();
		String password = wsRegister.getPassword();
		AccountService accountService = (AccountService) getBean("accountService");
		if(accountService.existAccount(loginId)){
			wsRegister.setStatus(WsRegister.EXIST);
		}else{
			Session root = RootSessionHolder.getDefaultRootSession();
			accountService.addAccount(loginId, password, root);
			wsRegister.setStatus(WsRegister.REGISATION);
		}
		return boXmlUtil.wsRegister2Xml(wsRegister);
	}
}
