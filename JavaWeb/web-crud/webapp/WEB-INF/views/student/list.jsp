<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--添加要放到最上面,不能放到后面,否则如果没有一条数据就不能够添加 --%>
	<%--获取上下文路径 --%>
	<a href="${pageContext.request.contextPath}/student?cmd=edit">添加学生</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr style="background-color: orange">
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
	<%--写EL尽量删除前后空格,因为有时会当成字符串 --%>
	<c:forEach items="${student}" var="s" varStatus="vs">
		<tr style='background-color: ${vs.count % 2 == 0 ? "gray":""};'>
			<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.age }</td>
			<td>
				<%--第一个参数用?,之后的用& --%>
				<a href="${pageContext.request.contextPath}/student?cmd=delete&id=${s.id}">删除</a>	|
				<a href="${pageContext.request.contextPath}/student?cmd=edit&id=${s.id}">编辑</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>