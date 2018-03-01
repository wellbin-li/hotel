<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  </head>
  
  <body>
  		<!--  	
   		<a href="send_main_aindex.action">直接到后台UI版本</a>
   		<a href="send_admin_login.action">登录</a>
   		-->
   		<%
			response.sendRedirect("send_admin_login.action");
		%>
  </body>
</html>
