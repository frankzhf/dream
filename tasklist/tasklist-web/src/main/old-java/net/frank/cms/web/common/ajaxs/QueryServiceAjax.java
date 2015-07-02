/*    */ package net.frank.cms.web.common.ajaxs;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.PermissionService;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.web.ajax.BaseAjax;
/*    */ import net.frank.framework.web.taglib.tree.TreeNode;
/*    */ 
/*    */ public class QueryServiceAjax extends BaseAjax
/*    */ {
/*    */   public List<Resource> getChildren(Long resourceId)
/*    */   {
/* 16 */     QueryService queryService = (QueryService)getBean("queryService");
/* 17 */     return queryService.retrieveResourceByParent(resourceId);
/*    */   }
/*    */ 
/*    */   public boolean checkResourceNode(Long resourceId) {
/* 21 */     QueryService queryService = (QueryService)getBean("queryService");
/* 22 */     Resource resource = queryService.getResource(resourceId);
/*    */ 
/* 26 */     return (resource != null) && (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId()));
/*    */   }
/*    */ 
/*    */   public Long checkTypeId(Long resourceId)
/*    */   {
/* 33 */     QueryService queryService = (QueryService)getBean("queryService");
/* 34 */     Resource resource = queryService.getResource(resourceId);
/* 35 */     return resource.getTypeId();
/*    */   }
/*    */ 
/*    */   public TreeNode getTreeNodeDetails(Long resourceId) {
/* 39 */     QueryService queryService = (QueryService)getBean("queryService");
/* 40 */     Resource currentResource = queryService.getResource(resourceId);
/* 41 */     List children = queryService.retrieveResourceByParent(resourceId);
/*    */ 
/* 43 */     TreeNode current = new TreeNode();
/* 44 */     current.setId(currentResource.getId() + "");
/* 45 */     current.setName(currentResource.getAlias());
/* 46 */     current.setTypeId(currentResource.getTypeId());
/* 47 */     for (Iterator it = children.iterator(); it.hasNext(); ) {
/* 48 */       Resource childResource = (Resource)it.next();
/* 49 */       TreeNode child = new TreeNode();
/* 50 */       child.setId(childResource.getId() + "");
/* 51 */       child.setName(childResource.getAlias());
/* 52 */       child.setTypeId(childResource.getTypeId());
/* 53 */       current.addChild(child);
/*    */     }
/* 55 */     return current;
/*    */   }
/*    */ 
/*    */   public TreeNode retrieveChildren(Long resourceId, Long typeId)
/*    */   {
/* 60 */     QueryService queryService = (QueryService)getBean("queryService");
/* 61 */     PermissionService permissionService = (PermissionService)getBean("permissionService");
/* 62 */     Resource currentResource = queryService.getResource(resourceId);
/* 63 */     List children = queryService.retrieveResourceByParent(resourceId);
/* 64 */     TreeNode current = new TreeNode();
/* 65 */     current.setId(currentResource.getId() + "");
/* 66 */     current.setName(currentResource.getAlias());
/* 67 */     current.setTypeId(currentResource.getTypeId());
/* 68 */     for (Iterator it = children.iterator(); it.hasNext(); ) {
/* 69 */       Resource childResource = (Resource)it.next();
/* 70 */       if ((CommonConstants.TYPE.RESOURCE.equals(childResource.getTypeId())) || ((typeId.equals(childResource.getTypeId())) && (permissionService.checkReadPermission(childResource, getClientSession()))))
/*    */       {
/* 74 */         TreeNode child = new TreeNode();
/* 75 */         child.setId(childResource.getId() + "");
/*    */ 
/* 77 */         child.setName(childResource.getAlias());
/* 78 */         child.setTypeId(childResource.getTypeId());
/* 79 */         current.addChild(child);
/*    */       }
/*    */     }
/* 82 */     return current;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.ajaxs.QueryServiceAjax
 * JD-Core Version:    0.6.0
 */