package net.frank.site.xtree2.builder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.commons.CommonConstants;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;

public class NavigationTree extends TreeBuilder {
	
	private static final Long ROOT_ID = 1L;
	
	private static final String DEFAULT_NODE_ICON = "/resources/xtree2/img/folder.png";
	private static final String DEFAULT_NODE_OPEN_ICON = "/resources/xtree2/img/openfolder.png";
	
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		QueryService queryService = (QueryService)SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
		Resource root = queryService.getResource(ROOT_ID);
		TreeNode ROOT_FOLDER = new TreeNode();
		ROOT_FOLDER.setId(root.getId()+CommonConstants.EMPTY_STRING);
		ROOT_FOLDER.setName(root.getAlias());
		ROOT_FOLDER.setTypeId(root.getTypeId());
		return ROOT_FOLDER;
	}
	
	public String getNodeIcon(TreeNode node) {
		return DEFAULT_NODE_ICON;
	}

	public String getNodeOpenIcon(TreeNode node) {
		return DEFAULT_NODE_OPEN_ICON;
	}

}
