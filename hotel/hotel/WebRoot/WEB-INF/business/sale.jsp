<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<script type="text/javascript" src="${hotel}/jquery-easyui-1.3.5/jscharts.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			var colorArr=['#44A622','#A7B629','#CAD857','#E4DB7B','#ECDE49','#ECC049','#EC9649','#D97431','#D95531','#A7B629'];
  			$("#ss").click(function(){
  				//发送ajax请求
  				$.post($("#sale").val(),{bnumber:$("#bnumber").val()},function(data){
	  					var myChart = new JSChart('chart_container', $("#type").val(), '');
						myChart.setDataArray(data);
						//设置颜色从0到数组的长度
						myChart.colorize(colorArr.slice(0, data.length));
						myChart.setSize(100*$("#bnumber").val(), 400);
						myChart.setBarValues(false);
						myChart.setBarSpacingRatio(45);
						myChart.setBarOpacity(1);
						myChart.setBarBorderWidth(0);
						//将标题设置为下拉框中选中的文本
						myChart.setTitle($("#sale").find("option:selected").text());
						myChart.setTitleFontSize(10);
						myChart.setTitleColor('#607985');
						myChart.setAxisValuesColor('#607985');
						myChart.setAxisNameX("客房种类", true);
						myChart.setAxisNameY("数量（天）", true);
						myChart.setGridOpacity(0.8);
						myChart.setAxisPaddingLeft(50);
						myChart.setAxisPaddingBottom(50);
						//myChart.set3D(true);
						myChart.draw(); 
	  				},"json");
  			    
  			});
  		});

	</script>
  </head>
  
  <body style="margin: 10px;">
  	请选择报表的类型：	
  	<select id="sale">
  		<option value="business_querySale.action">客房销量报表</option>
  		<option value="business_queryOrderin.action">客房预订报表</option>
  		<option value="business_queryOrderout.action">客房退订报表</option>
  	</select>
  	查询的数量：
  	<select id="bnumber">
  		<option value="3">3</option>
  		<option value="5">5</option>
  		<option value="10">10</option>
  	</select>
  	报表类型：
  	<select id="type">
  		<option value="bar">柱状图</option>
  		<option value="line">线性图</option>
  		<option value="pie">饼状图</option>
  	</select>
  	<input id="ss" type="button" value="查询"/>
	<div id="chart_container">Loading chart...</div>
  </body>
</html>
