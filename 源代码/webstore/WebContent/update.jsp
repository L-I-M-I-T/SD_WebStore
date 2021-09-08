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
  rs.next();
  %> 
   <form action="UpdateServlet?id=<%=request.getParameter("id")%>" method="post">
    用户名:<input type="text" value="<%=rs.getString("user_name") %>" name="username"><br>
    密码:<input type="text" value="<%=rs.getString("user_password")%>" name="password"><br>
    真实姓名:<input type="text" value="<%=rs.getString("realname") %>" name="realname"><br>
    性别:<input type="text" value="<%=rs.getString("sex")%>" name="sex"><br>
    地址:<input type="text" value="<%=rs.getString("address") %>" name="address"><br>
    密保问题:<input type="text" value="<%=rs.getString("question")%>" name="question"><br>
    密保答案:<input type="text" value="<%=rs.getString("answer") %>" name="answer"><br>
    电子邮箱:<input type="text" value="<%=rs.getString("email")%>" name="email"><br>
    个人爱好:<input type="text" value="<%=rs.getString("favorate")%>" name="favorate"><br>
   <input type="submit" value="确认修改">
   </form>
    <%db.closeCon(connection); %>
  </body>
</html>