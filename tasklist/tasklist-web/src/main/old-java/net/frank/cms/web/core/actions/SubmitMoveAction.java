/*     */ package net.frank.cms.web.core.actions;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.frank.cms.web.core.forms.MoveForm;
/*     */ import net.frank.commons.CommonConstants.TYPE;
/*     */ import net.frank.framework.bo.BusinessObject;
/*     */ import net.frank.framework.bo.Resource;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.service.ResourceService;
/*     */ import net.frank.framework.struts.action.BaseAction;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.action.ActionMessage;
/*     */ import org.apache.struts.action.ActionMessages;
/*     */ 
/*     */ public class SubmitMoveAction extends BaseAction
/*     */ {
/*     */   private static final String FAILURE_MESSAGE_0 = "core.move.errors.from.path.invalid";
/*     */   private static final String FAILURE_MESSAGE_1 = "core.move.errors.to.path.invalid";
/*     */   private static final String FAILURE_MESSAGE_2 = "core.move.errors.subfolder";
/*     */   private static final String FAILURE_MESSAGE_3 = "core.move.errors.to.path.not.folder";
/*     */   private static final String SUCCESS_MESSAGE = "common.operate.success";
/*     */ 
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  36 */     MoveForm _form = (MoveForm)form;
/*  37 */     QueryService queryService = (QueryService)getBean("queryService");
/*  38 */     ResourceService resourceService = (ResourceService)getBean("resourceService");
/*  39 */     ActionMessages actionMessages = new ActionMessages();
/*  40 */     String strFromPath = _form.getFromPath();
/*  41 */     Resource fromResource = queryService.getResourceAsPath(strFromPath);
/*  42 */     String strToPath = _form.getToPath();
/*  43 */     Resource toResource = queryService.getResourceAsPath(strToPath);
/*  44 */     Boolean clone = _form.getClone();
/*  45 */     Boolean recursive = _form.getRecursive();
/*     */ 
/*  47 */     Boolean validation = Boolean.TRUE;
/*  48 */     if (fromResource == null) {
/*  49 */       actionMessages.add("", new ActionMessage("core.move.errors.from.path.invalid", strFromPath));
/*     */ 
/*  51 */       validation = Boolean.FALSE;
/*     */     }
/*  53 */     if (toResource == null) {
/*  54 */       actionMessages.add("", new ActionMessage("core.move.errors.to.path.invalid", strToPath));
/*     */ 
/*  56 */       validation = Boolean.FALSE;
/*     */     }
/*     */ 
/*  59 */     if (validation.booleanValue()) {
/*  60 */       if (!CommonConstants.TYPE.RESOURCE.equals(toResource.getTypeId()))
/*     */       {
/*  62 */         actionMessages.add("", new ActionMessage("core.move.errors.to.path.not.folder", strToPath));
/*     */ 
/*  64 */         validation = Boolean.FALSE;
/*     */       }
/*  66 */       if (strToPath.indexOf(strFromPath) == 0) {
/*  67 */         actionMessages.add("", new ActionMessage("core.move.errors.subfolder", strFromPath, strToPath));
/*     */ 
/*  70 */         validation = Boolean.FALSE;
/*     */       }
/*     */     }
/*  73 */     if (validation.booleanValue()) {
/*  74 */       if (!clone.booleanValue()) {
/*  75 */         fromResource.setParentId(toResource.getId());
/*  76 */         resourceService.saveOrUpdateResource(fromResource, getClientSession());
/*     */       }
/*  79 */       else if (recursive.booleanValue()) {
/*  80 */         resourceService.cloneResourceWithRecursive(fromResource, toResource, getClientSession());
/*     */       }
/*     */       else {
/*  83 */         BusinessObject bo = null;
/*  84 */         BusinessObject _bo = null;
/*  85 */         Resource _clone = fromResource.clone();
/*  86 */         _clone.setId(null);
/*  87 */         if (!CommonConstants.TYPE.RESOURCE.equals(fromResource.getTypeId()))
/*     */         {
/*  89 */           bo = queryService.getBo(fromResource);
/*  90 */           _bo = bo.clone();
/*  91 */           _bo.setId(null);
/*  92 */           _bo.setResource(_clone);
/*  93 */           resourceService.saveOrUpdateBo(_bo, getClientSession());
/*     */         } else {
/*  95 */           _clone.setParentId(toResource.getId());
/*  96 */           resourceService.saveOrUpdateResource(_clone, getClientSession());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 101 */       actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("common.operate.success"));
/*     */ 
/* 103 */       addMessages(request, actionMessages);
/* 104 */       return mapping.findForward("success");
/*     */     }
/* 106 */     addErrors(request, actionMessages);
/* 107 */     return mapping.findForward("failure");
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.SubmitMoveAction
 * JD-Core Version:    0.6.0
 */