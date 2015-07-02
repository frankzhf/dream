/*    */ package net.frank.cms.web.tinymce.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.cms.web.common.forms.DialogForm;
/*    */ import net.frank.cms.web.core.actions.NavigationAction;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class ImageTreeAction extends NavigationAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 22 */     request.setAttribute("typeId", CommonConstants.TYPE.IMAGE);
/* 23 */     DialogForm dialogForm = (DialogForm)form;
/* 24 */     String fieldValue = dialogForm.getFieldValue();
/* 25 */     this.log.debug("fieldValue ->" + fieldValue);
/* 26 */     QueryService queryService = (QueryService)getService(request, "queryService");
/*    */ 
/* 28 */     String selectedLinkList = "";
/* 29 */     if ((fieldValue != null) && (!"".equals(fieldValue))) {
/* 30 */       Resource resource = queryService.getResource(Long.decode(fieldValue));
/*    */ 
/* 32 */       selectedLinkList = queryService.getNodePath(resource);
/*    */     }
/* 34 */     this.log.debug("selectedLinkList ->" + selectedLinkList);
/* 35 */     request.setAttribute("selectedLinkList", selectedLinkList);
/* 36 */     return super.execute(mapping, form, request, response);
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.tinymce.actions.ImageTreeAction
 * JD-Core Version:    0.6.0
 */