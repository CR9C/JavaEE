<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student?cmd=save" method="post">
	<%--传递一个隐藏域:hidden --%>
	<input type="hidden" name="id" value="${student.id}">
	<%--表单要做回写要有value属性 --%>
		姓名:<input type="text" name="name" value="${student.name}" required><br>
		年龄:<input type="number" name="age" value="${student.age}" required><br><br>
		<input type="submit" value=' ${student == null ?"新增学生信息":"更新学生信息"}'>
	</form> 
</body>
</html>