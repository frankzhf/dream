<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript">
$(function() {
	$('#dialog_content_15__unit_14_longString_id_').validatebox({   
	    required:true  
	});
	$('#content_15__taskSummary').validatebox({   
	    required:true  
	});
	$('#content_15__clobString_description_').validatebox({   
	    required:true  
	});
});
function submitDraft(){
	if($.validationForm('form[name=cmsForm] input[type!=hidden],textarea')){
		$.submitFormWoMsg();
	}
}
</script>

<html:form action="/submitCreateDraft">
<fk:content2 templateName="net.frank.framework.bo.Task.html" var="${content}"  mode="edit"
	resourceName="net.frank.framework.bo.Task.properties" />
</html:form>
<a class="easyui-linkbutton" iconCls="icon-save" onclick="submitDraft()"
	href="javascript:void(0)" id="submitButton"><bean:message
		key="common.save" /></a>
<a class="easyui-linkbutton" iconCls="icon-undo" 
	href="javascript:void(0)" id="goDashboard"><bean:message
		key="common.back" /></a>