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
  rs.next();
  %> 
   <form action="UpdateServlet2?id=<%=request.getParameter("id")%>" method="post">
    管理员名:<%=rs.getString("admin_name") %><br>
    密码:******<br>
    权限:<input type="text" value="<%=rs.getString("role") %>" name="role"><br>
   <input type="submit" value="确认修改">
   </form>
    <%db.closeCon(connection); %>
  </body>
</html>