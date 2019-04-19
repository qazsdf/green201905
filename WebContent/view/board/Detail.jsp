<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Detail</h3>

<table border="" width="100%">
	<tr>
		<td>id</td><td>${dto.bid }</td>
	</tr><tr>
		<td>제목</td><td>${dto.title }</td>
	</tr><tr>
		<td>작성자</td><td>${dto.pname }</td>
	</tr><tr>
		<td>작성일</td><td>${dto.regdateStr }</td>
	</tr><tr>
		<td>조회수</td><td>${dto.no }</td>
	</tr>
<c:if test="${dto.seq==0 }">
		<tr><td>파일</td><td>${dto.upfile }</td>
	</tr> <!-- url기준으로 img를 불러온다. mvcProj/fff/파일 ../fff/파일  -->
</c:if>
		<tr><td>내용</td><td>${dto.contentBr }</td>
	</tr><tr>
		<td colspan="2" align="right">
			<a href="DeleteForm?bid=${dto.bid }&page=${param.page }">삭제</a>
			<a href="ModifyForm?bid=${dto.bid }&page=${param.page }">수정</a>
			<a href="ReplyForm?bid=${dto.bid }&page=${param.page }">답변</a>
			<a href="List?page=${param.page }">목록으로</a>
		</td>
	</tr>
<!-- 모든 페이지는 페이지 위치를 가져가야한다. -->
</table>
