<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--需求1:从1输出到10,可用于分页
		1 2 3 4 5 6 7 8 9 10 
	 --%>
	 <c:forEach var="num" begin="1" end="10" step="1">
	 	${num}
	 </c:forEach>
	 
	 <%--需求2:迭代一个集合中所有的数据 --%>
	 <%
	 	pageContext.setAttribute("list", Arrays.asList("A","B","C","D"));
	 %>
	 <c:forEach items="${list}" var="ele">
	 	${ele}<br>
	 </c:forEach>
</body>
</html>