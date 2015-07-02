/*    */ package net.frank.cms.web.task.actions;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.bo.Task;
/*    */ import net.frank.framework.service.ResourceService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ import net.frank.framework.task.TaskAction;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class SubmitCreateDraftAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 27 */     TaskAction taskActionService = (TaskAction)getBean("taskAction");
/* 28 */     ResourceService resourceService = (ResourceService)getBean("resourceService");
/* 29 */     CmsForm _form = (CmsForm)form;
/* 30 */     Resource resource = _form.getResource();
/* 31 */     Task task = (Task)_form.getContentMap().get(resource.getTypeId());
/* 32 */     task.setResource(resource);
/* 33 */     this.log.debug("Task Summary:" + task.getTaskSummary());
/* 34 */     this.log.debug("Description :" + new String(task.getDescription()));
/* 35 */     this.log.debug("Unit :" + task.getUnit$14().getId());
/* 36 */     if (resource.getId() == null) {
/* 37 */       taskActionService.createDraft(task, getClientSession());
/*    */     } else {
/* 39 */       StringBuffer sb = new StringBuffer(256);
/* 40 */       sb.append(task.getTaskSummary()).append(" - Draft");
/* 41 */       resource.setAlias(sb.toString());
/* 42 */       task.setResource(resource);
/* 43 */       if (task.getUnit$14().getId() == null) {
/* 44 */         task.setUnit$14(null);
/*    */       }
/* 46 */       if (task.getContext$3().getId() == null) {
/* 47 */         task.setContext$3(null);
/*    */       }
/* 49 */       if (task.getRefTask$15().getId() == null) {
/* 50 */         task.setRefTask$15(null);
/*    */       }
/* 52 */       if (task.getParentTask$15().getId() == null) {
/* 53 */         task.setParentTask$15(null);
/*    */       }
/* 55 */       resourceService.saveOrUpdateBo(task, getClientSession());
/*    */     }
/* 57 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.actions.SubmitCreateDraftAction
 * JD-Core Version:    0.6.0
 */