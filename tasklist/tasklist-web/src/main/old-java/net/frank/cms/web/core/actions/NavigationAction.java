/*    */ package net.frank.cms.web.core.actions;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.framework.bo.BaseEntity;
/*    */ import net.frank.framework.bo.Type;
/*    */ import net.frank.framework.service.CacheService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class NavigationAction extends BaseAction
/*    */ {
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 29 */     CacheService cacheService = (CacheService)getBean("cacheService");
/* 30 */     Map typeContent = cacheService.getTypeContent();
/* 31 */     Map typeClassMap = new HashMap();
/* 32 */     List typeContentList = new ArrayList();
/* 33 */     for (Iterator it = typeContent.keySet().iterator(); it.hasNext(); ) {
/* 34 */       Long resourceId = (Long)it.next();
/* 35 */       typeContentList.add(typeContent.get(resourceId));
/* 36 */       typeClassMap.put(resourceId, (BaseEntity)Class.forName(((Type)typeContent.get(resourceId)).getEntityClassName()).newInstance());
/*    */     }
/*    */ 
/* 42 */     request.setAttribute("typeContentList", typeContentList);
/* 43 */     request.setAttribute("typeClassMap", typeClassMap);
/* 44 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.actions.NavigationAction
 * JD-Core Version:    0.6.0
 */