<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
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
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.bnumber}</td>
			<td>${board.bwriter}</td>
			<td><a href="boardView?bnumber=${board.bnumber}">${board.btitle}</a></td>
			<td>${board.bdate}</td>
			<td>${board.bhits}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<button onclick="location.href='boardPostForm'">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>