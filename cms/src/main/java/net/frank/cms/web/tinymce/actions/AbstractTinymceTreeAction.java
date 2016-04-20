package net.frank.cms.web.tinymce.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.common.forms.DialogForm;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.CommonTreeAction;


public abstract class AbstractTinymceTreeAction extends CommonTreeAction {
	
	public abstract Long getTypeId();
	
	public final ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("typeId",CmsCommonConstants.TYPE.IMAGE);
			request.setAttribute("paramMap", paramMap);
			request.setAttribute("typeId", getTypeId());
			DialogForm dialogForm = (DialogForm) form;
			String fieldValue = dialogForm.getFieldValue();
			log.debug("fieldValue ->" + fieldValue);
			QueryService queryService = (QueryService) getService(request,
					ServiceNames.QUERY_SERVICE);
			String selectedLinkList = CommonConstants.EMPTY_STRING;
			if(fieldValue!=null && !CommonConstants.EMPTY_STRING.equals(fieldValue) ){
				Resource resource = queryService.getResource(Long
						.decode(fieldValue));
				selectedLinkList = queryService.getNodePath(resource);
			}
			log.debug("selectedLinkList ->" + selectedLinkList);
			request.setAttribute("selectedLinkList", selectedLinkList);
			return super.execute(mapping, form, request, response);
		}
}
