<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- mm이나 되돌아가야할 페이지에서 param을 써서 되돌려준다 -->
<h3>ReplyForm</h3>
<form  action="ReplyReg" method="post">
<input type="hidden" name="page" value="${param.page }">
<input type="hidden" name="bid" value="${dto.bid }">
	<table border="" width="100%">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="[Re]:${dto.title }" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" value="[Re]:${dto.pname }" /></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		
		
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="30" row="5">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="submit" value="답변">
			<input type="reset" value="초기화">
			<a href="Detail?bid=${dto.bid }&page=${param.page }">뒤로</a>
			</td>
		</tr>
	</table>
</form>
