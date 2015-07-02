/*    */ package net.frank.cms.web.task.actions;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import net.frank.cms.web.task.forms.ProcessTokenForm;
/*    */ import net.frank.commons.CommonConstants.TYPE;
/*    */ import net.frank.framework.bo.Account;
/*    */ import net.frank.framework.bo.Comment;
/*    */ import net.frank.framework.bo.Resource;
/*    */ import net.frank.framework.service.ResourceService;
/*    */ import net.frank.framework.struts.action.BaseAction;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ import org.apache.struts.action.ActionForward;
/*    */ import org.apache.struts.action.ActionMapping;
/*    */ 
/*    */ public class SubmitTaskTokenCommentAction extends BaseAction
/*    */ {
/* 23 */   private static final Integer[] permissionList = { Integer.valueOf(7), Integer.valueOf(4), Integer.valueOf(0) };
/*    */   private static final String ALIAS_SUFFIX = "#Comment";
/*    */ 
/*    */   public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
/*    */     throws Exception
/*    */   {
/* 30 */     ProcessTokenForm _form = (ProcessTokenForm)form;
/* 31 */     ResourceService resourceService = (ResourceService)getBean("resourceService");
/* 32 */     Resource resource = _form.getResource();
/* 33 */     resource.setChildren(null);
/* 34 */     resource.setCurrentAccountPermission(permissionList[0]);
/* 35 */     resource.setCurrentGroupPermission(permissionList[1]);
/* 36 */     resource.setOthersPermission(permissionList[2]);
/* 37 */     resource.setOwnResourceId(getClientSession().getAccount().getResource().getId());
/*    */ 
/* 39 */     resource.setActive(Boolean.TRUE);
/* 40 */     resource.setAlias(new Date().getTime() + "#Comment");
/* 41 */     Comment comment = (Comment)_form.getContent(CommonConstants.TYPE.COMMENT + "");
/*    */ 
/* 44 */     comment.setResource(resource);
/* 45 */     comment.setReply$12(null);
/* 46 */     resourceService.saveOrUpdateBo(comment, getClientSession());
/*    */ 
/* 48 */     return mapping.findForward("success");
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.task.actions.SubmitTaskTokenCommentAction
 * JD-Core Version:    0.6.0
 */