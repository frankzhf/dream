<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript">
$(function() {
	$('#dialog_content_50002__unit_14_longString_id_').validatebox({   
	    required:true  
	});
	$('#content_50002__taskSummary').validatebox({   
	    required:true  
	});
	$('#content_50002__clobString_description_').validatebox({   
	    required:true  
	});
	
	$("#gotoDesktop").click(function(){
		var goDashboardFun = function() {
			window.location = '${pageContext.request.contextPath}/tasklist/dashboard.do';
			top.$('#confirmDiv').window('close');
		};
		top.confirm("<bean:message key='common.warning' />",
				"<bean:message key='common.message.go.back.dashboard' />",
				goDashboardFun, null);
	});
	
});
function submitDraft(){
	if($.validationForm('form[name=cmsForm] input[type!=hidden],textarea')){
		$.submitFormWoMsg();
	}
}


</script>

<html:form action="/submitCreateDraft">
<fk:content2 templateName="net.frank.tasklist.bo.Task.html" var="${content}"  mode="edit"
	resourceName="net.frank.tasklist.bo.Task" />
</html:form>
<a class="easyui-linkbutton" iconCls="icon-save" onclick="submitDraft()"
	href="javascript:void(0)" id="submitButton"><bean:message
		key="common.save" /></a>
<a class="easyui-linkbutton" iconCls="icon-undo" 
	href="javascript:void(0)" id="gotoDesktop"><bean:message
		key="common.back" /></a>