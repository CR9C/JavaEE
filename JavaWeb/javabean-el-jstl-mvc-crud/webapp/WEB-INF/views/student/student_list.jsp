<%@page import="com._520it.smis.domain.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> students = (List<Student>)request.getAttribute("students");
	%>
	学生列表
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>年龄</th>
		</tr>
		<%
			for(Student s: students) {
		%>
		<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getAge() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>