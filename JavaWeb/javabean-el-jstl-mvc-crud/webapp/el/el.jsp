<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--表示获取当前请求中参数名为username的参数值 --%>
	${param.username}
	<h3>Person对象的信息</h3>
	<br>username:${p.username}-->${p["username"]}-->${p.getUsername()}
	<br>age:${p.age}
	<br>hobbys:${p.hobbys[0]}
	<br>list:${p.list[1]}
	<br>map:${p.map}
	<br>map:${p.map.company}
	<br>map:${p.getMap()}
	<br>map:${p.map["www.xiaoma.com"] }
</body>
</html>