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
     ResultSet rs=dao.Query(connection);
     %>
 	<h2>后台管理界面</h2>
 	<h3>已注册用户信息如下：</h3>
 	<form action="display2.jsp" method="get">
	输入id以查询:<input name="id" type="text"><input type="submit" value="查询"><br>
	</form>
    <table border=1>
    <tr><td>用户序号</td><td>用户名</td><td colspan="3" align="center">管理方式</td></tr>
    <%while(rs.next()) {%>
    <tr><td><%=rs.getString("user_id") %></td><td><%=rs.getString("user_name") %></td><td><a href="delete.jsp?user_id=<%=rs.getString("user_id")%>">删除</a></td><td><a href="update.jsp?id=<%=rs.getString("user_id")%>">修改</a></td><td><a href="show.jsp?id=<%=rs.getString("user_id")%>">查看</a></td></tr>
    <%}db.closeCon(connection); %>
    </table>
    <a href="new.jsp">增加新用户</a> <a href="display3.jsp">管理管理员</a>
</body>
</html>