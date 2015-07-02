package net.frank.cms.web.common.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.DialogForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class DialogSelectorAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DialogForm dialogForm = (DialogForm) form;

		String fieldName = dialogForm.getFieldName();
		String fieldValue = dialogForm.getFieldValue();
		log.debug("fieldName ->" + fieldName);
		log.debug("fieldValue ->" + fieldValue);
		QueryService queryService = (QueryService) getService(request,
				ServiceNames.QUERY_SERVICE);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldValue", fieldValue);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(dialogForm.getDialogRootId()!=null){
			paramMap.put("dialogRootId", dialogForm.getDialogRootId());
		}
		String typeId = null;
		if (fieldValue != null
				&& !CmsCommonConstants.EMPTY_STRING.equals(fieldValue)) {
			Resource resource = queryService.getResource(Long
					.decode(fieldValue));
			typeId = resource.getTypeId() + CmsCommonConstants.EMPTY_STRING;
			String selectedLinkList = queryService.getNodePath(resource);
			log.debug("selectedLinkList ->" + selectedLinkList);
			request.setAttribute("selectedLinkList", selectedLinkList);
		} else {
			int begIndex = fieldName
					.indexOf(CmsCommonConstants.DATA_FIELD_REFER_SYMBOL_BEG) + 1;
			int endIndex = fieldName
					.indexOf(CmsCommonConstants.DATA_FIELD_REFER_SYMBOL_END);
			typeId = fieldName.substring(begIndex , endIndex);
		}
		log.debug("Type Id -> " + typeId);
		paramMap.put("typeId", typeId);
		request.setAttribute("typeId", typeId);
		request.setAttribute("paramMap", paramMap);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
