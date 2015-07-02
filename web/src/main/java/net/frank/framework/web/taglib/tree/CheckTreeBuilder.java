package net.frank.framework.web.taglib.tree;

import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public abstract class CheckTreeBuilder {

	public abstract TreeNode buildTree(HttpServletRequest request,
			ServletContext context, String parameter);
	
	public abstract boolean isChecked(TreeNode node);

	public String printScript(TreeNode node,String treeName){
		StringBuffer buf = new StringBuffer();
//		buf.append("<ul id=\"").append("tree-").append(treeName).append("\" class=\"checktree\">\n");
//			printNodeScript(buf, node,treeName);
//		buf.append("</ul>\n");
		buf.append(treeName + ".add('root', '-1', '" + node.getName() + "');").append("\n");
		for (Iterator<TreeNode> it = node.getChildren().iterator(); it.hasNext();) {
			TreeNode cnode =  it.next();
			printNodeScript(buf, cnode, treeName, "root");
		}
//		printNodeScript(buf, node, treeName, "root");
		buf.append(treeName + ".showTree();").append("\n");
		buf.append(treeName + ".openAll();").append("\n");
		return buf.toString();
	}
	
	protected void printNodeScript(StringBuffer buf, TreeNode node,String treeName, String parentId){
		boolean checked = isChecked(node);
		buf.append(treeName).append(".add(");	//action
		buf.append("'").append(node.getId()).append("',");	//id
		buf.append("'").append(parentId).append("',");		//pid
		buf.append("'").append(node.getName()).append("',");//name
		buf.append("null,");								//url
		buf.append(checked).append(",true);");				//checked, open
		buf.append("\n");
//		System.out.println(buf.toString());
		if(node.getChildren() == null || node.getChildren().size() == 0)
			return;
		for (Iterator<TreeNode> it = node.getChildren().iterator(); it.hasNext();) {
			TreeNode cnode = (TreeNode) it.next();
			printNodeScript(buf, cnode, treeName, node.getId());
		}
	}
	
/*
 	protected void printNodeScript(StringBuffer buf, TreeNode node,String treeName){
		buf.append("\n");
		for (int i = 0; i < node.getLevel(); i++) {
			buf.append("    ");
		}
		String name = node.getName();
		Collection children = node.getChildren();
		
		buf.append("<li ");
		if (node.isRoot() || node.getParent()!=null && node.getParent().getChildAt(node.getParent().getChildren().size()-1)==node){
			buf.append("class=\"last\"");
		}
		if (children!=null && children.size()>0){
			buf.append("id=\"show-").append(node.getId()).append("\"");	
		}
		buf.append(">\n");
		if(!isChecked(node))
			buf.append("<input name=\"ids\" id=\"check-").append(node.getId()).append("\" type=\"checkbox\" value=\"").append(node.getId()).append("\" />\n");
		else
			buf.append("<input name=\"ids\" id=\"check-").append(node.getId()).append("\" type=\"checkbox\" checked value=\"").append(node.getId()).append("\" />\n");
		
		buf.append(name).append("</li>");
		
		

		if (children != null && children.size()>0) {
			buf.append("<ul id=").append("tree-").append(node.getId()).append(" class=\"checktree\">\n");
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				TreeNode element = (TreeNode) iter.next();
				printNodeScript(buf, element,name);
			}
			buf.append("</ul>\n");
		}
	}
//	*/
}
