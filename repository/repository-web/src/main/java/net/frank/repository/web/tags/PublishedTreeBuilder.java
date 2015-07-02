package net.frank.repository.web.tags;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.service.CmsService;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;
import net.frank.repository.service.ServiceNames;

public class PublishedTreeBuilder extends TreeBuilder {
	
	private static final String PATH_REPOSITORY = "repository";
	private static final String PATH_PUBLISHED = "published";
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		Map<String,Object> paramMap = getParamMap();
		Unit currentUnit = (Unit)paramMap.get("currentUnit");
		TreeNode _root = new TreeNode();
		Resource currUnitContext = currentUnit.getContext$3();
		Resource currRepositoryRes = cmsService.getResource(currUnitContext, PATH_REPOSITORY, cs);
		Resource currPublishedRes = cmsService.getResource(currRepositoryRes, PATH_PUBLISHED, cs);
		if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(currPublishedRes.getCode())){
			//TreeNode _child = new TreeNode();
			_root.setName(currentUnit.getUnitName()+"("+currentUnit.getUnitCode()+")");
			_root.setId(currPublishedRes.getId()+CommonConstants.EMPTY_STRING);
			_root.setTypeId(CommonConstants.TYPE.UNIT);
			//_root.addChild(_child);
		}
		return _root;
	}

}
