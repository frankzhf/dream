package net.frank.cms.ext.selector.unit.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.ext.selector.unit.service.impl.ServiceNames;
import net.frank.cms.web.common.forms.DialogForm;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.DialogTreeService;
import net.frank.framework.service.impl.QueryServiceImpl;
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
		DialogTreeService treeService = (DialogTreeService) 
				getBean(ServiceNames.TREE_SERVICE);
		request.setAttribute("fieldName", fieldName);
		request.setAttribute("fieldValue", fieldValue);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		if(dialogForm.getDialogRootId()!=null){
			paramMap.put("dialogRootId", dialogForm.getDialogRootId());
		}
		String typeId = CmsCommonConstants.TYPE.UNIT + CmsCommonConstants.EMPTY_STRING;
		if (fieldValue != null
				&& !CmsCommonConstants.EMPTY_STRING.equals(fieldValue)) {
			Resource selectedNode = ((QueryServiceImpl)treeService).getResource(Long.decode(fieldValue));
			String selectedLinkList = treeService.getSelectedLinks(selectedNode, getClientSession());
			log.debug("selectedLinkList ->" + selectedLinkList);
			request.setAttribute("selectedLinkList", selectedLinkList);
		}
		log.debug("Type Id -> " + typeId);
		paramMap.put("typeId", typeId);
		request.setAttribute("typeId", typeId);
		request.setAttribute("paramMap", paramMap);
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
