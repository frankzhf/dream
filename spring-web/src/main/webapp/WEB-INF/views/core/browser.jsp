<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="fk" uri="http://www.frank.net/jsp/tags"%>

<fk:cs/>
<layout:page pageTag="browser">
	<div class="row-fluid">
		<div id="leftArea" class="span4">
			<div class="row-fluid" >
				<div id="navigation" class="span12">
					<iframe id="treeNav" name="treeNav" frameborder="0"
						src="${pageContext.request.contextPath}/core/tree" style="width:100%;height:${cs.screenHeight-75-40}px;overflow:false"></iframe>
				</div>
			</div>
			<div class="row-fluid" style="height:40px;">
				<div id="controlBar" class="span12">
					<label class="control-label span3">
						<spring:message code="browser.type" />
					</label>
					<div class="controls span6">
						<select id="typeId" class="select2-offscreen" style="width:180px" tabIndex="-1" data-type="select" 
							data-readonly="false">
	<c:forEach items="${cs.userTypeList}" var="type" varStatus="loop">
							<option value="${type.resource.id}">${type.typeKey}</option>
	</c:forEach>
						</select>
					</div>
					<div class="controls span3">
						<button class="btn" type="button" id="btnCreateObject" onclick="createObject()">
							<spring:message code="browser.button.create" />
						</button>
					</div>
				</div>
			</div>
		</div>
		<div id="rightArea" class="span8" style="height:${cs.screenHeight-75-40}px;" >
			<div id="testChart" style="height:300px"></div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#typeId").select2({
			width: 'element',
			allowClear: true
		});
		$("#typeId").on("open", function(){
			$(this).select2("close");
		});
		var gaugeOption = {
			title:{
				text:"Test Gauge",
				link:"",
				target:"null",
				subtext:"",
				sublink:"",
				subtarget:"null",
				textAlign:"left",
				x:"left",
				y:"top"
			},
			tooltip:{
				show:true
			},
			series:[{
				type:"gauge",
				pointer : {
					width:5
				},
				axisLine:{
					lineStyle:{
						color:[[0.8, '#ff4500'],[1,'#228b22']],
						width:8
					}
				},
				center:["50%","50%"],
				detail:{
					formatter:"{value}%",
					textStyle:{
						color:"auto",
						fontWeight:'bolder'
					}
				},
				data : [{
					value:85.6,
					name:"% billable"
				}]
			}]
		};
		console.log("Chart define OK.")
		var gaugeChart = echarts.init(document.getElementById('testChart'));
		gaugeChart.setOption(gaugeOption);
	});
	
	function createObject(){
		var node = $("#treeNav")[0].contentWindow.tree.getSelected();
		if(node!=null){
			$.ajax({
				type : 'get',
				url : UiApp.contextPath +"/tree/getChildren/" + node.getId(),
		        contentType: "application/xml",
				success : function(data) {
					var xmlObject = $(data);
					var parentTypeId = xmlObject.find("property[name=typeId]").text();
					if(parentTypeId!=3){
						triggerErrorBox('<spring:message code="browser.error.parent.node.should.folder" />');
					}else{
						var typeId = $("#typeId").val();
						$('#rightArea').html("<iframe id=\"details\" name=\"details\" frameborder=\"0\" src=\"${pageContext.request.contextPath}/core/createObject/"+
								node.getId()+"/"+typeId+"\" style=\"width:100%;height:${cs.screenHeight-75-40}px;\"></iframe>");
					}
				}
			});
		}else{
			triggerErrorBox('<spring:message code="browser.error.parent.node.not.empty" />');
		}
		
	}
	
	function showDetails(id){
		/***
		$('#rightArea').html("<iframe id=\"details\" name=\"details\" frameborder=\"0\" src=\"${pageContext.request.contextPath}/core/showDetails/"+
				id+"\" style=\"width:100%;height:${cs.screenHeight-75-40}px;\"></iframe>");
		****/		
		$('#rightArea').cloud({
			url: '${pageContext.request.contextPath}/tree/getChildren/'+ id,
			debug:false
			
		});
	}
	</script>
</layout:page>