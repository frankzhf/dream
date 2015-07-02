/*    */ package net.frank.cms.web.core.actions;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.BaseEntity;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.PermissionService;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class EditInformDetailsAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 25 */     CmsForm _form = (CmsForm)form;
/*    */ 
/* 27 */     QueryService queryService = (QueryService)getService(request, "queryService");
/*    */ 
/* 29 */     Resource resource = queryService.getResource(_form.getResource().getId());
/*    */ 
/* 31 */     PermissionService permissionService = (PermissionService)getBean("permissionService");
/* 32 */     if (!permissionService.checkWritePermission(resource, getClientSession()))
/*    */     {
/* 34 */       request.setAttribute("checkPermission", "failure");
/*    */     }
/*    */     else
/*    */     {
/* 38 */       List list = null;
/* 39 */       BaseEntity content = null;
/* 40 */       if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/* 41 */         this.log.debug("Content is Resource ->" + resource.getId());
/* 42 */         list = queryService.retrieveResourceByParent(resource.getId());
/*    */       } else {
/* 44 */         content = queryService.getBo(resource.getId());
/* 45 */         this.log.debug("Content Class ->" + content.getClass().getName());
/*    */       }
/* 47 */       permissionService.fillForm(resource, _form);
/* 48 */       _form.setResource(resource);
/* 49 */       _form.setListRessource(list);
/* 50 */       request.setAttribute("resource", resource);
/* 51 */       request.setAttribute("mode", "edit");
/*    */ 
/* 54 */       request.setAttribute("content", content);
/* 55 */       request.setAttribute("listResource", list);
/* 56 */       this.log.debug(_form.getResource());
/*    */     }
/* 58 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.EditInformDetailsAction
 * JD-Core Version:    0.6.0
 */