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
  ResultSet rs=dao.show(connection,request.getParameter("id"));
  if (rs.next())
  %> 
    <table border=1>
    <tr><td>用户序号</td><td><%=request.getParameter("id")%></td></tr>
    <tr><td>用户名</td><td><%=rs.getString("user_name") %></td></tr>
    <tr><td>密码</td><td><%=rs.getString("user_password") %></td></tr>
    <tr><td>真实姓名</td><td><%=rs.getString("realname") %></td></tr>
    <tr><td>性别</td><td><%=rs.getString("sex") %></td></tr>
    <tr><td>地址</td><td><%=rs.getString("address") %></td></tr>
    <tr><td>密保问题</td><td><%=rs.getString("question") %></td></tr>
    <tr><td>密保答案</td><td><%=rs.getString("answer") %></td></tr>
    <tr><td>电子邮箱</td><td><%=rs.getString("email") %></td></tr>
    <tr><td>兴趣爱好</td><td><%=rs.getString("favorate") %></td></tr>
    </table>
     <%db.closeCon(connection); %>
  </body>
 
</html>