package net.frank.aa.service.impl.a11r;

import org.springframework.ldap.AuthenticationException;
import org.springframework.ldap.core.LdapTemplate;

import net.frank.framework.security.Authenticator;
import net.frank.framework.security.RootSessionHolder;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.security.Session;
import net.frank.framework.service.AccountService;

public class LdapAuthenticator implements Authenticator {

	private LdapTemplate ldapTemplate;

	private AccountDao accountDao;

	private AccountService accountService;

	private static final String LEFT_LOGIN_NAME = "(mailNickname=";

	private static final String RIGHT_LOGIN_NAME = ")";

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public void authenticate(String loginName, String password, Session session) {
		try {
			StringBuffer sb = new StringBuffer(LEFT_LOGIN_NAME);
			sb.append(loginName).append(RIGHT_LOGIN_NAME);
			Boolean bool = ldapTemplate.authenticate(
					CommonConstants.EMPTY_STRING, sb.toString(), password);
			if (bool) {
				session.setStatus(Session.STATUS_LOGINED);
				Account checkAccount = accountDao
						.retrieveAccountByUid(loginName);
				if (checkAccount != null) {
					if (!Account.TYPE_LDAP.equals(checkAccount.getType())) {
						checkAccount.setType(Account.TYPE_LDAP);
						accountDao.saveObject(checkAccount);
					}
				} else {
					Session rootSession = RootSessionHolder.getDefaultRootSession();
					checkAccount = accountService.createLdapAccount(loginName,
							password,rootSession);
				}
				Account cloneAccount = checkAccount.clone();
				session.setAccount(cloneAccount);
			} else {
				session.setStatus(Session.STATUS_INCORRERT_PW);
			}
		} catch (AuthenticationException ae) {
			session.setStatus(Session.STATUS_INCORRERT_PW);
		}
	}
}
