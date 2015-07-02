package net.frank.cms.web.admin.ajaxs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.cms.service.AdminService;
import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.ajax.BaseAjax;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeNode;

public class AdminAjax extends BaseAjax {

	/**
	 * @param id
	 * @return
	 */
	public List<TreeNode> getDepartmentChildren(Long id) {
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		List<TreeNode> rt = new ArrayList<TreeNode>();
		Resource param = new Resource();
		param.setId(id);
		Resource _department = cmsService.getResource(param, cs);
		if (CmsCommonConstants.CMS_CODE.MESSAGE_OK
				.equals(_department.getCode())) {
			Unit department = (Unit) (_department.getObject());
			Resource context = department.getContext$3();
			Resource children = cmsService.getResource(context,
					CmsCommonConstants.CONTEXT.UNIT.CHILDREN, cs);
			if (children != null
					&& CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(children
							.getCode()) && children.getChildren() != null
					&& !children.getChildren().isEmpty()) {
				for (Iterator<Resource> it = children.getChildren().iterator(); it
						.hasNext();) {
					Resource child = it.next();
					child = cmsService.getResource(child, cs);
					if (CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(child
							.getCode())
							&& CmsCommonConstants.TYPE.UNIT.equals(child
									.getTypeId())) {
						TreeNode _child = new TreeNode();
						_child.setId(CmsCommonConstants.EMPTY_STRING
								+ child.getId());
						_child.setName(child.getAlias());
						_child.setTypeId(CmsCommonConstants.TYPE.UNIT);
						rt.add(_child);
					}
				}
				return rt;
			}
		}
		return rt;
	}

	/***
	 * 
	 * @param unitResourceId
	 * @param staffResourceId
	 * @return
	 */
	public int validateAppointManager(Long unitResourceId, Long staffResourceId) {
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		ClientSession cs = getClientSession();
		boolean flag = adminService.validateAppointManager(unitResourceId,
				staffResourceId, cs);
		if (flag) {
			return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
		} else {
			return CmsCommonConstants.CMS_CODE.MESSAGE_EXISTS;
		}

	}

	/***
	 * 
	 * @param unitResourceId
	 * @param staffResourceId
	 * @return
	 */
	public int appointManager(Long unitResourceId, Long staffResourceId) {
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		ClientSession cs = getClientSession();
		adminService.appointManager(unitResourceId, staffResourceId, cs);
		return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	/***
	 * 
	 * @param unitResourceId
	 * @param departmentName
	 * @param departmentCode
	 * @return
	 */
	
	public int validateAddDepartment(Long unitResourceId,
			String departmentName, String departmentCode) {
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = getClientSession();
		Resource parentUnitRes = new Resource();
		parentUnitRes.setId(unitResourceId);
		parentUnitRes = cmsService.getResource(parentUnitRes, cs);
		Resource unitContext = ((Unit)parentUnitRes.getObject()).getContext$3();
		Resource childrenRes = cmsService.getResource(unitContext, CommonConstants.CONTEXT.UNIT.CHILDREN, cs);
		for(Iterator<Resource> it=childrenRes.getChildren().iterator();it.hasNext();){
			Resource child = it.next();
			child = cmsService.getResource(child, cs);
			if(CommonConstants.TYPE.UNIT.equals(child.getTypeId())){
				Unit childUnit = (Unit)child.getObject();
				if(childUnit.getUnitName().equals(departmentName)){
					return CommonConstants.CMS_CODE.MESSAGE_EXISTS;
				}
				if(childUnit.getUnitCode().equals(departmentCode)){
					return CommonConstants.CMS_CODE.MESSAGE_NOT_EXISTS;
				}
			}
		}
		return CommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	public int addDepartment(Long unitResourceId,
			String departmentName, String departmentCode) {
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		ClientSession cs = getClientSession();
		Resource parentUnitRes = new Resource();
		parentUnitRes.setId(unitResourceId);
		parentUnitRes = cmsService.getResource(parentUnitRes, cs);
		adminService.addUnit(departmentName, departmentCode, parentUnitRes, cs);
		return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	public int validateStaffGroup(Long groupResourceId,Long staffResourceId){
		ClientSession cs = getClientSession();
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		if(adminService.validateGrantStaffGroup(groupResourceId, staffResourceId, cs)){
			return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
		}else{
			return CmsCommonConstants.CMS_CODE.MESSAGE_EXISTS;
		}
	}
	
	public int grantStaffGroup(Long groupResourceId,Long staffResourceId){
		ClientSession cs = getClientSession();
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		adminService.grantStaffGroup(groupResourceId, staffResourceId, cs);
		return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
	public int removeStaffGroup(Long a2gResourceId){
		ClientSession cs = getClientSession();
		AdminService adminService = (AdminService) SpringContextUtil
				.getBean(ServiceNames.ADMIN_SERVICE);
		adminService.removeStaffGroup(a2gResourceId, cs);
		return CmsCommonConstants.CMS_CODE.MESSAGE_OK;
	}
	
}
