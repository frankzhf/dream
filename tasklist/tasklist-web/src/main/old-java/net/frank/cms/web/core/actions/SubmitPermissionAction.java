/*     */ package net.frank.cms.web.core.actions;
/*     */ 
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.frank.cms.web.core.forms.PermissionForm;
/*     */ import net.frank.commons.CommonConstants.TYPE;
/*     */ import net.frank.commons.util.PermissionUtil;
/*     */ import net.frank.framework.bo.Resource;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.service.ResourceFilter;
/*     */ import net.frank.framework.service.ResourceService;
/*     */ import net.frank.framework.struts.action.BaseAction;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.action.ActionMessage;
/*     */ import org.apache.struts.action.ActionMessages;
/*     */ 
/*     */ public class SubmitPermissionAction extends BaseAction
/*     */ {
/*     */   private static final String FAILURE_MESSAGE = "core.permission.errors.resource.path.invalid";
/*     */   private static final String SUCCESS_MESSAGE = "common.operate.success";
/*     */ 
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  31 */     PermissionForm _form = (PermissionForm)form;
/*  32 */     QueryService queryService = (QueryService)getBean("queryService");
/*  33 */     ResourceService resourceService = (ResourceService)getBean("resourceService");
/*  34 */     String contentFullPath = _form.getResourceFullPath();
/*  35 */     Resource resource = queryService.getResourceAsPath(contentFullPath);
/*  36 */     ActionMessages actionMessages = new ActionMessages();
/*  37 */     if (resource != null) {
/*  38 */       Boolean[] ownOption = new Boolean[3];
/*  39 */       ownOption[0] = _form.getPermission("0");
/*  40 */       ownOption[1] = _form.getPermission("1");
/*  41 */       ownOption[2] = _form.getPermission("2");
/*  42 */       Boolean[] groupOption = new Boolean[3];
/*  43 */       groupOption[0] = _form.getPermission("3");
/*  44 */       groupOption[1] = _form.getPermission("4");
/*  45 */       groupOption[2] = _form.getPermission("5");
/*  46 */       Boolean[] otherOption = new Boolean[3];
/*  47 */       otherOption[0] = _form.getPermission("6");
/*  48 */       otherOption[1] = _form.getPermission("7");
/*  49 */       otherOption[2] = _form.getPermission("8");
/*  50 */       Boolean chagePermissionFlag = _form.getChagePermissionFlag();
/*  51 */       Integer ownPermission = PermissionUtil.booleanToInteger(ownOption);
/*     */ 
/*  53 */       Integer groupPermission = PermissionUtil.booleanToInteger(groupOption);
/*     */ 
/*  55 */       Integer otherPermission = PermissionUtil.booleanToInteger(otherOption);
/*     */ 
/*  57 */       Boolean chageOwnFlag = _form.getChageOwnFlag();
/*  58 */       Long ownId = _form.getOwnResourceId();
/*  59 */       Boolean chageGroupFlag = _form.getChageGroupFlag();
/*  60 */       Long groupId = _form.getGroupResourceId();
/*  61 */       Boolean recursive = _form.getRecursive();
/*  62 */       if (!recursive.booleanValue()) {
/*  63 */         if (chagePermissionFlag.booleanValue()) {
/*  64 */           resource.setCurrentAccountPermission(ownPermission);
/*  65 */           resource.setCurrentGroupPermission(groupPermission);
/*  66 */           resource.setOthersPermission(otherPermission);
/*     */         }
/*  68 */         if (chageOwnFlag.booleanValue()) {
/*  69 */           resource.setOwnResourceId(ownId);
/*     */         }
/*  71 */         if (chageGroupFlag.booleanValue()) {
/*  72 */           resource.setOwnGroupResourceId(groupId);
/*     */         }
/*  74 */         resourceService.saveOrUpdateResource(resource, getClientSession());
/*     */       }
/*  77 */       else if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/*  78 */         resource = queryService.getResourceWithRecursive(resource);
/*  79 */         resourceService.saveResourceWithRecursive(resource, getClientSession(), new ResourceFilter(chagePermissionFlag, ownPermission, groupPermission, otherPermission, chageOwnFlag, ownId, chageGroupFlag, groupId)
/*     */         {
/*     */           public boolean filter(Resource currResoruce) {
/*  82 */             if (this.val$chagePermissionFlag.booleanValue()) {
/*  83 */               currResoruce.setCurrentAccountPermission(this.val$ownPermission);
/*  84 */               currResoruce.setCurrentGroupPermission(this.val$groupPermission);
/*  85 */               currResoruce.setOthersPermission(this.val$otherPermission);
/*     */             }
/*  87 */             if (this.val$chageOwnFlag.booleanValue()) {
/*  88 */               currResoruce.setOwnResourceId(this.val$ownId);
/*     */             }
/*  90 */             if (this.val$chageGroupFlag.booleanValue()) {
/*  91 */               currResoruce.setOwnGroupResourceId(this.val$groupId);
/*     */             }
/*  93 */             return Boolean.TRUE.booleanValue();
/*     */           } } );
/*     */       } else {
/*  97 */         if (chagePermissionFlag.booleanValue()) {
/*  98 */           resource.setCurrentAccountPermission(ownPermission);
/*  99 */           resource.setCurrentGroupPermission(groupPermission);
/* 100 */           resource.setOthersPermission(otherPermission);
/*     */         }
/* 102 */         if (chageOwnFlag.booleanValue()) {
/* 103 */           resource.setOwnResourceId(ownId);
/*     */         }
/* 105 */         if (chageGroupFlag.booleanValue()) {
/* 106 */           resource.setOwnGroupResourceId(groupId);
/*     */         }
/* 108 */         resourceService.saveOrUpdateResource(resource, getClientSession());
/*     */       }
/*     */ 
/* 112 */       actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("common.operate.success"));
/*     */ 
/* 115 */       addMessages(request, actionMessages);
/* 116 */       return mapping.findForward("success");
/*     */     }
/* 118 */     actionMessages.add("", new ActionMessage("core.permission.errors.resource.path.invalid", contentFullPath));
/*     */ 
/* 122 */     addErrors(request, actionMessages);
/* 123 */     return mapping.findForward("failure");
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.SubmitPermissionAction
 * JD-Core Version:    0.6.0
 */