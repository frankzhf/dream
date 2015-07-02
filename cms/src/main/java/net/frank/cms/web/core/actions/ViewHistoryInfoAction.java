package net.frank.cms.web.core.actions;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.web.core.forms.HistoryForm;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.SystemHistory;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViewHistoryInfoAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HistoryForm _form = (HistoryForm) form;
		Long systemHistoryId= _form.getSystemHistory().getId();
		log.debug("systemHistoryId => "+systemHistoryId);
		QueryService queryService = (QueryService) getBean(ServiceNames.QUERY_SERVICE);
		SystemHistory sh = queryService.getSystemHistory(systemHistoryId);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(sh.getHistoryContent()));
		Resource resource = (Resource)in.readObject();
		request.setAttribute("resource", resource);
		if(!CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())){
			BusinessObject bo = resource.getObject();
			bo.setResource(resource);
			request.setAttribute("content", bo);
		}
		
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}
