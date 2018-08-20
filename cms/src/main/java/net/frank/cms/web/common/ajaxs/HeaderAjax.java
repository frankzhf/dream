package net.frank.cms.web.common.ajaxs;

import net.frank.commons.CommonConstants;
import net.frank.commons.util.DesEncryptUtil;
import net.frank.framework.bo.Group;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;

public class HeaderAjax extends BaseAjax {
	public boolean changeClientGroup(Long resourceId) {
		boolean flag = false;
		try {
			ClientSession cs = AuthenticatorHolder.getClientSession();
			QueryService queryService = (QueryService)getBean(ServiceNames.QUERY_SERVICE);
			cs.setCurrentGroup((Group)queryService.getBo(resourceId));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean checkPassword(String oldPassword) {
		if(oldPassword == null || CommonConstants.EMPTY_STRING.equals(oldPassword)){
			return true;
		}
		String _oldPassword = DesEncryptUtil.encodeDES(oldPassword);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		return _oldPassword.equals(cs.getAccount().getPassword());
	}
}
