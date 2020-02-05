<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DB 조회 내용 출력.</h3>
	<c:forEach var="result2" items="${selectResult}">
		${result2} <br>
	</c:forEach>
</body>
</html>