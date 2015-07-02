package net.frank.cms.web.core.tag;

//import java.util.Iterator;
//import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;

public class ResourceSystemTree extends TreeBuilder {
	
	private static TreeNode ROOT_FOLDER;
	
	private static final Long ROOT_ID = 1L;
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		if(ROOT_FOLDER==null){
			QueryService queryService = (QueryService)SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
			Resource root = queryService.getResource(ROOT_ID);
			ROOT_FOLDER = new TreeNode();
			ROOT_FOLDER.setId(root.getId()+CmsCommonConstants.EMPTY_STRING);
			ROOT_FOLDER.setName(root.getAlias());
			ROOT_FOLDER.setTypeId(root.getTypeId());
			/****
			List<Resource> children = queryService.retrieveResourceByParent(root.getId());
			if(children!=null && !children.isEmpty()){
				for(Iterator<Resource> it=children.iterator();it.hasNext();){
					Resource child = it.next();
					TreeNode childNode=new TreeNode();
					childNode.setId(child.getId()+CmsCommonConstants.EMPTY_STRING);
					childNode.setName(child.getAlias());
					childNode.setTypeId(child.getTypeId());
					ROOT_FOLDER.addChild(childNode);
				}
			}
			***/
		}
		return ROOT_FOLDER;
	}

}
