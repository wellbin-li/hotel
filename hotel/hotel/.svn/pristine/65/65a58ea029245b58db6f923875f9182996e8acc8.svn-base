<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<style type="text/css">
  		form div{
  			margin:30;
  			margin-left:400;
  		}
  		form{
  			padding-top: 25;
  		}
  	</style>
  	<script type="text/javascript">
  		var nowusersex='&{nowuser.usex}';
  		var x=parseInt(nowusersex);

  		$(function(){
  			//自定义验证
			$.extend($.fn.validatebox.defaults.rules, {
				equalToNowUpass: {  
				    	//函数实现,如果返回为false，则验证失败 
				        validator: function(value,param){
				        	var userUpass=$("#userUpass").val().trim();
				        	var userUlogin=$("#userUlogin").val().trim();
				        	var haha = " ";
				        	//ajax验证    
				         	$.ajax({
				                type : 'post',
				                async : false,
				                url : 'user_validateUserUpass.action',
				                data : {
				                	"userUlogin": userUlogin,
				                    "userUpass" : userUpass
				                },
				                success : function(data) {
				                    haha = data;
				                }
				            });
				            console.log(haha);
	            		    return haha.indexOf("false");
				        },   
				       //错误消息 
				       message: '原密码不正确'   
				},
				//原密码验证(不推荐)  
			   	/* equalToNowUpass1: {
			    	validator:function(value,param){
			            return value == '${nowuser.upassword}';
			        },
			        message:'原密码不正确'
			    }, */
			    //两次新密码验证
			    equalTo: {
			        validator:function(value,param){
			            return $(param[0]).val() == value;
			        },
			        message:'两次输入密码不匹配'
			    }      
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
						url:'user_update.action',
						success: function(){
							window.location.href='send_user_alterPassSucceed.action';
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
	        <label for="ulogin">登录名:</label>&nbsp;<font color="blue">${nowuser.ulogin}</font>       
	        <input id="userUlogin" class="easyui-validatebox" type="hidden" name="ulogin" value="${nowuser.ulogin}"/>   
	    </div>   
	    <div>   
	        <label for="uname">姓名:</label>&nbsp;<font color="blue">${nowuser.uname}</font>   
	        <input type="hidden" name="uname" value="${nowuser.uname}"/>   
	    </div>
	    <div>   
	        <label for="uphone">联系电话:</label>&nbsp;<font color="blue">${nowuser.uphone}</font>   
	        <input type="hidden" name="uphone" value="${nowuser.uphone}"/>   
	    </div>          
	    <div>   
			请输入原密码: <input id="userUpass" type="password" name="password" class="easyui-validatebox" required="true" validType="equalToNowUpass"/>   
	    </div>
	    <div>
	    	请输入新密码： <input id="upassword" name="upassword" class="easyui-validatebox" validType="length[4,32]"  required="true" type="password" value=""/>
	    </div>
		<div>
			请再次输入新密码：<input id="repassword" type="password" name="repassword" class="easyui-validatebox" required="true"  validType="equalTo['#upassword']"/>
	    </div>
	   <div>   
	         <label for="usex"></label>
	        <input type="hidden" name="usex" value="${nowuser.usex}"/>
	    </div>   
	    <div>
	    	<label for="ucategory"></label>   
	       <input type="hidden" name="ucategory" value="${nowuser.ucategory}"/>
	    </div>
	    <div>   
	        <label for="ustate"></label>   
	        <input type="hidden" name="ustate" value="1"/>   
	    </div> 
	    <div>
	    	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
	    	<input type="hidden" name="uid" value="${nowuser.uid}"/>
	    </div>
	</form>  
  </body>
</html>
