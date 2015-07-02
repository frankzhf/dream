/*    */ package net.frank.cms.web.core.tag;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.commons.util.StringUtil;
/*    */ import net.frank.framework.web.taglib.tree.TreeNode;
/*    */ 
/*    */ public class DialogTree extends ResourceSystemTree
/*    */ {
/*    */   protected void printNodeScript(HttpServletRequest request, ServletContext context, StringBuffer buf, TreeNode node, String treeName)
/*    */   {
/* 19 */     buf.append("\n");
/* 20 */     for (int i = 0; i < node.getLevel(); i++) {
/* 21 */       buf.append("    ");
/*    */     }
/* 23 */     String dispalyName = dispalyName(node);
/* 24 */     String varName = treeName + "_item" + node.getId();
/* 25 */     buf.append("var " + varName + " = new WebFXTreeItem('").append(dispalyName).append("'");
/*    */ 
/* 28 */     if (StringUtil.isEmpty(getCallback())) {
/* 29 */       buf.append(");");
/*    */     }
/* 31 */     else if (getCallback().toLowerCase().startsWith("javascript:"))
/*    */     {
/* 34 */       buf.append(",'" + getCallback() + "');");
/*    */     }
/* 36 */     else if (!node.getId().startsWith(IGNORE_PRE)) {
/* 37 */       buf.append(",\"javascript:TreeAjax.showCallbackPage('" + getCallback() + "'," + treeName + ".getSelected().getId(),reply0);\");");
/*    */     }
/*    */     else
/*    */     {
/* 41 */       buf.append(");");
/*    */     }
/*    */ 
/* 47 */     buf.append(varName + ".setId('" + node.getId() + "');");
/* 48 */     String nodeIcon = getNodeIcon(node);
/* 49 */     String nodeOpenIcon = getNodeOpenIcon(node);
/* 50 */     if (nodeIcon != null) {
/* 51 */       buf.append(varName + ".setIcon('" + request.getContextPath() + nodeIcon + "');");
/*    */     }
/*    */ 
/* 54 */     if (nodeOpenIcon != null) {
/* 55 */       buf.append(varName + ".setOpenIcon('" + request.getContextPath() + nodeOpenIcon + "');");
/*    */     }
/*    */ 
/* 58 */     if (node.getParent() != null) {
/* 59 */       buf.append(treeName + "_item" + node.getParent().getId() + ".add(" + varName + ");");
/*    */     }
/*    */     else {
/* 62 */       buf.append(treeName + ".add(" + varName + ");");
/*    */     }
/*    */ 
/* 65 */     Collection children = node.getChildren();
/*    */     Iterator iter;
/* 67 */     if (children != null)
/* 68 */       for (iter = children.iterator(); iter.hasNext(); ) {
/* 69 */         TreeNode element = (TreeNode)iter.next();
/* 70 */         if ((CommonConstants.TYPE.RESOURCE.equals(element.getTypeId())) || (element.getTypeId().equals(getParameter())))
/*    */         {
/* 72 */           printNodeScript(request, context, buf, element, treeName);
/*    */         }
/*    */       }
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.tag.DialogTree
 * JD-Core Version:    0.6.0
 */