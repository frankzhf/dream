/*    */ package net.frank.cms.web.common.actions;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.cms.web.common.forms.DialogForm;
/*    */ import net.frank.framework.bo.BaseEntity;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.bo.Type;
/*    */ import net.frank.framework.service.CacheService;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class DialogSelectorAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 32 */     DialogForm dialogForm = (DialogForm)form;
/*    */ 
/* 34 */     CacheService cacheService = (CacheService)getBean("cacheService");
/* 35 */     Map typeContent = cacheService.getTypeContent();
/* 36 */     Map typeClassMap = new HashMap();
/* 37 */     List typeContentList = new ArrayList();
/* 38 */     for (Iterator it = typeContent.keySet().iterator(); it.hasNext(); ) {
/* 39 */       Long resourceId = (Long)it.next();
/* 40 */       typeContentList.add(typeContent.get(resourceId));
/* 41 */       typeClassMap.put(resourceId, (BaseEntity)Class.forName(((Type)typeContent.get(resourceId)).getEntityClassName()).newInstance());
/*    */     }
/*    */ 
/* 47 */     request.setAttribute("typeContentList", typeContentList);
/* 48 */     request.setAttribute("typeClassMap", typeClassMap);
/*    */ 
/* 50 */     String fieldName = dialogForm.getFieldName();
/* 51 */     String fieldValue = dialogForm.getFieldValue();
/* 52 */     this.log.debug("fieldName ->" + fieldName);
/* 53 */     this.log.debug("fieldValue ->" + fieldValue);
/* 54 */     QueryService queryService = (QueryService)getService(request, "queryService");
/*    */ 
/* 57 */     request.setAttribute("fieldName", fieldName);
/* 58 */     request.setAttribute("fieldValue", fieldValue);
/* 59 */     String typeId = null;
/* 60 */     if ((fieldValue != null) && (!"".equals(fieldValue)))
/*    */     {
/* 62 */       Resource resource = queryService.getResource(Long.decode(fieldValue));
/*    */ 
/* 64 */       typeId = resource.getTypeId() + "";
/* 65 */       String selectedLinkList = queryService.getNodePath(resource);
/* 66 */       this.log.debug("selectedLinkList ->" + selectedLinkList);
/* 67 */       request.setAttribute("selectedLinkList", selectedLinkList);
/*    */     } else {
/* 69 */       int begIndex = fieldName.indexOf("$") + 1;
/*    */ 
/* 71 */       int endIndex = fieldName.indexOf(".longString(id)");
/*    */ 
/* 73 */       typeId = fieldName.substring(begIndex, endIndex);
/*    */     }
/* 75 */     this.log.debug("Type Id -> " + typeId);
/* 76 */     request.setAttribute("typeId", typeId);
/* 77 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.common.actions.DialogSelectorAction
 * JD-Core Version:    0.6.0
 */