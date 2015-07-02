package net.frank.aa.service.impl.a11r;

import net.frank.framework.security.Authenticator;
import net.frank.commons.util.PasswordUtil;
import net.frank.framework.bo.Account;
import net.frank.framework.dao.AccountDao;
import net.frank.framework.security.Session;

public class DefaultAuthenticator implements Authenticator {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void authenticate(String loginName, String password,
			Session session) {
		Account checkAccount = accountDao.retrieveAccountByUid(loginName);
		if(checkAccount != null && Account.TYPE_DEFAULT.equals(checkAccount.getType())){
			String encode = checkAccount.getPassword();
			String _encode = PasswordUtil.MD5encode(password);
			if(_encode.equals(encode)){
				session.setStatus(Session.STATUS_LOGINED);
				Account cloneAccount = checkAccount.clone();
				session.setAccount(cloneAccount);
			}else{
				session.setStatus(Session.STATUS_INCORRERT_PW);
			}
		}else{
			session.setStatus(Session.STATUS_NOT_EXISTS);
		}
	}

}
