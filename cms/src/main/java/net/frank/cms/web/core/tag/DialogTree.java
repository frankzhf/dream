package net.frank.cms.web.core.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.cms.common.CmsCommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.taglib.tree.TreeNode;

public class DialogTree extends ResourceSystemTree {
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		if(getParamMap()!=null && getParamMap().get("dialogRootId")!=null 
				&& !CmsCommonConstants.EMPTY_STRING.equals( getParamMap().get("dialogRootId"))){
			Long rootId = (Long)getParamMap().get("dialogRootId");
			QueryService queryService = (QueryService)SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
			Resource root = queryService.getResource(rootId);
			TreeNode ROOT_FOLDER = new TreeNode();
			ROOT_FOLDER.setId(root.getId()+CmsCommonConstants.EMPTY_STRING);
			ROOT_FOLDER.setName(root.getAlias());
			ROOT_FOLDER.setTypeId(root.getTypeId());
			/***
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
			return ROOT_FOLDER;
		}else{
			return super.buildTree(request, context);
		}
	}
	
	protected void printNodeScript(HttpServletRequest request,
			ServletContext context, StringBuffer buf, TreeNode node,
			String treeName) {
		buf.append("\n");
		for (int i = 0; i < node.getLevel(); i++) {
			buf.append("    ");
		}
		String dispalyName = dispalyName(node);
		String varName = treeName + "_item" + node.getId();
		buf.append("var " + varName + " = new WebFXTreeItem('")
				.append(dispalyName).append("'");

		if (StringUtil.isEmpty(getCallback())) {
			buf.append(");");
		} else {
			if (getCallback().toLowerCase().startsWith("javascript:")) {
				buf.append(",'" + getCallback() + "');");
			} else {
				if (!(node.getId().startsWith(IGNORE_PRE))) {
					buf.append(",\"javascript:TreeAjax.showCallbackPage('"
							+ getCallback() + "'," + treeName
							+ ".getSelected().getId(),reply0);\");");
				} else {
					buf.append(");");
				}
			}
		}
		buf.append(varName + ".setId('" + node.getId() + "');");
		String nodeIcon = getNodeIcon(node);
		String nodeOpenIcon = getNodeOpenIcon(node);
		if (nodeIcon != null) {
			buf.append(varName + ".setIcon('" + request.getContextPath()
					+ nodeIcon + "');");
		}
		if (nodeOpenIcon != null) {
			buf.append(varName + ".setOpenIcon('" + request.getContextPath()
					+ nodeOpenIcon + "');");
		}
		if (node.getParent() != null) {
			buf.append(treeName + "_item" + node.getParent().getId() + ".add("
					+ varName + ");");
		} else {
			buf.append(treeName + ".add(" + varName + ");");
		}

		Collection<TreeNode> children = node.getChildren();

		if (children != null
				&& !children.isEmpty()) {
			for (Iterator<TreeNode> iter = children.iterator(); iter.hasNext();) {
				TreeNode element = iter.next();
				if(getParamMap()!=null && getParamMap().get("typeId")!=null 
						&& !CmsCommonConstants.EMPTY_STRING.equals( getParamMap().get("typeId"))){
					if(CmsCommonConstants.TYPE.RESOURCE.equals(element.getTypeId()) 
							|| element.getTypeId().equals(getParamMap().get("typeId"))){
						printNodeScript(request, context, buf, element, treeName);
					}
				}else{
					if(CmsCommonConstants.TYPE.RESOURCE.equals(element.getTypeId())){
						printNodeScript(request, context, buf, element, treeName);
					}
				}
			}
		}

	}

}
