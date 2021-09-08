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
     ResultSet rs=dao.Query2(connection);
     %>
 	<h2>后台管理界面</h2>
    <h3>系统已有管理员信息如下：</h3>
 	<form action="display4.jsp" method="get">
	输入id以查询:<input name="id" type="text"><input type="submit" value="查询"><br>
	</form>
    <table border=1>
    <tr><td>管理员序号</td><td>管理员名</td><td colspan="2" align="center">管理方式</td></tr>
    <%while(rs.next()) {%>
    <tr><td><%=rs.getString("admin_id") %></td><td><%=rs.getString("admin_name") %></td><td><a href="update2.jsp?id=<%=rs.getString("admin_id")%>">设置</a></td><td><a href="show2.jsp?id=<%=rs.getString("admin_id")%>">查看</a></td></tr>
    <%} db.closeCon(connection);%>
    </table>
    <a href="new2.jsp">增加管理员</a> <a href="display.jsp">管理用户</a>
</body>
</html>