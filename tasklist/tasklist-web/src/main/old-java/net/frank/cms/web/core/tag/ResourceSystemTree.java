/*    */ package net.frank.cms.web.core.tag;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.spring.SpringContextUtil;
/*    */ import net.frank.framework.web.taglib.tree.TreeBuilder;
/*    */ import net.frank.framework.web.taglib.tree.TreeNode;
/*    */ 
/*    */ public class ResourceSystemTree extends TreeBuilder
/*    */ {
/*    */   private static TreeNode ROOT_FOLDER;
/* 21 */   private static final Long ROOT_ID = Long.valueOf(1L);
/*    */ 
/*    */   public TreeNode buildTree(HttpServletRequest request, ServletContext context)
/*    */   {
/*    */     Iterator it;
/* 25 */     if (ROOT_FOLDER == null) {
/* 26 */       QueryService queryService = (QueryService)SpringContextUtil.getBean("queryService");
/* 27 */       Resource root = queryService.getResource(ROOT_ID);
/* 28 */       ROOT_FOLDER = new TreeNode();
/* 29 */       ROOT_FOLDER.setId(root.getId() + "");
/* 30 */       ROOT_FOLDER.setName(root.getAlias());
/* 31 */       ROOT_FOLDER.setTypeId(root.getTypeId());
/* 32 */       List children = queryService.retrieveResourceByParent(root.getId());
/* 33 */       if ((children != null) && (!children.isEmpty())) {
/* 34 */         for (it = children.iterator(); it.hasNext(); ) {
/* 35 */           Resource child = (Resource)it.next();
/* 36 */           TreeNode childNode = new TreeNode();
/* 37 */           childNode.setId(child.getId() + "");
/* 38 */           childNode.setName(child.getAlias());
/* 39 */           childNode.setTypeId(child.getTypeId());
/* 40 */           ROOT_FOLDER.addChild(childNode);
/*    */         }
/*    */       }
/*    */     }
/* 44 */     return ROOT_FOLDER;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.tag.ResourceSystemTree
 * JD-Core Version:    0.6.0
 */