<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>注册页面</h3>
	
	<span style="color: red;">${errorMsg}</span>
	<form action="/upload" method="post" enctype="multipart/form-data">
	<!-- 要提交必须要有name -->
		账号:<input type="text" name="username"><br>
		邮箱:<input type="text" name="email"><br>
		头像:<input type="file" name="headImg" accept="image/*"><br>
		<input type="submit" value=" 朕要注册">
	</form>
</body>
</html>