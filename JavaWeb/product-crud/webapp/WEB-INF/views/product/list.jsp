<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品显示列表</title>
</head>
<body>
	<a href="/product?cmd=edit">添加货品</a>
	<table border="1" cellpadding="0" cellspacing="0" width="90%">
		<tr style="background-color: orange;">
			<th>货品编号</th>
			<th>货品名称</th>
			<th>货品品牌</th>
			<th>货品分类</th>
			<th>供&nbsp;应&nbsp;商</th>
			<th>零&nbsp;售&nbsp;价</th>
			<th>成&nbsp;本&nbsp;价</th>
			<th>折&emsp;&emsp;扣</th>
			<th>操&emsp;&emsp;作</th>
		</tr>
		<c:forEach items="${products}" var="p" varStatus="vs">
		<tr style='background-color: ${vs.count % 2 == 0 ?"gray":""}'>
			<td>${p.id}</td>
			<td>${p.productName}</td>
			<td>${p.brand}</td>
			<td>${p.dir_id}</td>
			<td>${p.supplier}</td>
			<td>${p.salePrice}</td>
			<td>${p.costPrice}</td>
			<td>${p.cutoff}</td>
			<td>
				<a href="">编辑</a> |
				<a href="">删除</a>
		</tr>
		</c:forEach>
	</table>
</body>
</html>