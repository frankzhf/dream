<%@ page contentType="text/html;charset=UTF-8"%>

<ul class="m_ul xzcg_sqd_ul">
	<li>
		<div>
			<label class="lbl_50">名称：</label> <span><input type="text"
				class="w_200" id="nodeId" disabled="disabled" value="${zkNode.id}" /></span>
		</div>
	</li>
	<li><label class="lbl_50">数据：</label> <span><input
			type="text" class="w_200" id="nodeData" value="${zkNode.data}" /></span></li>
</ul>
<input type="hidden" id="fullId" value="${zkNode.fullId}" />