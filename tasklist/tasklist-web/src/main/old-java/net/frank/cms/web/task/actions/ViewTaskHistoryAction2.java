/*    */ package net.frank.cms.web.task.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.bo.Task;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class ViewTaskHistoryAction2 extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 22 */     CmsForm _form = (CmsForm)form;
/* 23 */     QueryService queryService = (QueryService)getBean("queryService");
/* 24 */     Resource resource = _form.getResource();
/* 25 */     Task task = (Task)queryService.getBo(resource.getId());
/* 26 */     request.setAttribute("task", task);
/* 27 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.actions.ViewTaskHistoryAction2
 * JD-Core Version:    0.6.0
 */