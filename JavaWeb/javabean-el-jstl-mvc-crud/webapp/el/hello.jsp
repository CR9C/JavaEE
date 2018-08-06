<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	获取上下文路径:<br>
	<%=request.getContextPath() %><br>
	${pageContext.getRequest().getContextPath()}<br>
	<!-- getRequest()和getContextPath()方法都是公共的,没有参数,所以有下面的属性  -->
	${pageContext.request.contextPath}<br>
	
	\${1+3/2}: ${1+3/2}
	<br>
	<%
		//向当前page作用域设置共享数据
		pageContext.setAttribute("list",new ArrayList());
	%>
	
	${not empty list}<br>
	${!empty list}<br>
	
	${1 == 1 }<br>
	${1 eq 1 }<br>
	
	<%
		//JSP的四大作用域
		pageContext.setAttribute("msg","pageContextValue");
		request.setAttribute("msg","requestValue");
		session.setAttribute("msg","sessionValue");
		application.setAttribute("msg","applicationValue");
	%>
	<h3>使用EL获取不同作用域中的属性值</h3>
	pageContext:${pageScope.msg}<br>
	request:${requestScope.msg }<br>
	session:${sessionScope.msg }<br>
	application:${applicationScope.msg }<br>
	<h3>获取出每一个作用域中的数据</h3>
	pageContext:<%=pageContext.getAttribute("msg") %><br>
	request:<%=request.getAttribute("msg") %><br>
	session:<%=session.getAttribute("msg") %><br>
	application:<%=application.getAttribute("msg") %><br>
	<hr>
	<h3>pageContext的findAttribute方法</h3>
	<%=pageContext.findAttribute("msg") %><br>
	<%=pageContext.findAttribute("msg")==null?"":pageContext.findAttribute("msg") %><br>
	${msg}
</body>
</html>