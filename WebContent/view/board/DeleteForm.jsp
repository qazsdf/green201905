<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="DeleteReg" method="post">
<input type="hidden" name="bid" value="${param.bid }"/>
	<table>
		<tr>
			<td>암호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2"	align="right">
			<input type="submit" value="삭제">
			<a href="Detail?bid=${param.bid }&page=${param.page }">뒤로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>