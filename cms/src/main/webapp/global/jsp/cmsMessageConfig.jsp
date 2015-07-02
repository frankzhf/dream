<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<script type="text/javascript">
/**
 * CMS messages define
 */
var GLOBAL_CMS_MESSAGE_OK = 0;
var GLOBAL_CMS_MESSAGE_READ = -1;
var GLOBAL_CMS_MESSAGE_WRITE = -2;
var GLOBAL_CMS_MESSAGE_RUN = -3;
var GLOBAL_CMS_MESSAGE_NOT_EXISTS = -4;
var GLOBAL_CMS_MESSAGE_EXISTS = -5;
var GLOBAL_CMS_MESSAGE_UNKNOW = -100;
$.extend({
	processCmsMessage : function(message,ok,read,write,run,notExists,exists,unknown){
		switch (message) {
		case GLOBAL_CMS_MESSAGE_OK:
			if(ok == null){
				top.confirm("<bean:message key='common.warning' />",
					"<bean:message key='common.operate.success' />",
					null, null);
			}else{
				ok();
			}
			break;
		case GLOBAL_CMS_MESSAGE_READ:
			if(read == null){
				top.confirm("<bean:message key='common.error' />",
						"<bean:message key='errors.cms.read' />",
						null, null);
			}else{
				read();
			}
			break;
		case GLOBAL_CMS_MESSAGE_WRITE:
			if(write == null){
				top.confirm("<bean:message key='common.error' />",
					"<bean:message key='errors.cms.write' />",
					null, null);
			}else{
				write();
			}
			break;
		case GLOBAL_CMS_MESSAGE_RUN:
			if(run == null){
				top.confirm("<bean:message key='common.error' />",
					"<bean:message key='errors.cms.run' />",
					null, null);
			}else{
				run();
			}
			break;
		case GLOBAL_CMS_MESSAGE_NOT_EXISTS:
			if(notExists == null){
				top.confirm("<bean:message key='common.error' />",
					"<bean:message key='errors.cms.object.not.exists' />",
					null, null);
			}else{
				notExists();
			}
			break;
		case GLOBAL_CMS_MESSAGE_EXISTS:
			if(exists == null){
				top.confirm("<bean:message key='common.error' />",
					"<bean:message key='errors.cms.object.exists' />",
					null, null);
			}else{
				exists();
			}
			break;
		default:
			if(unknown == null){
				top.confirm("<bean:message key='common.error' />",
					"<bean:message key='errors.cms.unknown' />",
					null, null);
			}else{
				unknown();
			}
			break;
		}
	}
});
</script>
