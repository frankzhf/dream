/*    */ package net.frank.cms.web.core.forms;
/*    */ 
/*    */ import net.frank.framework.bo.SystemHistory;
/*    */ import org.apache.struts.action.ActionForm;
/*    */ 
/*    */ public class HistoryForm extends ActionForm
/*    */ {
/*    */   private static final long serialVersionUID = 6662413986500545559L;
/* 13 */   private SystemHistory systemHistory = new SystemHistory();
/*    */ 
/*    */   public SystemHistory getSystemHistory() {
/* 16 */     return this.systemHistory;
/*    */   }
/*    */ 
/*    */   public void setSystemHistory(SystemHistory systemHistory) {
/* 20 */     this.systemHistory = systemHistory;
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.forms.HistoryForm
 * JD-Core Version:    0.6.0
 */