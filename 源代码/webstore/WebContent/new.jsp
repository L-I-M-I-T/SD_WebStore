<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>
webstore
</title>
</head>
<body>

<form action="RegisterServlet" method="post">
<h2>新增用户界面</h2>
账号*:<input name="username" type="text"><br>
密码*:<input name="password" type="password"><br>
真实姓名:<input name="realname" type="text"><br>
性别:<input name="sex" type="text"><br>
地址:<input name="address" type="text"><br>
密保问题:<input name="question" type="text"><br>
密保答案:<input name="answer" type="text"><br>
电子邮箱:<input name="email" type="text"><br>
个人爱好:<input name="favorate" type="text"><br>
<input type="submit" value="创建">
</form>
</body>
</html>
