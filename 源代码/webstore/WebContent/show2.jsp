<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<%@ page import="java.sql.*"%>
<%@ page import="web.User" %>
<%@page import="web.DAO"  %>
<%@page import="web.JDBC"  %>
<html>
  <head>
 	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  </head>
 
  <body>
  <%
  JDBC db=new JDBC();
  Connection connection=db.getCon();
  request.setCharacterEncoding("utf-8");
  DAO dao=new DAO();
  ResultSet rs=dao.show2(connection,request.getParameter("id"));
  if (rs.next())
  %> 
    <table border=1>
    <tr><td>管理员序号</td><td><%=request.getParameter("id")%></td></tr>
    <tr><td>管理员名称</td><td><%=rs.getString("admin_name") %></td></tr>
    <tr><td>管理员密码 </td><td>******</td></tr>
    <tr><td>权限</td><td><%=rs.getString("role") %></td></tr>
    </table>
     <%db.closeCon(connection); %>
  </body>
</html>