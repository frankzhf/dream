package net.frank.cms.web.admin.tag;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;

public class DeparentTreeBuilder extends TreeBuilder {
	
	private static final String DEPARTMENT_ROOT_PATH = "/unit/SZ-ODC";
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		CmsService cmsService = (CmsService) SpringContextUtil.getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		Resource rootDepartment = cmsService.getResource(DEPARTMENT_ROOT_PATH, cs);
		if(CmsCommonConstants.CMS_CODE.MESSAGE_OK.equals(rootDepartment.getCode())){
			TreeNode ROOT_FOLDER = new TreeNode();
			ROOT_FOLDER.setId(rootDepartment.getId()+CmsCommonConstants.EMPTY_STRING);
			ROOT_FOLDER.setName(rootDepartment.getAlias());
			ROOT_FOLDER.setTypeId(CmsCommonConstants.TYPE.UNIT);
			return ROOT_FOLDER;
		}else{
			TreeNode ROOT_FOLDER = new TreeNode();
			ROOT_FOLDER.setId("-1"+CmsCommonConstants.EMPTY_STRING);
			ROOT_FOLDER.setName("unknown");
			ROOT_FOLDER.setTypeId(CmsCommonConstants.TYPE.UNIT);
			return ROOT_FOLDER;
		}
	}

}
