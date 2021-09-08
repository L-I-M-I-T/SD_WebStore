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
     ResultSet rs=dao.find2(connection,request.getParameter("id"));
     if (!rs.first())
     {
    	 response.sendRedirect("find_fail2.jsp");
    	 return;
     }
     else
    	 rs.previous();
     %>
 	<h2>查询界面</h2>
 	<h3>查询到的管理员如下:</h3>
    <table border=1>
    <tr><td>管理员序号</td><td>管理员名称</td><td colspan="2" align="center">管理方式</td></tr>
    <%while(rs.next()) {%>
    <tr><td><%=rs.getString("admin_id") %></td><td><%=rs.getString("admin_name") %></td><td><a href="update2.jsp?id=<%=rs.getString("admin_id")%>">设置</a></td><td><a href="show2.jsp?id=<%=rs.getString("admin_id")%>">查看</a></td></tr>
    <%}db.closeCon(connection); %>
    </table>
</body>
</html>