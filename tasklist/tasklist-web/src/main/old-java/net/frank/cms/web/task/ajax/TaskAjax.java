/*     */ package net.frank.cms.web.task.ajax;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.frank.framework.bo.Account;
/*     */ import net.frank.framework.bo.Account2Group;
/*     */ import net.frank.framework.bo.Group;
/*     */ import net.frank.framework.bo.Resource;
/*     */ import net.frank.framework.bo.Task;
/*     */ import net.frank.framework.bo.TaskToken;
/*     */ import net.frank.framework.bo.Unit;
/*     */ import net.frank.framework.dao.Account2GroupDao;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.task.TaskAction;
/*     */ import net.frank.framework.web.ajax.BaseAjax;
/*     */ 
/*     */ public class TaskAjax extends BaseAjax
/*     */ {
/*     */   public int openTask(Long resourceId)
/*     */   {
/*     */     try
/*     */     {
/*  31 */       QueryService queryService = (QueryService)getBean("queryService");
/*  32 */       TaskAction taskAction = (TaskAction)getBean("taskAction");
/*  33 */       Task task = (Task)queryService.getBo(resourceId);
/*  34 */       if (!Task.STATUS_DRAFT.equals(task.getStatus())) {
/*  35 */         return -2;
/*     */       }
/*  37 */       taskAction.openTask(task, getClientSession());
/*     */     }
/*     */     catch (Exception e) {
/*  40 */       return -1;
/*     */     }
/*  42 */     return 0;
/*     */   }
/*     */ 
/*     */   public int assignTask(Long resourceId, Long accountResourceId)
/*     */   {
/*     */     try
/*     */     {
/*  56 */       QueryService queryService = (QueryService)getBean("queryService");
/*  57 */       TaskAction taskAction = (TaskAction)getBean("taskAction");
/*  58 */       TaskToken taskToken = (TaskToken)queryService.getBo(resourceId);
/*  59 */       Account next = (Account)queryService.getBo(accountResourceId);
/*  60 */       Task task = (Task)queryService.getBo(taskToken.getTask$15().getId());
/*  61 */       Unit unit = (Unit)queryService.getBo(task.getUnit$14().getId());
/*  62 */       Group group = (Group)queryService.getBo(unit.getGroup$6().getId());
/*     */ 
/*  64 */       Account2GroupDao account2GroupDao = (Account2GroupDao)getBean("account2GroupDao");
/*  65 */       List listGroups = account2GroupDao.listGroupByAccount(next);
/*  66 */       boolean hasGroup = false;
/*  67 */       for (Iterator it = listGroups.iterator(); it.hasNext(); ) {
/*  68 */         Account2Group curr = (Account2Group)it.next();
/*  69 */         if (curr.getGroup$6().getId().equals(group.getResource().getId())) {
/*  70 */           hasGroup = true;
/*  71 */           break;
/*     */         }
/*     */       }
/*  74 */       if (!hasGroup) {
/*  75 */         return -3;
/*     */       }
/*  77 */       if (!Task.STATUS_OPEN.equals(task.getStatus())) {
/*  78 */         return -2;
/*     */       }
/*  80 */       taskAction.assignTask(taskToken, next, getClientSession());
/*     */     } catch (Exception e) {
/*  82 */       return -1;
/*     */     }
/*  84 */     return 0;
/*     */   }
/*     */ 
/*     */   public int closeTask(Long resourceId) {
/*     */     try {
/*  89 */       QueryService queryService = (QueryService)getBean("queryService");
/*  90 */       TaskAction taskAction = (TaskAction)getBean("taskAction");
/*  91 */       TaskToken taskToken = (TaskToken)queryService.getBo(resourceId);
/*  92 */       Task task = (Task)queryService.getBo(taskToken.getTask$15().getId());
/*  93 */       if (!Task.STATUS_OPEN.equals(task.getStatus())) {
/*  94 */         return -2;
/*     */       }
/*  96 */       taskAction.closeTask(taskToken, getClientSession());
/*     */     } catch (Exception e) {
/*  98 */       return -1;
/*     */     }
/* 100 */     return 0;
/*     */   }
/*     */ 
/*     */   public int archiveTask(Long resourceId)
/*     */   {
/*     */     try {
/* 106 */       QueryService queryService = (QueryService)getBean("queryService");
/* 107 */       TaskAction taskAction = (TaskAction)getBean("taskAction");
/* 108 */       Task task = (Task)queryService.getBo(resourceId);
/* 109 */       if (!Task.STATUS_CLOSE.equals(task.getStatus())) {
/* 110 */         return -2;
/*     */       }
/* 112 */       taskAction.archiveTask(task, getClientSession());
/*     */     } catch (Exception e) {
/* 114 */       return -1;
/*     */     }
/* 116 */     return 0;
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.ajax.TaskAjax
 * JD-Core Version:    0.6.0
 */