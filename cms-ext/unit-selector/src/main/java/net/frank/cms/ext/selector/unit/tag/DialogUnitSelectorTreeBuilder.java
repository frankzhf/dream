package net.frank.cms.ext.selector.unit.tag;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.cms.ext.selector.unit.service.impl.ServiceNames;
import net.frank.commons.CommonConstants;
import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.Resource;
import net.frank.framework.bo.Unit;
import net.frank.framework.security.RootSessionHolder;
import net.frank.framework.security.Session;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.DialogTreeService;
import net.frank.framework.service.PermissionService;
import net.frank.framework.spring.SpringContextHolder;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;

public class DialogUnitSelectorTreeBuilder extends TreeBuilder {

	private static TreeNode root = null;
	private static Object lockor = new Object();
	private static Long updatedDt = -1L;

	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		DialogTreeService treeService = (DialogTreeService) SpringContextUtil
				.getBean(ServiceNames.TREE_SERVICE);
		CmsService cmsService = (CmsService) SpringContextUtil
				.getBean(ServiceNames.CMS_SERVICE);
		Session cs = RootSessionHolder.getDefaultRootSession();
		Resource bussinessRoot = treeService.getRoot(null, cs);
		synchronized (lockor) {
			if (root == null
					|| (bussinessRoot != null && !updatedDt.equals(bussinessRoot
							.getLastUpdatedDt().getTime()))) {
				log.debug("Re-generate Department Tree");
				root = new TreeNode();
				root.setId(bussinessRoot.getId() + CommonConstants.EMPTY_STRING);
				root.setName(bussinessRoot.getAlias());
				root.setTypeId(bussinessRoot.getTypeId());
				root.setResource(bussinessRoot);
				if(bussinessRoot.getChildren()!=null 
						&& !bussinessRoot.getChildren().isEmpty()){
					for(Iterator<Resource>it=bussinessRoot.getChildren().iterator();it.hasNext();){
						Resource child = it.next();
						child = cmsService.getResource(child, cs);
						if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(child.getCode()) &&
								CommonConstants.TYPE.UNIT.equals(child.getTypeId())){
							TreeNode childNote = new TreeNode();
							childNote.setId(child.getId() + CommonConstants.EMPTY_STRING);
							childNote.setName(child.getAlias());
							childNote.setTypeId(child.getTypeId());
							childNote.setResource(child);
							root.addChild(childNote);
							fillUnitTree(childNote,treeService,cmsService,cs);
						}
					}
				}
				updatedDt = bussinessRoot.getLastUpdatedDt().getTime();
			}
		}
		return root;
	}
	
	private void fillUnitTree(TreeNode currentNode,DialogTreeService treeService,
			CmsService cmsService,Session cs){
		Unit currentUnit = (Unit)currentNode.getResource().getObject();
		Resource resUnitContext = currentUnit.getContext$3();
		Resource childrenFolder = cmsService.getResource(resUnitContext, CommonConstants.CONTEXT.UNIT.CHILDREN, cs);
		if(childrenFolder!=null && childrenFolder.getChildren()!=null
				&& !childrenFolder.getChildren().isEmpty()){
			for(Iterator<Resource>it=childrenFolder.getChildren().iterator();it.hasNext();){
				Resource child = it.next();
				child = cmsService.getResource(child, cs);
				if(CommonConstants.CMS_CODE.MESSAGE_OK.equals(child.getCode()) &&
						CommonConstants.TYPE.UNIT.equals(child.getTypeId())){
					TreeNode childNote = new TreeNode();
					childNote.setId(child.getId() + CommonConstants.EMPTY_STRING);
					childNote.setName(child.getAlias());
					childNote.setTypeId(child.getTypeId());
					childNote.setResource(child);
					currentNode.addChild(childNote);
					fillUnitTree(childNote,treeService,cmsService,cs);
				}
			}
		}
	}
	
	
	protected void printNodeScript(HttpServletRequest request,
			ServletContext context, StringBuffer buf, TreeNode node,
			String treeName) {
		PermissionService permissionService =(PermissionService) SpringContextHolder.getApplicationContext().getBean("permissionService");
		ClientSession cs = AuthenticatorHolder.getClientSession();
		if(permissionService.checkReadPermission(node.getResource(), cs)){
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
					TreeNode element =  iter.next();	
					printNodeScript(request, context, buf, element, treeName);
				}
			}
		}
	}
}