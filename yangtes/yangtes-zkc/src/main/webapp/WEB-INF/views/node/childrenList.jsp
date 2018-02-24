<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="table_box">
	<table width="100%" border="0" class="cw_table thead_2">
		<thead>
			<tr>
				<th class="fst">序号</th>
				<th>名字</th>
				<th>节点类型</th>
				<th>数据</th>
				<th class="lst">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${childrenList}" var="zkNode" varStatus="loop">
			<tr <c:if test="${loop.index%2==0}"> class="even" </c:if>>
				<td>${loop.index + 1}</td>
				<td>${zkNode.id}</td>
				<td>${zkNode.nodeModel.msg}</td>
				<td>${zkNode.data}</td>
				<td></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
