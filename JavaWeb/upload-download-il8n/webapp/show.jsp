<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${u}
	
	注册名称:${u.username}<br>
	注册邮箱:${u.email}<br>
	头像原始名称:${u.imageName}
	头像:<br>
	<img src="${u.imageUrl}"> 
</body>
</html>