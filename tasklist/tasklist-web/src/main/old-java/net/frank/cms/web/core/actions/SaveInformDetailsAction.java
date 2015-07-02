/*     */ package net.frank.cms.web.core.actions;
/*     */ 
/*     */ import java.beans.BeanInfo;
/*     */ import java.beans.IntrospectionException;
/*     */ import java.beans.Introspector;
/*     */ import java.beans.PropertyDescriptor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.frank.commons.CommonConstants.TYPE;
/*     */ import net.frank.framework.bo.BusinessObject;
/*     */ import net.frank.framework.bo.Resource;
/*     */ import net.frank.framework.service.PermissionService;
/*     */ import net.frank.framework.service.QueryService;
/*     */ import net.frank.framework.service.ResourceService;
/*     */ import net.frank.framework.struts.action.BaseAction;
/*     */ import net.frank.framework.struts.form.CmsForm;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ import org.apache.struts.action.ActionForward;
/*     */ import org.apache.struts.action.ActionMapping;
/*     */ import org.apache.struts.action.ActionMessage;
/*     */ import org.apache.struts.action.ActionMessages;
/*     */ 
/*     */ public class SaveInformDetailsAction extends BaseAction
/*     */ {
/*     */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*     */     throws Exception
/*     */   {
/*  35 */     CmsForm _form = (CmsForm)form;
/*  36 */     Resource resource = _form.getResource();
/*  37 */     List list = null;
/*  38 */     ResourceService resourceService = (ResourceService)getService(request, "resourceService");
/*     */ 
/*  40 */     QueryService queryService = (QueryService)getService(request, "queryService");
/*     */ 
/*  42 */     if ((resource.getId() == null) && (queryService.getResource(resource.getParentId(), resource.getAlias()) != null))
/*     */     {
/*  45 */       ActionMessage actionMessage = new ActionMessage("errors.detail", "Resource's alias can't same");
/*     */ 
/*  47 */       ActionMessages actionMessages = new ActionMessages();
/*  48 */       actionMessages.add("", actionMessage);
/*  49 */       addErrors(request, actionMessages);
/*  50 */       request.setAttribute("resource", resource);
/*  51 */       return mapping.findForward("failure");
/*     */     }
/*     */ 
/*  54 */     PermissionService permissionService = (PermissionService)getBean("permissionService");
/*  55 */     permissionService.fillResource(_form, resource);
/*  56 */     if (CommonConstants.TYPE.RESOURCE.equals(resource.getTypeId())) {
/*  57 */       resourceService.saveOrUpdateResource(resource, getClientSession());
/*  58 */       this.log.debug("Content is Resource ->" + resource.getId());
/*     */     } else {
/*  60 */       BusinessObject businessObject = (BusinessObject)_form.getContentMap().get(resource.getTypeId());
/*     */ 
/*  62 */       if (!_form.getUpdateFilesMap().isEmpty()) {
/*  63 */         BusinessObject existsObject = null;
/*  64 */         if (resource.getId() != null) {
/*  65 */           existsObject = queryService.getBo(resource.getId());
/*     */         }
/*  67 */         Iterator it = _form.getUpdateFilesMap().keySet().iterator();
/*  68 */         while (it.hasNext()) {
/*  69 */           String key = (String)it.next();
/*  70 */           businessObject.setBlobString(key, existsObject);
/*     */         }
/*     */       }
/*  73 */       this.log.debug("Input Object class ->" + businessObject.getClass().getName());
/*     */ 
/*  75 */       if (!businessObject.getErrorFieldsValue().isEmpty()) {
/*  76 */         ActionMessages actionMessages = new ActionMessages();
/*  77 */         Iterator it = businessObject.getErrorFieldsValue().keySet().iterator();
/*  78 */         while (it.hasNext()) {
/*  79 */           String key = (String)it.next();
/*  80 */           String error = (String)businessObject.getErrorFieldsValue().get(key);
/*     */ 
/*  82 */           ActionMessage actionMessage = new ActionMessage("errors.detail", error);
/*     */ 
/*  84 */           actionMessages.add("", actionMessage);
/*     */         }
/*     */ 
/*  87 */         addErrors(request, actionMessages);
/*  88 */         request.setAttribute("resource", resource);
/*  89 */         return mapping.findForward("failure");
/*     */       }
/*     */       try {
/*  92 */         Class type = businessObject.getClass();
/*  93 */         BeanInfo beanInfo = Introspector.getBeanInfo(type);
/*  94 */         PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
/*     */ 
/*  96 */         for (int i = 0; i < propertyDescriptors.length; i++) {
/*  97 */           PropertyDescriptor descriptor = propertyDescriptors[i];
/*  98 */           String propertyName = descriptor.getName();
/*  99 */           if ((propertyName.equals("class")) || (propertyName.equals("resource")))
/*     */             continue;
/* 101 */           Method readMethod = descriptor.getReadMethod();
/* 102 */           Object result = readMethod.invoke(businessObject, new Object[0]);
/*     */ 
/* 104 */           if ((readMethod.getReturnType().isInterface()) || ((!readMethod.getReturnType().getSuperclass().getName().equals(BusinessObject.class.getName())) && (!readMethod.getReturnType().getName().equals(Resource.class.getName())))) {
/*     */             continue;
/*     */           }
/* 107 */           Resource r = (Resource)result;
/* 108 */           Method writeMethod = descriptor.getWriteMethod();
/* 109 */           this.log.debug("resourceId ->" + r.getId());
/* 110 */           if (r.getId() != null) {
/* 111 */             r = queryService.getResource(r.getId());
/* 112 */             writeMethod.invoke(businessObject, new Object[] { r });
/*     */           }
/*     */           else {
/* 115 */             writeMethod.invoke(businessObject, new Object[] { null });
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */       catch (IntrospectionException e)
/*     */       {
/* 122 */         throw new Exception(e);
/*     */       } catch (IllegalAccessException e) {
/* 124 */         throw new Exception(e);
/*     */       } catch (InvocationTargetException e) {
/* 126 */         throw new Exception(e);
/*     */       }
/* 128 */       businessObject.setResource(resource);
/* 129 */       resourceService.saveOrUpdateBo(businessObject, getClientSession());
/*     */ 
/* 131 */       _form.setResource(resource);
/* 132 */       _form.setListRessource(list);
/* 133 */       this.log.debug(_form.getResource());
/*     */     }
/* 135 */     request.setAttribute("resource", resource);
/* 136 */     return mapping.findForward("success");
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.SaveInformDetailsAction
 * JD-Core Version:    0.6.0
 */