package net.frank.repository.web.tags;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.frank.repository.CommonConstants;
import net.frank.framework.bo.Account;
import net.frank.framework.bo.Resource;
import net.frank.framework.service.CmsService;
import net.frank.framework.service.QueryService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;
import net.frank.framework.web.security.AuthenticatorHolder;
import net.frank.framework.web.security.ClientSession;
import net.frank.framework.web.taglib.tree.TreeBuilder;
import net.frank.framework.web.taglib.tree.TreeNode;

public class MyFilesTreeBuilder extends TreeBuilder {
	
	public static final String MY_FILES_TREE_SESSION_KEY = "repository.my.tree";
	public static final String MY_FILES_NODE_MAP_SESSION_KEY = "repository.node.map";
	
	@Override
	public TreeNode buildTree(HttpServletRequest request, ServletContext context) {
		CmsService cmsService = (CmsService)SpringContextUtil.getBean(ServiceNames.CMS_SERVICE);
		QueryService queryService = (QueryService)SpringContextUtil.getBean(ServiceNames.QUERY_SERVICE);
		ClientSession clientSession = AuthenticatorHolder.getClientSession();
		Account currentAccount = clientSession.getAccount();
		Resource _home = currentAccount.getHome$3();
		TreeNode _root = (TreeNode)request.getSession().getAttribute(MY_FILES_TREE_SESSION_KEY);
		if(_root == null){
			Map<Long,TreeNode> nodeMap = new HashMap<Long,TreeNode>();
			Resource root = queryService.getResourceAsPath(_home, CommonConstants.CONTEXT.ACCOUNT.MY_DOCUMENT);
			root = cmsService.getResource(root, clientSession);
			_root = new TreeNode();
			_root.setName(root.getAlias());
			_root.setId(root.getId()+CommonConstants.EMPTY_STRING);
			_root.setTypeId(CommonConstants.TYPE.RESOURCE);
			nodeMap.put(root.getId(), _root);
			makeTree(_root,root,nodeMap,cmsService,clientSession);
			TreeNode _sharedNode = new TreeNode();
			_sharedNode.setName("myReceived");
			_sharedNode.setId("0");
			_sharedNode.setTypeId(CommonConstants.TYPE.RESOURCE);
			_root.addChild(_sharedNode);
			request.getSession().setAttribute(MY_FILES_TREE_SESSION_KEY, _root);
			request.getSession().setAttribute(MY_FILES_NODE_MAP_SESSION_KEY, nodeMap);
		}
		return _root;
	}

	private void makeTree(TreeNode _root, Resource root,Map<Long,TreeNode> nodeMap, CmsService cmsService, ClientSession clientSession) {
		if(_root==null || root == null || !CommonConstants.TYPE.RESOURCE.equals(root.getTypeId())
				|| root.getChildren()==null || root.getChildren().isEmpty()){
			return;
		}
		for(Iterator<Resource> it = root.getChildren().iterator();it.hasNext();){
			Resource child = it.next();
			child = cmsService.getResource(child, clientSession);
			if(CommonConstants.TYPE.RESOURCE.equals(child.getTypeId())){
				TreeNode _child = new TreeNode();
				_child.setName(child.getAlias());
				_child.setId(child.getId()+CommonConstants.EMPTY_STRING);
				_child.setTypeId(CommonConstants.TYPE.RESOURCE);
				_root.addChild(_child);
				nodeMap.put(child.getId(), _child);
				makeTree(_child,child,nodeMap,cmsService,clientSession);
			}
		}
	}

}
