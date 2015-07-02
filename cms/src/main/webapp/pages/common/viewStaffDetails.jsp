<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<script type="text/javascript">
$(function() {
	$('#tabInfo').tabs({
	});
});
</script>
<div id="tabInfo" style="position:absolute; padding:0px 5px;width:580;height:380px">
	<div title="Personal">
		<fk:content2 var="${person}" resourceName="Person" templateName="Person.html" mode="view" />
	</div>
	<div title="Staff">
		<fk:content2 var="${staff}" resourceName="Staff" templateName="Staff.html" mode="view" />
	</div>
</div>