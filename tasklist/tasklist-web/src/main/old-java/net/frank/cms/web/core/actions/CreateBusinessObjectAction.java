/*    */ package net.frank.cms.web.core.actions;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.Account;
/*    */ import net.frank.framework.bo.BusinessObject;
/*    */ import net.frank.framework.bo.Group;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.PermissionService;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class CreateBusinessObjectAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 23 */     CmsForm _form = (CmsForm)form;
/* 24 */     Resource resource = _form.getResource();
/* 25 */     Long parentId = resource.getParentId();
/* 26 */     Long typeId = resource.getTypeId();
/* 27 */     resource.setActive(Boolean.TRUE);
/* 28 */     QueryService queryService = (QueryService)getService(request, "queryService");
/*    */ 
/* 31 */     PermissionService permissionService = (PermissionService)getBean("permissionService");
/* 32 */     if (!permissionService.checkWritePermission(queryService.getResource(parentId), getClientSession()))
/*    */     {
/* 34 */       request.setAttribute("checkPermission", "failure");
/*    */     }
/*    */     else
/*    */     {
/* 39 */       request.setAttribute("checkPermission", "success");
/*    */ 
/* 42 */       String umask = getClientSession().getAccount().getUmask();
/* 43 */       Integer currentUserPermission = Integer.decode(umask.substring(0, 1));
/*    */ 
/* 45 */       Integer currentGroupPermission = Integer.decode(umask.substring(1, 2));
/*    */ 
/* 47 */       Integer otherPermission = Integer.decode(umask.substring(2, 3));
/* 48 */       resource.setCurrentAccountPermission(currentUserPermission);
/* 49 */       resource.setCurrentGroupPermission(currentGroupPermission);
/* 50 */       resource.setOthersPermission(otherPermission);
/* 51 */       permissionService.fillForm(resource, _form);
/* 52 */       BusinessObject content = null;
/* 53 */       if (CommonConstants.TYPE.RESOURCE.equals(typeId))
/* 54 */         content = null;
/*    */       else {
/* 56 */         content = (BusinessObject)_form.getContentMap().get(typeId);
/*    */       }
/* 58 */       resource.setOwnResourceId(getClientSession().getAccount().getResource().getId());
/*    */ 
/* 60 */       resource.setOwnGroupResourceId(getClientSession().getCurrentGroup().getResource().getId());
/*    */ 
/* 62 */       if (content != null) {
/* 63 */         content.setResource(resource);
/*    */       }
/* 65 */       _form.setResource(resource);
/* 66 */       _form.setListRessource(null);
/* 67 */       request.setAttribute("resource", resource);
/* 68 */       request.setAttribute("mode", "edit");
/* 69 */       request.setAttribute("content", content);
/* 70 */       request.setAttribute("listResource", null);
/*    */     }
/* 72 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.CreateBusinessObjectAction
 * JD-Core Version:    0.6.0
 */