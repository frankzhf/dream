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
/*    */ public class ViewInformDetailsAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 26 */     CmsForm _form = (CmsForm)form;
/* 27 */     Resource paramResource = _form.getResource();
/* 28 */     Long id = paramResource.getId();
/* 29 */     if ((id == null) || (id.longValue() == 0L)) {
/* 30 */       Long parentId = paramResource.getParentId();
/* 31 */       id = parentId;
/*    */     }
/* 33 */     QueryService queryService = (QueryService)getService(request, "queryService");
/* 34 */     PermissionService permissionService = (PermissionService)getBean("permissionService");
/* 35 */     Resource resource = queryService.getResource(id);
/* 36 */     if (!permissionService.checkReadPermission(resource, getClientSession()))
/*    */     {
/* 38 */       request.setAttribute("checkPermission", "failure");
/*    */     }
/*    */     else
/*    */     {
/* 42 */       List list = null;
/* 43 */       BaseEntity content = null;
/* 44 */       if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/* 45 */         this.log.debug("Content is Resource ->" + resource.getId());
/* 46 */         list = queryService.retrieveResourceByParent(resource.getId());
/* 47 */         list = permissionService.filterList(list, getClientSession());
/*    */       } else {
/* 49 */         content = queryService.getBo(resource.getId());
/* 50 */         this.log.debug("Content Class ->" + content.getClass().getName());
/*    */       }
/* 52 */       permissionService.fillForm(resource, _form);
/* 53 */       _form.setResource(resource);
/* 54 */       _form.setListRessource(list);
/*    */ 
/* 56 */       request.setAttribute("resource", resource);
/* 57 */       request.setAttribute("mode", "view");
/* 58 */       request.setAttribute("content", content);
/* 59 */       request.setAttribute("listResource", list);
/* 60 */       this.log.debug(_form.getResource());
/*    */     }
/* 62 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.ViewInformDetailsAction
 * JD-Core Version:    0.6.0
 */