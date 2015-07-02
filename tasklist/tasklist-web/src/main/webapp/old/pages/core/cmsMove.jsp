<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://www.frank.net/jsp/tags/cms" prefix="cms"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/global/scripts/dialog.js"></script>

<script>
	$(function(){
		$('#fromPath').validatebox({   
		    required:true  
		});
		$('#toPath').validatebox({   
		    required:true  
		});
		$("#recursive").attr("disabled",true);
		$('#clone').click(function(){
			if("checked" == $(this).attr("checked")){
				$("#recursive").attr("disabled",false);
			}else{
				$("#recursive").attr("disabled",true);
			}
		});
		
	});
	
	function submitMove(){
		if($.validationForm('form[name=moveForm] input[type!=hidden]')){
			$.submitFormWoMsg();	
		}
	}
</script>

<html:form action="/submitMove">
	<table style="width: 100%">
		<tr>
			<td width="20%">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td><bean:message key="core.move.from.path" /></td>
			<td><input type="text" id="fromPath" name="fromPath"
				style="width: 70%" /></td>
		</tr>
		<tr>
			<td><bean:message key="core.move.to.path" /></td>
			<td><input type="text" id="toPath" name="toPath"
				style="width: 70%" /></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="core.move.clone" /> <input
				type="checkbox" id="clone" name="clone" value="true"></td>
		</tr>
		<tr>
			<td colspan="2"><bean:message key="core.move.recursive" /> <input
				type="checkbox" id="recursive" name="recursive" value="true">
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button"
				value="<bean:message key='common.submit' />" onclick="submitMove()">
			</td>
		</tr>
	</table>
</html:form>
