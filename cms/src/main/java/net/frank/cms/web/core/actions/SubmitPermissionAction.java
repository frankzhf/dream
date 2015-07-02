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
import net.frank.cms.web.core.forms.PermissionForm;
import net.frank.commons.util.PermissionUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

public class SubmitPermissionAction extends BaseAction {

	private static final String FAILURE_MESSAGE = "core.permission.errors.resource.path.invalid";

	private static final String SUCCESS_MESSAGE = "common.operate.success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PermissionForm _form = (PermissionForm) form;
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		CoreService coreService = (CoreService) getBean(ServiceNames.CORE_SERVICE);
		String contentFullPath = _form.getResourceFullPath();
		Resource resource = queryService.getResourceAsPath(contentFullPath);
		ActionMessages actionMessages = new ActionMessages();
		if (resource != null) {
			Boolean[] ownOption = new Boolean[3];
			ownOption[0] = _form.getPermission("0");
			ownOption[1] = _form.getPermission("1");
			ownOption[2] = _form.getPermission("2");
			Boolean[] groupOption = new Boolean[3];
			groupOption[0] = _form.getPermission("3");
			groupOption[1] = _form.getPermission("4");
			groupOption[2] = _form.getPermission("5");
			Boolean[] otherOption = new Boolean[3];
			otherOption[0] = _form.getPermission("6");
			otherOption[1] = _form.getPermission("7");
			otherOption[2] = _form.getPermission("8");
			Boolean chagePermissionFlag = _form.getChagePermissionFlag();
			Byte ownPermission = PermissionUtil.booleanToInteger(
					ownOption).byteValue();
			Byte groupPermission = PermissionUtil.booleanToInteger(
					groupOption).byteValue();
			Byte otherPermission = PermissionUtil.booleanToInteger(
					otherOption).byteValue();
			final Boolean chageOwnFlag = _form.getChageOwnFlag();
			final Long ownId = _form.getOwnResourceId();
			final Boolean chageGroupFlag = _form.getChageGroupFlag();
			final Long groupId = _form.getGroupResourceId();
			final Boolean recursive = _form.getRecursive();
			coreService
					.changeSystemPreperties(resource, ownPermission, groupPermission,
							otherPermission, ownId, groupId,
							chagePermissionFlag, chageOwnFlag, chageGroupFlag,
							recursive, getClientSession());
			actionMessages.add(ActionMessages.GLOBAL_MESSAGE,
					new ActionMessage(SUCCESS_MESSAGE));
			addMessages(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
		} else {
			actionMessages.add(CmsCommonConstants.EMPTY_STRING,
					new ActionMessage(FAILURE_MESSAGE, contentFullPath));
			addErrors(request, actionMessages);
			return mapping.findForward(CmsCommonConstants.FORWARD.FAILURE);
		}
	}
}
