package net.frank.framework.web.security;

import org.springframework.context.ApplicationContext;

import net.frank.commons.CommonConstants;
import net.frank.framework.security.Authorization;
import net.frank.framework.security.Session;
import net.frank.framework.service.QueryService;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Resource;

public class SudoSessionUtil {
	
	private static final String DEFAULT_LOGIN_NAME = "root";
	private static final String DEFAULT_IP_ADRESS = "127.0.0.1";
	
	static ClientSession _self;
	
	public static ClientSession getRootClientSession(){
		if(_self == null){
			_self = new ClientSession(DEFAULT_LOGIN_NAME,DEFAULT_IP_ADRESS);
			ApplicationContext content = SpringContextHolder.getApplicationContext();
			QueryService queryService = (QueryService)content.getBean("queryService");
			Resource rootAccountRes = queryService.getResourceAsPath(CommonConstants.PATH.ROOT_ACCOUNT);
			Account rootAccount = (Account)queryService.getBo(rootAccountRes);
			Account cloneAccount = rootAccount.clone();
			_self.setAccount(cloneAccount);
			_self.setStatus(Session.STATUS_LOGINED);
			if(content.getBean("groupAuthorization")!=null){
				Authorization groupAuth = (Authorization)content.getBean("groupAuthorization");
				groupAuth.exec(_self);
			}
			if(content.getBean("privilegeAuthorization")!=null){
				Authorization privilegeAuth = (Authorization)content.getBean("privilegeAuthorization");
				privilegeAuth.exec(_self);
			}
		}
		return _self;
	}
}
