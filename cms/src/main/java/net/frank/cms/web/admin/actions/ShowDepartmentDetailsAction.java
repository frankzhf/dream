package net.frank.cms.web.admin.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Person;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Staff;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.struts.action.BaseAction;
import net.frank.framework.struts.form.CmsForm;

public class ShowDepartmentDetailsAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CmsForm _form = (CmsForm)form;
		Resource param = _form.getResource();
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource department = cmsService.getResource(param,getClientSession());
		if(CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(department.getCode())){
			Unit unit = (Unit)department.getObject();
			unit.setResource(department);
			request.setAttribute("unit", unit);
			Resource staffRes = unit.getManager$16();
			staffRes = cmsService.getResource(staffRes, getClientSession());
			if(CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(staffRes.getCode())){
				Staff staff = (Staff)staffRes.getObject();
				staff.setResource(staffRes);
				request.setAttribute("staff", staff);
				Resource personRes = staff.getPerson$15();
				personRes = cmsService.getResource(personRes, getClientSession());
				if(CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(personRes.getCode())){
					Person person = (Person)personRes.getObject();
					person.setResource(personRes);
					request.setAttribute("person", person);
				}
			}
		}
		return mapping.findForward(CmsCommonConstants.FORWARD.SUCCESS);
	}
}