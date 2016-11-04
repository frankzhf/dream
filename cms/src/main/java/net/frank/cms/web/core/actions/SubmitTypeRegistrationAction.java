package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.TypeRegistrationService;
import net.frank.cms.web.core.forms.TypeRegistrationForm;
import net.frank.framework.bo.Application;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class SubmitTypeRegistrationAction extends BaseAction {
	
	private static final String SUCCESS_MESSAGE = "common.operate.success";
	
	private static final String SERVICE_BEAN_ID ="typeRegistrationService";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages actionMessages = new ActionMessages();
		TypeRegistrationService typeRegistrationService = (TypeRegistrationService)getBean(SERVICE_BEAN_ID);
		TypeRegistrationForm _form = (TypeRegistrationForm)form;
		Application application = null;
		if(_form.getAppResourceId()!=null){
			QueryService queryService = (QueryService)getBean(ServiceNames.QUERY_SERVICE);
			application = (Application)queryService.getBo(_form.getAppResourceId());
		}
		typeRegistrationService.registrationType(_form.getEntityClassName(), _form.getDescription(),
				_form.getTypeKey(), application, getClientSession());
		actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
				new ActionMessage(SUCCESS_MESSAGE));
		addMessages(request, actionMessages);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
