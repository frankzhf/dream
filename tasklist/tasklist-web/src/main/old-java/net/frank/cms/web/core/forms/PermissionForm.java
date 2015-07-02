/*     */ package net.frank.cms.web.core.forms;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.struts.action.ActionForm;
/*     */ 
/*     */ public class PermissionForm extends ActionForm
/*     */ {
/*     */   private static final long serialVersionUID = -5573142775342987023L;
/*  12 */   private Boolean chagePermissionFlag = Boolean.TRUE;
/*     */   private String resourceFullPath;
/*  14 */   private Boolean chageOwnFlag = Boolean.FALSE;
/*     */   private Long ownResourceId;
/*  16 */   private Boolean chageGroupFlag = Boolean.FALSE;
/*     */   private Long groupResourceId;
/*  18 */   private Boolean recursive = Boolean.FALSE;
/*     */ 
/*  20 */   private Map<Integer, Boolean> permissionMap = new HashMap();
/*     */ 
/*     */   public PermissionForm() {
/*  23 */     setPermission("0", Boolean.FALSE);
/*  24 */     setPermission("1", Boolean.FALSE);
/*  25 */     setPermission("2", Boolean.FALSE);
/*  26 */     setPermission("3", Boolean.FALSE);
/*  27 */     setPermission("4", Boolean.FALSE);
/*  28 */     setPermission("5", Boolean.FALSE);
/*  29 */     setPermission("6", Boolean.FALSE);
/*  30 */     setPermission("7", Boolean.FALSE);
/*  31 */     setPermission("8", Boolean.FALSE);
/*     */   }
/*     */ 
/*     */   public Boolean getChagePermissionFlag()
/*     */   {
/*  36 */     return this.chagePermissionFlag;
/*     */   }
/*     */ 
/*     */   public void setChagePermissionFlag(Boolean chagePermissionFlag) {
/*  40 */     this.chagePermissionFlag = chagePermissionFlag;
/*     */   }
/*     */ 
/*     */   public String getResourceFullPath() {
/*  44 */     return this.resourceFullPath;
/*     */   }
/*     */ 
/*     */   public void setResourceFullPath(String resourceFullPath) {
/*  48 */     this.resourceFullPath = resourceFullPath;
/*     */   }
/*     */ 
/*     */   public Boolean getChageOwnFlag() {
/*  52 */     return this.chageOwnFlag;
/*     */   }
/*     */ 
/*     */   public void setChageOwnFlag(Boolean chageOwnFlag) {
/*  56 */     this.chageOwnFlag = chageOwnFlag;
/*     */   }
/*     */ 
/*     */   public Long getOwnResourceId() {
/*  60 */     return this.ownResourceId;
/*     */   }
/*     */ 
/*     */   public void setOwnResourceId(Long ownResourceId) {
/*  64 */     this.ownResourceId = ownResourceId;
/*     */   }
/*     */ 
/*     */   public Boolean getChageGroupFlag() {
/*  68 */     return this.chageGroupFlag;
/*     */   }
/*     */ 
/*     */   public void setChageGroupFlag(Boolean chageGroupFlag) {
/*  72 */     this.chageGroupFlag = chageGroupFlag;
/*     */   }
/*     */ 
/*     */   public Long getGroupResourceId() {
/*  76 */     return this.groupResourceId;
/*     */   }
/*     */ 
/*     */   public void setGroupResourceId(Long groupResourceId) {
/*  80 */     this.groupResourceId = groupResourceId;
/*     */   }
/*     */ 
/*     */   public Boolean getRecursive() {
/*  84 */     return this.recursive;
/*     */   }
/*     */ 
/*     */   public void setRecursive(Boolean recursive) {
/*  88 */     this.recursive = recursive;
/*     */   }
/*     */ 
/*     */   public Map<Integer, Boolean> getPermissionMap() {
/*  92 */     return this.permissionMap;
/*     */   }
/*     */ 
/*     */   public void setPermissionMap(Map<Integer, Boolean> permissionMap) {
/*  96 */     this.permissionMap = permissionMap;
/*     */   }
/*     */ 
/*     */   public Boolean getPermission(String key) {
/* 100 */     Integer _key = Integer.decode(key);
/* 101 */     return (Boolean)this.permissionMap.get(_key);
/*     */   }
/*     */ 
/*     */   public void setPermission(String key, Boolean obj) {
/* 105 */     Integer _key = Integer.decode(key);
/* 106 */     this.permissionMap.put(_key, obj);
/*     */   }
/*     */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.web.core.forms.PermissionForm
 * JD-Core Version:    0.6.0
 */