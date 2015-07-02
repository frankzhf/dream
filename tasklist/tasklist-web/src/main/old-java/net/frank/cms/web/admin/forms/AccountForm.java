/*    */ package net.frank.cms.web.admin.forms;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.frank.framework.bo.Account;
/*    */ import net.frank.framework.bo.Account2Group;
/*    */ import net.frank.framework.bo.Privilege;
/*    */ import net.frank.framework.struts.form.PaginationForm;
/*    */ 
/*    */ public class AccountForm extends PaginationForm
/*    */ {
/*    */   private static final long serialVersionUID = 5084007671262626325L;
/*    */   private Account account;
/*    */   private List<Account2Group> groupList;
/*    */   private List<Privilege> privilegeList;
/* 23 */   private List<Account> records = new ArrayList();
/*    */ 
/*    */   public Account getAccount() {
/* 26 */     if (this.account == null) {
/* 27 */       this.account = new Account();
/*    */     }
/* 29 */     return this.account;
/*    */   }
/*    */ 
/*    */   public void setAccount(Account account) {
/* 33 */     this.account = account;
/*    */   }
/*    */ 
/*    */   public List<Account2Group> getGroupList() {
/* 37 */     return this.groupList;
/*    */   }
/*    */ 
/*    */   public void setGroupList(List<Account2Group> groupList) {
/* 41 */     this.groupList = groupList;
/*    */   }
/*    */ 
/*    */   public void setGroup(int index, Account2Group account2Group) {
/* 45 */     while (this.groupList.size() <= index) {
/* 46 */       this.groupList.add(new Account2Group());
/*    */     }
/* 48 */     this.groupList.set(index, account2Group);
/*    */   }
/*    */ 
/*    */   public Account2Group getGroup(int index) {
/* 52 */     while (this.groupList.size() <= index) {
/* 53 */       this.groupList.add(new Account2Group());
/*    */     }
/* 55 */     return (Account2Group)this.groupList.get(index);
/*    */   }
/*    */ 
/*    */   public List<Privilege> getPrivilegeList() {
/* 59 */     return this.privilegeList;
/*    */   }
/*    */ 
/*    */   public void setPrivilegeList(List<Privilege> privilegeList) {
/* 63 */     this.privilegeList = privilegeList;
/*    */   }
/*    */ 
/*    */   public Privilege getPrivilege(int index) {
/* 67 */     while (this.privilegeList.size() <= index) {
/* 68 */       this.privilegeList.add(new Privilege());
/*    */     }
/* 70 */     return (Privilege)this.privilegeList.get(index);
/*    */   }
/*    */ 
/*    */   public void setPrivilege(int index, Privilege privilege) {
/* 74 */     while (this.privilegeList.size() <= index) {
/* 75 */       this.privilegeList.add(new Privilege());
/*    */     }
/* 77 */     this.privilegeList.set(index, privilege);
/*    */   }
/*    */ 
/*    */   public List<Account> getRecords() {
/* 81 */     return this.records;
/*    */   }
/*    */ 
/*    */   public void setRecords(List<Account> records) {
/* 85 */     this.records = records;
/*    */   }
/*    */ 
/*    */   public Account getRecord(int index) {
/* 89 */     while (this.records.size() <= index) {
/* 90 */       this.records.add(new Account());
/*    */     }
/* 92 */     return (Account)this.records.get(index);
/*    */   }
/*    */ 
/*    */   public void setRecord(int index, Account account) {
/* 96 */     while (this.records.size() <= index) {
/* 97 */       this.records.add(new Account());
/*    */     }
/* 99 */     this.records.set(index, account);
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.admin.forms.AccountForm
 * JD-Core Version:    0.6.0
 */