<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<script type="text/javascript">
  		$("#btn").click(function(){
  			window.location.href='send_user_alterPassword.action';
  		});
  	</script>
  </head>
  
  <body>
  	<a id="btn" href="send_user_alterPassword.action">返回</a>&nbsp;&nbsp;
  	<font>修改成功</font>
  </body>
</html>
