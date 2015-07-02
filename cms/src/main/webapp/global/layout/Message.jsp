<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<font color="red">
<html:errors />
</font>
<html:messages id="message" message="true">
	<font color="green">
	<bean:write name="message" />
	</font>
</html:messages>
