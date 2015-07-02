/*    */ package net.frank.cms.web.common.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.cms.web.common.forms.DialogForm;
/*    */ import net.frank.framework.bo.BaseEntity;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DialogEditorAction extends BaseAction
/*    */ {
/* 21 */   private static final Long IGNORE_ID = new Long(0L);
/*    */ 
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 26 */     DialogForm dialogForm = (DialogForm)form;
/* 27 */     Long resourceId = dialogForm.getResourceId();
/* 28 */     String elementId = dialogForm.getElementId();
/* 29 */     String content = "";
/* 30 */     if ((resourceId != null) && (!IGNORE_ID.equals(resourceId))) {
/* 31 */       QueryService queryService = (QueryService)getService(request, "queryService");
/*    */ 
/* 33 */       Resource resource = queryService.getResource(resourceId);
/* 34 */       BaseEntity baseEnitity = queryService.getBo(resource.getId());
/*    */ 
/* 36 */       String _elementId = elementId.substring(elementId.indexOf(".clobString(") + 12, elementId.length() - 1);
/* 37 */       this.log.debug("_elementId -> " + _elementId);
/* 38 */       content = baseEnitity.getClobString(_elementId);
/*    */     }
/* 40 */     request.setAttribute("content", content);
/* 41 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.actions.DialogEditorAction
 * JD-Core Version:    0.6.0
 */