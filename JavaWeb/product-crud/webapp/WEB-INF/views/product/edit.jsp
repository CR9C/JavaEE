<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品编辑界面</title>
</head>
<body>
	<form action="/product?cmd=save" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>货品分类</td>
				<td><input type="text" name="productName" required></td>
			</tr>
			<tr>
				<td>货品品牌</td>
				<td><input type="text" name="brand" required></td>
			</tr>
			<tr>
				<td>供&nbsp;应&nbsp;商</td>
				<td><input type="text" name="supplier" required></td>
			</tr>
			<tr>
				<td>零&nbsp;售&nbsp;价</td>
				<td><input type="number" name="salePrice" required min="0"></td>
			</tr>
			<tr>
				<td>成&nbsp;本&nbsp;价</td>
				<td><input type="number" name="costPrice" required min="0"></td>
			</tr>
			<tr>
				<td>折&emsp;&emsp;扣</td>
				<td><input type="number" name="cutoff" required min="0" max="1"></td>
			</tr>
			<tr>
				<td>货品分类</td>
				<td>
					<select name="dir">
						<option value="aaa">AAA</option>
						<option value="bbb">AAA</option>
						<option value="ccc">AAA</option>
						<option value="ccc">AAA</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" value="保存"></td>
			</tr>
		</table>
	</form>
</body>
</html>