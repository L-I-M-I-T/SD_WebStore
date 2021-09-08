<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>
webstore
</title>
</head>
<body>

<form action="LoginServlet" method="post">
<h2>会员登录界面</h2>
账号:<input name="username" type="text"><br>
密码:<input name="password" type="password"><br>
<input type="submit" value="登录">
<a href="register.jsp">去注册</a>
<a href="login.jsp">我是管理员</a>
</form>

</body>
</html>
