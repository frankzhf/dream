/*    */ package net.frank.cms.common;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import net.frank.framework.spring.SpringContextHolder;
/*    */ import net.frank.framework.web.security.AuthenticatorHolder;
/*    */ import net.frank.framework.web.security.ClientSession;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ 
/*    */ public class BaseJersey
/*    */ {
/* 16 */   private static final Integer DEFAULT_BUFFER_LENGTH = Integer.valueOf(4096);
/*    */ 
/* 18 */   protected transient Logger log = LoggerFactory.getLogger(getClass());
/*    */ 
/*    */   protected String inputStream2String(InputStream inputStrem) throws IOException {
/* 21 */     byte[] buf = new byte[DEFAULT_BUFFER_LENGTH.intValue()];
/* 22 */     int flag = -1;
/* 23 */     ByteArrayOutputStream bis = new ByteArrayOutputStream();
/* 24 */     while ((flag = inputStrem.read(buf)) != -1) {
/* 25 */       bis.write(buf, 0, flag);
/*    */     }
/* 27 */     return bis.toString();
/*    */   }
/*    */ 
/*    */   public ApplicationContext getContext() {
/* 31 */     return SpringContextHolder.getApplicationContext();
/*    */   }
/*    */   public Object getBean(String beanId) {
/* 34 */     return getContext().getBean(beanId);
/*    */   }
/*    */   public ClientSession getClientSession() {
/* 37 */     return AuthenticatorHolder.getClientSession();
/*    */   }
/*    */ }

/* Location:           D:\java\donot_delete\cms-1.0\WEB-INF\classes\
 * Qualified Name:     net.frank.cms.common.BaseJersey
 * JD-Core Version:    0.6.0
 */