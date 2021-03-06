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
  			//对管理员的下拉列表框进行远程加载
  			/* $('#cc').combobox({    
			    url:'user_query.action',    
			    valueField:'uid',    
			    textField:'ulogin',
			    panelHeight:'auto',
			    panelWidth:150,
			    width:150,
			    editable:false
			});  */
  			$("input[name=rcname]").validatebox({
  				required:true,
  				missingMessage:'请输入类别名称'
  			});
  			$("input[name=rcprice]").numberbox({
  				required:true,
  				missingMessage:'请输入类别价格',
  				min:0,    
    			precision:2,    
  				prefix:'￥'
  			});
  			$("input[name=rcnum]").numberbox({
  				required:true,
  				missingMessage:'请输入床位数',
  				min:0,
  			});
  			//窗体弹出默认时禁用验证
  			$("#ff").form("disableValidation");
  			//注册button事件
  			$("#btn").click(function(){
  				//开启验证
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					//提交数据
  					$('#ff').form('submit', {
						url:'roomcategory_save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//刷新页面 获取aindex--->iframe--->dg    dom--->jquery---easyui
							//不兼容  parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("getSelections");
							parent.$("iframe[title='客房类型管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
  					
  				}
  			});
  		});
  	</script>
  </head>
  
  <body>
  	<form id="ff" method="post">   
	    <div>   
	        <label for="rcname">类别名称:</label>   
	        <input type="text" name="rcname"/>   
	    </div>   
	    <div>   
	        <label for="rcprice">单价(元/天):</label>   
	        <input type="text" name="rcprice"/>   
	    </div> 
	      <div>   
	        <label for="rcnum">配置床位:</label>   
	        <input type="text" name="rcnum"/>   
	    </div>    
	    <div>   
	        <label for="rchot">热点:</label>   
	        <input type="radio" name="rchot" value="true"/>热点
	        <input type="radio" name="rchot" value="false" checked="checked"/>非热点
	    </div>
	    <div>   
	        <!-- 添加当前管理员 -->
			<input name="user.uid" type="hidden" value="${nowuser.uid}">      
	    </div> 
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
	    </div>    
	</form>  
  </body>
</html>
