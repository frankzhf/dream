/*    */ package net.frank.cms.web.task.actions;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.cms.web.task.forms.ProcessTokenForm;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.bo.Task;
/*    */ import net.frank.framework.bo.TaskToken;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class ProcessTaskTokenAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 23 */     ProcessTokenForm _form = (ProcessTokenForm)form;
/* 24 */     QueryService queryService = (QueryService)getBean("queryService");
/* 25 */     Long resourceId = _form.getResourceId();
/* 26 */     TaskToken taskToken = (TaskToken)queryService.getBo(resourceId);
/* 27 */     Resource taskResource = taskToken.getTask$15();
/* 28 */     Task task = (Task)queryService.getBo(taskResource.getId());
/* 29 */     request.setAttribute("task", task);
/* 30 */     request.setAttribute("taskToken", taskToken);
/* 31 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.actions.ProcessTaskTokenAction
 * JD-Core Version:    0.6.0
 */