<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardListPaging}" var="board">
		<tr>
		
			<td>${board.bnumber}</td>
			<td>${board.bwriter}</td>
			<td><a href="boardView?bnumber=${board.bnumber}&page=${paging.page}">${board.btitle}</a></td>
			<td>${board.bdate}</td>
			<td>${board.bhits}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<button onclick="location.href='boardPostForm.jsp'">글쓰기</button>
			</td>
		</tr>
	</table>
<c:if test="${paging.page<=1}">
	[이전]&nbsp;
	</c:if>
	<c:if test="${paging.page>1}">
		<a href="boardlistpaging?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>
	<c:forEach begin="${paging.startpage}" end="${paging.endpage}" var="i" step="1">
		<c:choose>
			<c:when test="${i eq paging.page}">
			${i}
		</c:when>
			<c:otherwise>
				<a href="boardlistpaging?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${paging.page>=paging.maxpage}">
[다음]
</c:if>
	<c:if test="${paging.page<paging.maxpage}">
		<a href="boardlistpaging?page=${paging.page+1}">[다음]</a>
	</c:if>
</body>
</html>