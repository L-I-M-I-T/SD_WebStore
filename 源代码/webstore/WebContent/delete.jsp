<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="web.DAO" %>
<%@ page import="web.User"%>
<%@ page import="web.JDBC"%>
 
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>notitle</title>
  </head>
<body>
     <%
     JDBC db=new JDBC();
     Connection connection=db.getCon();
     DAO dao=new DAO();
     int rs=dao.delete(connection,request.getParameter("user_id"));
     db.closeCon(connection);
     %>
 	<h2>删除用户完成！</h2>
    <a href="display.jsp">返回后台管理界面</a>
</body>