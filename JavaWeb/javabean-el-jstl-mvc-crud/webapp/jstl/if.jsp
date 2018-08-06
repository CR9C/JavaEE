<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("num",30);
	%>
	<c:choose>
		<c:when test="${num>20}">num大于20</c:when>
		<c:when test="${num<20}">num小于20</c:when>
		<c:otherwise>num=20</c:otherwise>
	</c:choose>
	<hr>
	<c:if test="${num > 20}">
		num>20
	</c:if>
	<%--把boolean的结果保存到result作用域中,并且该变量保存到哪一个作用域中 --%>
	<c:if test="${num > 20}" var="result" scope="page"></c:if>
	${result }
</body>
</html>