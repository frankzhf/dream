package net.frank.repository.web.tags;

import java.util.Iterator;
import java.util.List;

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
import net.frank.repository.service.RepositoryQueryService;
import net.frank.repository.service.ServiceNames;

public class MyProjectsTreeBuilder extends TreeBuilder {
	
	private static final String MY_PROJECTS_ALAIS = "My Projects";
	private static final String PATH_REPOSITORY = "repository";
	private static final String PATH_PUBLISHED = "published";
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		RepositoryQueryService repositoryQueryService = (RepositoryQueryService) SpringContextUtil
				.getBean(ServiceNames.REPOSITORY_QUERY_SERVICE);
		ClientSession cs = AuthenticatorHolder.getClientSession();
		TreeNode _root = new TreeNode();
		_root.setId(0+CommonConstants.EMPTY_STRING);
		_root.setName(MY_PROJECTS_ALAIS);
		_root.setTypeId(CommonConstants.TYPE.UNIT);
		List<Long> unitResourceList = repositoryQueryService.listAllUnit();
		
		if(unitResourceList!=null && !unitResourceList.isEmpty()){
			for(Iterator<Long> it =unitResourceList.iterator();it.hasNext();){
				Long currUnitResourceId = it.next();
				Resource currUnitResource = new Resource();
				currUnitResource.setId(currUnitResourceId);
				currUnitResource = cmsService.getResource(currUnitResource, cs);
				if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(currUnitResource.getCode())){
					Unit currUnit = (Unit)currUnitResource.getObject();
					Resource currUnitContext = currUnit.getContext$3();
					Resource currRepositoryRes = cmsService.getResource(currUnitContext, PATH_REPOSITORY, cs);
					Resource currPublishedRes = cmsService.getResource(currRepositoryRes, PATH_PUBLISHED, cs);
					if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(currPublishedRes.getCode())){
						TreeNode _child = new TreeNode();
						_child.setName(currUnit.getUnitName()+"("+currUnit.getUnitCode()+")");
						_child.setId(currPublishedRes.getId()+CommonConstants.EMPTY_STRING);
						_child.setTypeId(CommonConstants.TYPE.UNIT);
						_root.addChild(_child);
					}
				}
			}
		}
		
		
		return _root;
	}

}
