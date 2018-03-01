<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<style type="text/css">
  		form div{
  			margin:25;
  			margin-left:10;
  		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			//iframe 中的dg对象
  			var dg=parent.$("iframe[title='客房经营管理']").get(0).contentWindow.$("#dg");
  			$.extend($.fn.validatebox.defaults.rules, {    
			    integer: {// 验证整数 可正负数  
	               validator: function (value) {  
	                   //return /^[+]?[1-9]+\d*$/i.test(value);  
	  
	                   return /^([+]?[1-9])+\d*$/i.test(value);  
	               },  
              	   message: '请输入正整数'  
           		},   
			});
  			//完成数据的回显(此代码尽量放在远程加载下拉框的前面,数据为空的字段不能回显，比如client)
  			var rows=dg.datagrid("getSelections");
  			$('#ff').form('load',{
				rid:rows[0].rid,
				rname:rows[0].rname,
				//对日期进行截取
				rdate:rows[0].rdate.substring(0,10),
				rnumber:rows[0].rnumber,
				rcash:rows[0].rcash,
				rfee:rows[0].rfee,
				rremark:rows[0].rremark,
				'client.cid':rows[0].client.cid,
				'roomcategory.rcid':rows[0].roomcategory.rcid,
				'roomcategory.rcprice':rows[0].roomcategory.rcprice
			});
  			//对客房类型的下拉列表框进行远程加载
  			$('#cc').combobox({    
			    url:'roomcategory_query.action',    
			    valueField:'rcid',    
			    textField:'rcname',
			    panelHeight:'auto',
			    panelWidth:200,
			    width:150,
			    editable:false
			});
  			//对顾客的下拉列表框进行远程加载
  			 $('#gk').combobox({    
			    url:'client_query.action',    
			    valueField:'cid',    
			    textField:'cname',
			    panelHeight:'auto',
			    panelWidth:200,
			    width:150,
			    editable:false
			});
			//事件  将总金额写入输入框
			$('#cash').click(function(){
				var fee=$("input[name=rnumber]").val()*$("input[name='roomcategory.rcprice']").val();
				$("input[name=rfee]").attr("value",fee);
			});
			$('#fee').click(function(){
				var fee=$("input[name=rnumber]").val()*$("input[name='roomcategory.rcprice']").val();
				$("input[name=rfee]").attr("value",fee);
			});
			//将所有class为hide的div隐藏起来 
			$(".hide").hide();
  			$("input[name=rname]").validatebox({
  				required:true,
  				missingMessage:'请输入客房号码'
  			});
  			$('#gk').combobox({
  				required:true,
  				missingMessage:'请选择顾客'
  			});
			$("input[name=rcash]").numberbox({
  				required:true,
  				missingMessage:'请输入押金',
  				min:0,    
    			precision:2,    
  				prefix:'￥'
  			});
			$("input[name=rfee]").numberbox({
  				required:true,
  				missingMessage:'请输入总金额',
  				min:0,    
    			precision:2,    
  				prefix:'￥'
  			});
  			//对类型选择框进行验证
  			$('#cc').combobox({
  				required:true,
  				missingMessage:'请选择类型'
  			});
  			//对状态选择框进行验证
  			$('#zt').combobox({
  				required:true,
  				missingMessage:'请选择状态'
  			});
  			//窗体弹出默认时禁用验证
  			$("#ff").form("disableValidation");
  			//注册button事件
  			$("#btn").click(function(){
  				//将总金额写入输入框
  				var fee=$("input[name=rnumber]").val()*$("input[name='roomcategory.rcprice']").val();
  				$("input[name=rfee]").attr("value",fee);
  				//开启验证
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					 
  					//提交数据
  					$('#ff').form('submit', {
						url:'room_roomout.action',
						success: function(){
							parent.$.messager.show({
								title:'提示',
								msg:'退房成功',
								timeout:3000,
								showType:'slide'
							});
							//关闭当前窗体
							parent.$("#win").window("close");
							dg.datagrid("reload");
						}
					});
  					
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  	<form id="ff" method="post">   
	    <div class="hide">   
	        <label for="rname">客房号码:</label>   
	        <input type="hidden" name="rname"/>   
	    </div>   
	    <div class="hide">   
	        <label for="roomcategory">所属类型:</label>   
	        <input id="cc" type="hidden" name="roomcategory.rcid" />   
	    </div>
	    <!-- 客房状态在后台直接修改 -->    
	    <div>   
	        <label for="client">所住顾客:</label>   
	        <input id="gk" type="text" name="client.cid" readonly="readonly"/>   
	    </div>    
	    <div>   
	        <label for="rdate">入住日期:</label>   
	        <input type="text" name="rdate" readonly="readonly" class="easyui-datebox" required="true" />   
	    </div>    
	    <div>   
	        <label for="rnumber">入住天数:</label>   
	        <input type="text" name="rnumber" readonly="readonly" class="easyui-validatebox" validType="integer" required="true"/>   
	    </div>    
	    <div id="cash">   
	        <label for="rcash">押金:</label>   
	        <input type="text" name="rcash" readonly="readonly"/>   
	    </div>    
	    <div id="fee">   
	        <label for="rfee">总金额:</label>   
	        <input type="text" name="rfee" readonly="readonly"/>
	       
	    </div>
	    <!-- 仅仅用于计算总金额 -->
	    <div class="hide">
	    	<label for="roomcategory"></label>   
	        <input id="cc" name="roomcategory.rcprice" />
	    </div>    
	    <div class="hide">   
	        <label for="rremark">客房说明:</label>
		    <textarea name="rremark" cols="40" rows="7"></textarea>
	    </div>
	    <div>   
	        <label for="bremark">备注:</label>
	        <!-- bremark与后台参数名字相同    将值传入后台bremark中-->
		    <textarea name="bremark" cols="40" rows="7"></textarea>
	    </div>
	    <div>   
	        <!-- 添加当前处理人-->
			<input name="user.uid" type="hidden" value="${nowuser.uid}">      
	    </div>
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">退房</a>
	    	<input type="hidden" name="rid"/>
	    </div>    
	</form>  
  </body>
</html>
