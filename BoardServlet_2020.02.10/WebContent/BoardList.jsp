<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>BoardList.jsp</h2>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.bNumber}</td>
			<td>${board.bWriter}</td>
			<td><a href="boardView?bNumber=${board.bNumber}">${board.bTitle}</a></td>
			<td>${board.bDate}</td>
			<td>${board.bHits}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<button onclick="location.href='BoardPost.jsp'">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>