package net.frank.springweb.core;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.BusinessObject;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.web.spring.CmsForm;
import net.frank.framework.web.spring.controller.ControllerBaseSupport;

@Controller
@RequestMapping(value = "/core")
public class CmsController extends ControllerBaseSupport {
	
	private static final String CHECK_PERMISSIN = "CHECK_PERMISSIN";

	private static final String VIEW_BROWSER = "core/browser";
	private static final String VIEW_TREE = "core/tree";
	private static final String VIEW_DETAILS = "core/details";
	
	
	@RequestMapping(value = "/browser", method = RequestMethod.GET)
	public String browser(){
		return VIEW_BROWSER;
	}
	
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String tree(){
		return VIEW_TREE;
	}
	
	@RequestMapping(value = "/showDetails/{resourceId}", method = RequestMethod.GET)
	public String showDetails(@PathVariable("resourceId") Long resourceId,Model model){
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource queryTO = new Resource();
		queryTO.setId(resourceId);
		Resource resource = cmsService.getResource(queryTO,getClientSession());
		model.addAttribute("resource",resource);
		return VIEW_DETAILS;
	}
	
	@RequestMapping(value = "/createObject/{parentId}/{typeId}",method = RequestMethod.GET)
	public String createObject(@PathVariable("parentId") Long parentId,
			@PathVariable("typeId") Long typeId,Model model){
		PermissionService permissionService = (PermissionService) getBean(ServiceNames.PERMISSION_SERVICE);
		CmsService cmsService = (CmsService) getBean(ServiceNames.CMS_SERVICE);
		Resource parent = new Resource();
		parent.setId(parentId);
		parent = cmsService.getResource(parent, getClientSession());
		if(!CommonConstants.CMS_CODE.MESSAGE_OK.equals(parent.getCode())){
			model.addAttribute(CHECK_PERMISSIN, Boolean.FALSE);
		}else{
			model.addAttribute(CHECK_PERMISSIN, Boolean.TRUE);
			CmsForm _form = null;
			try{
				_form = new CmsForm();
			}catch(Exception e){}
			_form.getResource().setParentId(parentId);
			_form.getResource().setTypeId(typeId);
			String umask = getClientSession().getAccount().getUmask();
			Byte currentUserPermission = Integer.decode(umask
					.substring(0, 1)).byteValue();
			Byte currentGroupPermission = Integer.decode(umask.substring(1,
					2)).byteValue();
			Byte otherPermission = Integer.decode(umask.substring(2, 3)).byteValue();
			_form.getResource().setCurrentAccountPermission(currentUserPermission);
			_form.getResource().setCurrentGroupPermission(currentGroupPermission);
			_form.getResource().setOthersPermission(otherPermission);
			permissionService.fillForm(_form.getResource(), _form);
			BusinessObject content = null;
			if (CommonConstants.TYPE.RESOURCE.equals(typeId)) {
				content = null;
			} else {
				content = (BusinessObject) _form.getContentMap().get(typeId);
			}
			_form.getResource().setOwnResourceId(getClientSession().getAccount()
					.getResource().getId());
			_form.getResource().setOwnGroupResourceId(getClientSession().getCurrentGroup()
					.getResource().getId());
			_form.getResource().setCreatedDt(new Date());
			if (content != null) {
				content.setResource(_form.getResource());
			}
			model.addAttribute("mode", CommonConstants.PAGE_MODE.EDIT);
			model.addAttribute("form",_form);
		}
		return VIEW_DETAILS;
	}
	
}
