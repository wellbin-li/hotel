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
  			//对客房状态的下拉列表框进行远程加载
  			$('#zt').combobox({    
			    url:'roomstate_query.action',    
			    valueField:'rsid',    
			    textField:'rsname',
			    panelHeight:'auto',
			    panelWidth:200,
			    width:150,
			    editable:false
			}); 
  			$("input[name=rname]").validatebox({
  				required:true,
  				missingMessage:'请输入客房号码'
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
  				//开启验证
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					//提交数据
  					$('#ff').form('submit', {
						url:'room_save.action',
						success: function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//刷新页面 获取aindex--->iframe--->dg    dom--->jquery---easyui
							//不兼容  parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("getSelections");
							parent.$("iframe[title='客房信息管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
	        <label for="rname">客房号码:</label>   
	        <input type="text" name="rname"/>   
	    </div>   
	    <div>   
	        <label for="roomcategory">所属类型:</label>   
	        <input id="cc" type="text" name="roomcategory.rcid" />   
	    </div> 
	    <div>   
	        <label for="roomstate">客房状态:</label>   
	        <input id="zt" type="text" name="roomstate.rsid"/>   
	    </div>    
	    <div>   
	        <label for="rremark">备注:</label>
		    <textarea name="rremark" cols="40" rows="7"></textarea>
	    </div> 
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
	    </div>    
	</form>  
  </body>
</html>
