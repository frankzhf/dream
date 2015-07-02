package net.frank.cms.web.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.CoreService;
import net.frank.cms.web.core.forms.MoveForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class SubmitMoveAction extends BaseAction {

	private static final String FAILURE_MESSAGE_0 = "core.move.errors.from.path.invalid";

	private static final String FAILURE_MESSAGE_1 = "core.move.errors.to.path.invalid";

	private static final String FAILURE_MESSAGE_2 = "core.move.errors.subfolder";

	private static final String FAILURE_MESSAGE_3 = "core.move.errors.to.path.not.folder";

	private static final String SUCCESS_MESSAGE = "common.operate.success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MoveForm _form = (MoveForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		ActionMessages actionMessages = new ActionMessages();
		String strFromPath = _form.getFromPath();
		Resource fromResource = queryService.getResourceAsPath(strFromPath);
		String strToPath = _form.getToPath();
		Resource toResource = queryService.getResourceAsPath(strToPath);
		Boolean clone = _form.getClone();
		Boolean recursive = _form.getRecursive();

		Boolean validation = Boolean.TRUE;
		if (fromResource == null) {
			actionMessages.add(CmsCommonConstants.EMPTY_STRING,
					new ActionMessage(FAILURE_MESSAGE_0, strFromPath));
			validation = Boolean.FALSE;
		}
		if (toResource == null) {
			actionMessages.add(CmsCommonConstants.EMPTY_STRING,
					new ActionMessage(FAILURE_MESSAGE_1, strToPath));
			validation = Boolean.FALSE;
		}

		if (validation) {
			if (!CmsCommonConstants.TYPE.RESOURCE
					.equals(toResource.getTypeId())) {
				actionMessages.add(CmsCommonConstants.EMPTY_STRING,
						new ActionMessage(FAILURE_MESSAGE_3, strToPath));
				validation = Boolean.FALSE;
			}
			if (strToPath.indexOf(strFromPath) == 0) {
				actionMessages.add(CmsCommonConstants.EMPTY_STRING,
						new ActionMessage(FAILURE_MESSAGE_2, strFromPath,
								strToPath));
				validation = Boolean.FALSE;
			}
		}
		if (validation) {
			CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
			coreService.move(fromResource, toResource, clone, recursive, getClientSession());
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage(SUCCESS_MESSAGE));
			addMessages(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
		} else {
			addErrors(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}
	}
}
