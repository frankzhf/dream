/*    */ package net.frank.cms.web.task.actions;
/*    */ 
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.Account;
/*    */ import net.frank.framework.bo.BusinessObject;
/*    */ import net.frank.framework.bo.Group;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.QueryService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.struts.form.CmsForm;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class CreateDraftAction extends BaseAction
/*    */ {
/* 21 */   private static final Integer[] permissionList = { Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(0) };
/*    */   private static final String MY_DRAFT_PATH = "/home/";
/*    */ 
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 28 */     CmsForm _form = (CmsForm)form;
/* 29 */     StringBuffer parentPath = new StringBuffer(256);
/* 30 */     parentPath.append("/home/").append(".").append(getClientSession().getLoginName()).append("/").append("draft");
/*    */ 
/* 34 */     this.log.debug("Current My Draft Path:" + parentPath.toString());
/* 35 */     QueryService queryService = (QueryService)getBean("queryService");
/* 36 */     Resource parent = queryService.getResourceAsPath(parentPath.toString());
/* 37 */     Resource resource = _form.getResource();
/* 38 */     resource.setParentId(parent.getId());
/* 39 */     resource.setTypeId(CommonConstants.TYPE.TASK);
/* 40 */     resource.setChildren(null);
/* 41 */     resource.setCurrentAccountPermission(permissionList[0]);
/* 42 */     resource.setCurrentGroupPermission(permissionList[1]);
/* 43 */     resource.setOthersPermission(permissionList[2]);
/* 44 */     resource.setOwnResourceId(getClientSession().getAccount().getResource().getId());
/* 45 */     resource.setOwnGroupResourceId(getClientSession().getCurrentGroup().getResource().getId());
/* 46 */     resource.setActive(Boolean.TRUE);
/* 47 */     BusinessObject content = null;
/* 48 */     content = (BusinessObject)_form.getContentMap().get(CommonConstants.TYPE.TASK);
/* 49 */     content.setResource(resource);
/* 50 */     _form.setListRessource(null);
/* 51 */     request.setAttribute("resource", resource);
/* 52 */     request.setAttribute("mode", "edit");
/* 53 */     request.setAttribute("content", content);
/* 54 */     request.setAttribute("listResource", null);
/* 55 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.actions.CreateDraftAction
 * JD-Core Version:    0.6.0
 */