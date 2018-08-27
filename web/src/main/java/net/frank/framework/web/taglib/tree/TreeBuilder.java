package net.frank.framework.web.taglib.tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.commons.util.StringUtil;
import net.frank.framework.bo.BaseEntity;
import net.frank.framework.bo.Type;
import net.frank.framework.service.CacheService;
import net.frank.framework.service.ServiceNames;
import net.frank.framework.spring.SpringContextUtil;

public abstract class TreeBuilder {
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	private String callback = "";
	public static String IGNORE_PRE = "ignore";
	private Map<String,Object> paramMap;
	private Map<Long, Type> typeContentMap;
	private Map<Long, BaseEntity> classInstanceMap = new HashMap<Long, BaseEntity>();

	public TreeBuilder() {
		CacheService cacheService = (CacheService) SpringContextUtil
				.getBean(ServiceNames.CACHE_SERVICE);
		typeContentMap = cacheService.getTypeContent();
	}

	public Map<String,Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String,Object> paramMap) {
		this.paramMap = paramMap;
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public abstract TreeNode buildTree(HttpServletRequest request,
			ServletContext context);

	public String getNodeIcon(TreeNode node) {
		// Resource o = node.getResource();
		BaseEntity oo = null;
		if (classInstanceMap.get(node.getTypeId()) == null) {
			try {
				oo = (BaseEntity) Class.forName(
						typeContentMap.get(node.getTypeId())
								.getEntityClassName()).newInstance();
			} catch (Exception e) {

			}
			classInstanceMap.put(node.getTypeId(), oo);
		}
		return classInstanceMap.get(node.getTypeId()).getNodeIcon();
	}

	public String getNodeOpenIcon(TreeNode node) {
		// Resource o = node.getResource();
		BaseEntity oo = null;
		if (classInstanceMap.get(node.getTypeId()) == null) {
			try {
				oo = (BaseEntity) Class.forName(
						typeContentMap.get(node.getTypeId())
								.getEntityClassName()).newInstance();
			} catch (Exception e) {

			}
			classInstanceMap.put(node.getTypeId(), oo);
		}
		return classInstanceMap.get(node.getTypeId()).getNodeOpenIcon();
	}

	protected String dispalyName(TreeNode node) {
		return node.getName();
	}

	public String printXML(TreeNode node) {
		StringBuffer buf = new StringBuffer();
		buf.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");
		buf.append("<tree>\n");
		printNodeXML(buf, node);
		buf.append("</tree>\n");
		String content = buf.toString();
		return content;
	}

	protected void printNodeXML(StringBuffer buf, TreeNode node) {
		for (int i = 0; i < node.getLevel(); i++) {
			buf.append("    ");
		}
		String name = node.getName();
		buf.append("<tree text='").append(name).append("' ");
		if (getCallback().toLowerCase().startsWith("javascript")) {
			buf.append("action=\"" + getCallback() + "\"; ");
		} else {
			buf.append("action=\"javascript:"
					+ getCallback()
					+ ";\"); ");
		}
		buf.append("id='" + node.getId() + "'");
		buf.append(">\n");
		Collection<TreeNode> children = node.getChildren();

		if (children != null) {
			for (Iterator<TreeNode> iter = children.iterator(); iter.hasNext();) {
				TreeNode element = (TreeNode) iter.next();
				printNodeXML(buf, element);
			}
		}
		buf.append("</tree>\n");

	}

	public String printScript(HttpServletRequest request,
			ServletContext context, TreeNode node, String treeName) {
		StringBuffer buf = new StringBuffer();
		printNodeScript(request, context, buf, node, treeName);
		String content = buf.toString();
		return content;
	}

	public String printScript2(HttpServletRequest request,
			ServletContext context, TreeNode node, String treeName) {
		StringBuffer buf = new StringBuffer();
		printNodeScript2(request, context, buf, node, treeName);
		String content = buf.toString();
		return content;
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
					buf.append(",\"javascript:"
							+ getCallback() +";\"); ");
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

		if (children != null) {
			for (Iterator<TreeNode> iter = children.iterator(); iter.hasNext();) {
				TreeNode element = (TreeNode) iter.next();
				printNodeScript(request, context, buf, element, treeName);
			}
		}

	}

	protected void printNodeScript2(HttpServletRequest request,
			ServletContext context, StringBuffer buf, TreeNode node,
			String treeName) {
		buf.append("");
		for (int i = 0; i < node.getLevel(); i++) {
			buf.append("    ");
		}
		String dispalyName = dispalyName(node);
		String varName = treeName + "_item" + node.getId();
		buf.append("var " + varName + " = new WebFXTreeItem(\\\'")
				.append(dispalyName).append("\\\'");

		if (StringUtil.isEmpty(getCallback())) {
			buf.append(");");
		} else {
			if (getCallback().toLowerCase().startsWith("javascript:")) {
				buf.append(",\\\'" + getCallback() + "\\\');");
			} else {
				if (!(node.getId().startsWith(IGNORE_PRE))) {
					buf.append(",\"javascript:TreeAjax.showCallbackPage(\\\'"
							+ getCallback() + "\\\'," + treeName
							+ ".getSelected().getId(),reply0);\");");
				} else {
					buf.append(");");
				}

			}
		}

		buf.append(varName + ".setId(\\\'" + node.getId() + "\\\');");
		String nodeIcon = getNodeIcon(node);
		String nodeOpenIcon = getNodeOpenIcon(node);
		if (nodeIcon != null) {
			buf.append(varName + ".setIcon(\\\'" + request.getContextPath()
					+ nodeIcon + "\\\');");
		}
		if (nodeOpenIcon != null) {
			buf.append(varName + ".setOpenIcon(\\\'" + request.getContextPath()
					+ nodeOpenIcon + "\\\');");
		}
		if (node.getParent() != null) {
			buf.append(treeName + "_item" + node.getParent().getId() + ".add("
					+ varName + ");");
		} else {
			buf.append(treeName + ".add(" + varName + ");");
		}

		Collection<TreeNode> children = node.getChildren();

		if (children != null) {
			for (Iterator<TreeNode> iter = children.iterator(); iter.hasNext();) {
				TreeNode element = (TreeNode) iter.next();
				printNodeScript2(request, context, buf, element, treeName);
			}
		}

	}
}
