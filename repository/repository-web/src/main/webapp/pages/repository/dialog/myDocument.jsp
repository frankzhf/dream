<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.frank.net/jsp/tags" prefix="fk"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<body>
	<div style="height:330px;">
		<fk:tree rootName="root"
			builder="net.frank.repository.web.tags.MyFilesTreeBuilder" />
	</div>
	<div style="height:20px;" id="messageDiv">
	</div>
</body>